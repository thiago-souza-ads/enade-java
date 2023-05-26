package com.integrador.enadejava.api.exceptionHandler;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrador.enadejava.domain.constantes.Constantes;
import lombok.Builder;
import lombok.Getter;
import java.util.Date;

import java.util.List;

/**
 * Descrição da classe de modelagem de erro seguindo a RFC 7807
 * Status : Código de Status HTTP da resposta
 * Type: Uri que especifica o tipo do problema
 * Title: Descrição do tipo especifico do problema
 * Detail: Descrição especifica do erro do problem
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Problem {
    private Integer status;
    private String type;
    private String title;
    private String detail;

    private String userMessage;
    private Date timestamp;

    private List<Object> objects;


    @Getter
    @Builder
    public static class Object {
        private String name;
        private String userMessage;
    }

    public String getUserMessage() {
        return this.userMessage != null ?
                this.userMessage :
                Constantes.MENSAGEM_ERRO_GENERIO_USUARIO_FINAL;
    }

    public Date getTimestamp() {
        return this.userMessage != null ?
                this.timestamp :
                new Date();
    }

}
