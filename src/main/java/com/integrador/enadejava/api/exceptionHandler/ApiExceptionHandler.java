package com.integrador.enadejava.api.exceptionHandler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.*;
import org.flywaydb.core.internal.util.ExceptionUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
        } else if (rootCause instanceof PropertyBindingException) {
            return handlePropertyBindingException((PropertyBindingException) rootCause, headers, status, request);
        }

        ProblemType problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;

        String detail = Constantes.DETAIL_MENSAGEM_INCOMPREENSIVEL;

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (ex instanceof MethodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch(
                    (MethodArgumentTypeMismatchException) ex, headers, status, request);
        }

        return super.handleTypeMismatch(ex, headers, status, request);
    }

    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ProblemType problemType = ProblemType.URL_INXEXISTENTE;

        String detail = String.format(Constantes.URL_INXISTENTE, ex.getRequestURL());

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ProblemType problemType = ProblemType.ERRO_DE_SISTEMA;

        String detail = String.format(Constantes.ERRO_DE_SISTEMA);

        ex.printStackTrace();

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.PARAMETRO_INVALIDO;

        String detail = String.format(Constantes.PARAMETRO_URL_INVALIDO,
                ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName());

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, headers, status, request);

    }

    private ResponseEntity<Object> handleValidationInternal(Exception ex, BindingResult bindingResult, HttpHeaders headers,
                                                            HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.CAMPO_INVALIDO;
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        List<Problem.Object> problemObjects = bindingResult.getAllErrors().stream()
                .map(objectError -> {
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

                    String name = objectError.getObjectName();

                    if (objectError instanceof FieldError) {
                        name = ((FieldError) objectError).getField();
                    }

                    return Problem.Object.builder()
                            .name(name)
                            .userMessage(message)
                            .build();
                })
                .collect(Collectors.toList());

        Problem problem = creatProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .objects(problemObjects)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationInternal(ex, ex.getBindingResult(), headers, status, request);
    }


    private ResponseEntity<Object> handlePropertyBindingException(PropertyBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ProblemType problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;

        var propriedade =
                ex.getPropertyName();
        String detail =
                String.format(Constantes.CAMPO_NAO_DEVE_SER_INFORMADO, propriedade);
        Problem problem = creatProblemBuilder(status, problemType, detail).build();
        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ProblemType problemType = ProblemType.MENSAGEM_INCOMPREENSIVEL;

        var propriedade = joinPath(ex.getPath());
        var recebido = ex.getValue();
        var esperado = ex.getTargetType().getSimpleName();
        String detail =
                String.format(Constantes.TIPO_DE_CAMPO_DIVERGENTE, propriedade, recebido, esperado);
        Problem problem = creatProblemBuilder(status, problemType, detail).build();
        return handleExceptionInternal(ex, problem, headers, status, request);
    }


    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        if (body == null) {
            body = Problem.builder()
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();
        } else if (body instanceof String) {
            body = Problem.builder()
                    .title((String) body)
                    .status(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex,
                                                                  WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ProblemType problemType = ProblemType.ENTIDADE_NAO_ENCONTRADA;

        String detail = ex.getMessage();

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemType problemType = ProblemType.BUSINESS_EXCEPTION;

        String detail = ex.getMessage();

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }


    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException ex, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ProblemType problemType = ProblemType.ENTIDADE_ENTIDADE_EM_USO;

        String detail = ex.getMessage();

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    @ExceptionHandler(CampoObrigatorioException.class)
    public ResponseEntity<?> handleCampoObrigatorioException(CampoObrigatorioException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemType problemType = ProblemType.CAMPO_OBRIGATORIO;

        String detail = ex.getMessage();

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    @ExceptionHandler(UsuarioNaoEncontradaException.class)
    public ResponseEntity<?> handleUsuarioNaoEncontradaException(UsuarioNaoEncontradaException ex,
                                                                 WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ProblemType problemType = ProblemType.ENTIDADE_NAO_ENCONTRADA;

        String detail = ex.getMessage();

        Problem problem = creatProblemBuilder(status, problemType, detail).build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(),
                status, request);
    }

    private Problem.ProblemBuilder creatProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {
        return Problem
                .builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }

    private String joinPath(List<JsonMappingException.Reference> references) {
        return references.stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));
    }

}
