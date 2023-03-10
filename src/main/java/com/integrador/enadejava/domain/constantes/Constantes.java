package com.integrador.enadejava.domain.constantes;

public abstract class Constantes {

    protected Constantes() {}

    public static final String URI = "https://www.algafood.com.br";

    public static final String PATCH_ENTIDADE_NAO_ENCONTRADA = "/entidade-nao-encontrada";
    public static final String PATCH_URL_INXEXISTENTE = "/url-nao-existente";
    public static final String PATCH_ERRO_DE_SISTEMA = "/erro-de-sistema";
    public static final String PATCH_BUSINESS_EXCEPTION = "/regras-de-negocio";
    public static final String PATCH_ENTIDADE_EM_USO = "/entidade-em-uso";
    public static final String PATCH_CAMPO_OBRIGATORIO = "/campo-obrigatorio";
    public static final String PATCH_PARAMETRO_INVALIDO = "/parametro-invalido";
    public static final String PATCH_MENSAGEM_INCOMPREENSIVEL = "/mensagem-incompreensivel";

    public static final String ENTIDADE_EM_USO = "A entidade [{%s}] de id:[{%d}] está em uso por outras Entidades, não pode ser excluida.";
    public static final String ERRO_DE_SISTEMA = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se o problema persistir, entre em contato com o administrador do sistema";
    public static final String CAMPO_OBRIGATORIO_ERRO = "A entidade [{%s}], possui o campo [{%s}] obrigatório!";
    public static final String CIDADE_NAO_ENCONTRADA = "A cidade de id [{%d}] não existe no banco de Dados!";
    public static final String COZINHA_NAO_ENCONTRADA = "A cozinha de id [{%d}] não existe no banco de Dados!";
    public static final String ENDERECO_NAO_ENCONTRADO = "O endereço de id [{%d}] não existe no banco de Dados!";
    public static final String ESTADO_NAO_ENCONTRADO = "O estado de id [{%d}] não existe no banco de Dados!";
    public static final String FORMA_PAGAMENTO_NAO_ENCONTRADA = "A forma de pagamento de id [{%d}] não existe no banco de Dados!";
    public static final String GRUPO_NAO_ENCONTRADO = "Grupo de id [{%d}] não existe no banco de Dados!";
    public static final String ITEM_PEDIDO_NAO_ENCONTRADO = "Item de id [{%d}] não existe no banco de Dados!";
    public static final String PAIS_NAO_ENCONTRADO = "Pais de id [{%d}] não existe no banco de Dados!";
    public static final String PEDIDO_NAO_ENCONTRADO = "Pedido de id [{%d}] não existe no banco de Dados!";
    public static final String PERMISSAO_NAO_ENCONTRADA = "Permissao de id [{%d}] não existe no banco de Dados!";
    public static final String PRODUTO_NAO_ENCONTRADO = "Produto de id [{%d}] não existe no banco de Dados!";
    public static final String REGIAO_NAO_ENCONTRADA = "Região de id [{%d}] não existe no banco de Dados!";
    public static final String RESTAURANTE_NAO_ENCONTRADO = "Restaurante de id [{%d}] não existe no banco de Dados!";
    public static final String USUARIO_NAO_ENCONTRADO = "Usuario de id [{%d}] não existe no banco de Dados!";
    public static final String TIPO_DE_CAMPO_DIVERGENTE = "A propiedade [{%s}] recebeu o valor [{%s}], que é um tipo inválido. Corrija e informe um valor compatível com o tipo [{%s}].";
    public static final String CAMPO_NAO_DEVE_SER_INFORMADO = "O campo [{%s}] não deve ser informado no corpo da requisiçao";
    public static final String URL_INXISTENTE = "A url [{%s}] não existe no sistema, verifique-a e tente novamente";
    public static final String PARAMETRO_URL_INVALIDO = "O parâmetro de URL [{%s}] recebeu o valor [{%s}], que é de um tipo inválido. Corrija e informe um valor compatível com o tipo [{%s}].";

    public static final String TITLE_ERRO_DE_SISTEMA = "Erro no sistema";
    public static final String TITLE_BUSINESS_EXCEPTION = "Regra de negocio";
    public static final String TITLE_URL_INXEXISTENTE = "A url informada não existe";
    public static final String TITLE_ENTIDADE_NAO_ENCONTRADA = "Entidade não encontrada";
    public static final String TITLE_ENTIDADE_EM_USO = "Entidade em uso";
    public static final String TITLE_CAMPO_OBRIGATORIO = "Campo Obrigatório";
    public static final String TITLE_MENSAGEM_INCOMPREENSIVEL = "Mensagem incompreensivel";
    public static final String TITLE_PARAMETRO_URL_INVALIDO = "O parâmetro de URL '%s' recebeu o valor '%s', que é de um tipo inválido. Corrija e informe um valor compatível com o tipo [{%s}].";
    public static final String DETAIL_MENSAGEM_INCOMPREENSIVEL = "Corpo da reqeuisição está inválido. Verifique erro de sintaxe.";
    public static final String MENSAGEM_ERRO_GENERIO_USUARIO_FINAL = "Ocorreu um erro no sistema, tente novamente!";
}