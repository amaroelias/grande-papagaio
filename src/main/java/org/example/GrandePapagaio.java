package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class GrandePapagaio implements Serializable{
    private HashMap<String,Usuario> usuarios;

    public GrandePapagaio() {
        this.usuarios = new HashMap<>();
    }

    public void adicionarUsuario(String nome){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Nome de usuario não pode estar vázio!");
        }
        if(nome.length() < 3  || nome.matches("[0-9]+")){
            throw new IllegalArgumentException("Nome de usuario inválido!");
        }
        if(usuarios.containsKey(nome)){
            throw new IllegalArgumentException("Este nome já tem um usuario!");
        }
        Usuario usuario = new Usuario(nome);
        this.usuarios.put(nome, usuario);
    }

    public Usuario entrarUsuario(String nome){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Nome de usuario não pode estar vázio!");
        }
        if(nome.length() < 3  || nome.matches("[0-9]+")){
            throw new IllegalArgumentException("Nome de usuario inválido!");
        }
        if(!usuarios.containsKey(nome)){
            throw new IllegalArgumentException("Usuario não encontrado!");        }
        return this.usuarios.get(nome);
    }
    public void postar(String nomeUsuario, String mensagem){
        if(nomeUsuario == null || nomeUsuario.isEmpty()){
            throw new IllegalArgumentException("Nome de usuario não pode estar vázio!");
        }
        if(mensagem == null || mensagem.isEmpty()){
            throw new IllegalArgumentException("mensagem não pode estar vázia!");
        }
        if(!usuarios.containsKey(nomeUsuario)){
            throw new IllegalArgumentException("Usuario não encontrado!");
        }
        Post post = new Post(nomeUsuario, mensagem);
        this.usuarios.get(nomeUsuario).postar(post);
    }

    public void seguir(String usuarioAtual, String usuarioSeguir){
        if( usuarioAtual== null || usuarioAtual.isEmpty() || usuarioSeguir == null || usuarioSeguir.isEmpty()){
            throw new IllegalArgumentException("Nome de usuario não pode estar vázio!");
        }
        if(!usuarios.containsKey(usuarioAtual)){
            throw new IllegalArgumentException("Seu usuario não foi encontrado!");
        }
        if(!usuarios.containsKey(usuarioSeguir)){
            throw new IllegalArgumentException("O usuario para seguir não foi encontrado!");
        }
        this.usuarios.get(usuarioAtual).seguir(usuarios.get(usuarioSeguir));
    }

    public void deixarSeguir(String usuarioAtual, String usuarioSeguir){
        if( usuarioAtual== null || usuarioAtual.isEmpty() || usuarioSeguir == null || usuarioSeguir.isEmpty()){
            throw new IllegalArgumentException("Nome de usuario não pode estar vázio!");
        }
        if(!usuarios.containsKey(usuarioAtual)){
            throw new IllegalArgumentException("Seu usuario não foi encontrado!");
        }
        if(!usuarios.containsKey(usuarioSeguir)){
            throw new IllegalArgumentException("O usuario para seguir não foi encontrado!");
        }
        this.usuarios.get(usuarioAtual).deixarSeguir(usuarios.get(usuarioSeguir));
    }

    public String verPerfil(String nomeUsuario){
        if(nomeUsuario == null || nomeUsuario.isEmpty()){
            throw new IllegalArgumentException("Nome de usuario não pode estar vázio!");
        }
        if(!usuarios.containsKey(nomeUsuario)){
            throw new IllegalArgumentException("Usuario não encontrado!");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Usuário: "+ nomeUsuario+"\n"+ "Seguidores:\n" +usuarios.get(nomeUsuario).verSeguidores() +"\n"+"Perfil: \n" +"\n");
        stringBuilder.append(usuarios.get(nomeUsuario).verPerfil());
        for(Usuario usuario : this.usuarios.get(nomeUsuario).getSeguindo()){
            stringBuilder.append(usuario.verPerfil());
        }
        return stringBuilder.toString();
    }
    public void salvaDados(String nomeArquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static GrandePapagaio carregaDados(String nomeArquivo) {
        GrandePapagaio grandePapagaio = null;
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            grandePapagaio = (GrandePapagaio) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return grandePapagaio;
    }
}
