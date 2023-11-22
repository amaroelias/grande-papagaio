package org.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Post> postagens;
    private List<Usuario> seguindo;

    public Usuario(String nome) {
        this.nome = nome;
        this.postagens = new ArrayList<>();
        this.seguindo = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Post> getPostagens() {
        return postagens;
    }

    public List<Usuario> getSeguindo() {
        return seguindo;
    }
    public void seguir(Usuario usuario){
        this.seguindo.add(usuario);
    }
    public void deixarSeguir(Usuario usuario){
        this.seguindo.remove(usuario);
    }

    public String verPerfil(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Post post : getPostagens()){
            stringBuilder.append(post.toString()+"\n");
        }
        return stringBuilder.toString();
    }
    public String verSeguidores(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Usuario usuario : getSeguindo()){
            stringBuilder.append(usuario.getNome()+"\n");
        }
        return stringBuilder.toString();
    }
    public void postar(Post post){
        this.postagens.add(post);
    }

}
