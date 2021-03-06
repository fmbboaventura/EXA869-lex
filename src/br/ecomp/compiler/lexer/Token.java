package br.ecomp.compiler.lexer;

/**
 * @author Filipe Boaventura
 * @since 27/07/2016.
 */
public class Token {

    public enum TokenType {
        ATRIB      ("Atribuicao \"<<\""),
        IDENTIFIER ("Identificador"),
        CHARACTER  ("Caractere"),
        NUMBER     ("Numero"),
        BOOL_V     ("Valor Booleano"),
        CHAR_STRING("Cadeia de Caracteres"),
        COMMENT    ("Comentario"),
        VEC_DELIM_L("Delimitador \"<<<\""),
        VEC_DELIM_R("Delimitador \">>>\""),
        PAREN_L    ("Delimitador \"(\""),
        PAREN_R    ("Delimitador \")\""),
        COMMA      ("Delimitador \",\""),
        SEMICOLON  ("Delimitador \";\""),
        PLUS ("Operador Aritmetico \"+\""),
        MINUS("Operador Aritmetico \"-\""),
        TIMES("Operador Aritmetico \"*\""),
        DIV  ("Operador Aritmetico \"\\\""),
        EQ ("Operador Relacional \"=\""),
        NEQ("Operador Relacional \"<>\""),
        LT ("Operador Relacional \"<\""),
        LE ("Operador Relacional \"<=\""),
        GT ("Operador Relacional \">\""),
        GE ("Operador Relacional \">=\""),
        E  ("Operador Booleano \"e\""),
        OU ("Operador Booleano \"ou\""),
        NAO("Operador Booleano \"nao\""),
        INTEIRO  ("Tipo de Dados \"inteiro\""),
        REAL     ("Tipo de Dados \"real\""),
        BOOLEANO ("Tipo de Dados \"booleano\""),
        CARACTERE("Tipo de Dados \"caractere\""),
        CADEIA   ("Tipo de Dados \"cadeia\""),
        PROGRAMA("Palavra Reservada \"programa\""),
        CONST   ("Palavra Reservada \"const\""),
        VAR     ("Palavra Reservada \"var\""),
        FUNCAO  ("Palavra Reservada \"funcao\""),
        INICIO  ("Palavra Reservada \"inicio\""),
        FIM     ("Palavra Reservada \"fim\""),
        SE      ("Palavra Reservada \"se\""),
        SENAO   ("Palavra Reservada \"senao\""),
        ENTAO   ("Palavra Reservada \"entao\""),
        ENQUANTO("Palavra Reservada \"enquanto\""),
        FACA    ("Palavra Reservada \"faca\""),
        LEIA    ("Palavra Reservada \"leia\""),
        ESCREVA ("Palavra Reservada \"escreva\""),
        INVALID_COMMENT    ("Comentario Mal Formado"),
        INVALID_SYMBOL     ("Simbolo Invalido"),
        INVALID_CHAR_STRING("Cadeia de Caracteres Mal Formada"),
        INVALID_CHARACTER  ("Caractere Mal formado"),
        INVALID_IDENTIFIER ("Identificador Mal Formado"),
        INVALID_NUMBER     ("Numero Mal Formado"),
        INVALID            ("Token Invalido");

        private final String name;

        TokenType (String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    private int line;
    private String lexeme;
    private TokenType type;

    protected Token(int line, String lexeme) {
        this.line = line;
        this.lexeme = lexeme;
        this.type = TokenType.INVALID;
    }

    public Token(int line, String lexeme, TokenType type) {
        this(line, lexeme);
        this.type = type;
    }

    protected void setType(TokenType type) {
        this.type = type;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString() {
        String typeName  = type.toString();
        if (typeName.indexOf('\"') != -1)
            typeName = typeName.substring(0, typeName.indexOf('\"')-1);
        return String.format("Linha %02d %s %s", line, getLexeme(), typeName);
    }
}
