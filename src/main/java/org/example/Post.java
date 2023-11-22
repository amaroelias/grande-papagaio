package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private LocalDateTime data;
    private String nomeUsuario;
    private String mensagem;

    public Post(String nomeUsuario, String mensagem) {
        this.data = LocalDateTime.now();
        this.nomeUsuario = nomeUsuario;
        this.mensagem = mensagem;
    }

    public String getData() {
        DateTimeFormatter modeloFormatado = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dataFormatada = data.format(modeloFormatado);
        return dataFormatada;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return getNomeUsuario()+" --> "+getMensagem()+" ("+getData()+")";
    }
}
