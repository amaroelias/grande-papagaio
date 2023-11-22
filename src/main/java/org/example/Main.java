package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrandePapagaio grandePapagaio = new GrandePapagaio();
        boolean sair = true;
        System.out.println("Bem-vindo ao Grande Papagaio!");

        while (sair) {
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Entrar como Usuário");
            System.out.println("3. Sair");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    System.out.println("Digite o nome do novo usuário:");
                    String nomeNovoUsuario = scanner.nextLine();
                    try {
                        grandePapagaio.adicionarUsuario(nomeNovoUsuario);
                        System.out.println("Usuário criado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Digite o nome do usuário existente:");
                    String nomeUsuarioExistente = scanner.nextLine();
                    try {
                        Usuario usuarioAtual = grandePapagaio.entrarUsuario(nomeUsuarioExistente);
                        // Menu de funcionalidades do usuário
                        System.out.println("1. Postar");
                        System.out.println("2. Seguir");
                        System.out.println("3. Deixar de seguir");
                        System.out.println("4. Ver perfil");
                        String escolhaFuncionalidadeUsuario = scanner.nextLine();
                        switch (escolhaFuncionalidadeUsuario) {
                            case "1":
                                System.out.println("Digite sua mensagem para postar:");
                                String mensagemPost = scanner.nextLine();
                                grandePapagaio.postar(nomeUsuarioExistente, mensagemPost);
                                System.out.println("Mensagem postada com sucesso!");
                                break;
                            case "2":
                                System.out.println("Digite o nome do usuário para seguir:");
                                String usuarioSeguir = scanner.nextLine();
                                try {
                                    grandePapagaio.seguir(nomeUsuarioExistente, usuarioSeguir);
                                    System.out.println("Você está seguindo " + usuarioSeguir + " agora!");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "3":
                                System.out.println("Digite o nome do usuário para deixar de seguir:");
                                String usuarioDeixarSeguir = scanner.nextLine();
                                try {
                                    grandePapagaio.deixarSeguir(nomeUsuarioExistente, usuarioDeixarSeguir);
                                    System.out.println("Você deixou de seguir " + usuarioDeixarSeguir + " agora!");
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case "4":
                                System.out.println(grandePapagaio.verPerfil(nomeUsuarioExistente));
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Saindo do sistema. Até logo!");
                    sair = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    escolha = scanner.nextLine();
            }
        }
    }
}
