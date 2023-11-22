package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrandePapagaio grandePapagaio = new GrandePapagaio();

        while (true) {
            System.out.println("Bem-vindo ao Grande Papagaio!");
            System.out.println("1. Entrar como Administrador");
            System.out.println("2. Entrar como Usuário");
            System.out.println("3. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a senha de administrador:");
                    String senhaAdmin = scanner.next();
                    if (senhaAdmin.equals("12345678")) {
                        // Menu de funcionalidades do administrador
                        System.out.println("1. Remover usuário");
                        System.out.println("Digite o nome do usuário a ser removido:");
                        String nomeUsuarioRemover = scanner.next();
                        try {System.out.println("Usuário removido com sucesso!");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        // Adicione mais opções conforme necessário para o administrador
                        // ...
                    } else {
                        System.out.println("Senha de administrador incorreta. Tente novamente.");
                    }
                    break;
                case 2:
                    System.out.println("1. Criar novo usuário");
                    System.out.println("2. Entrar como usuário existente");
                    int escolhaUsuario = scanner.nextInt();
                    switch (escolhaUsuario) {
                        case 1:
                            System.out.println("Digite o nome do novo usuário:");
                            String nomeNovoUsuario = scanner.next();
                            try {
                                grandePapagaio.adicionarUsuario(nomeNovoUsuario);
                                System.out.println("Usuário criado com sucesso!");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            System.out.println("Digite o nome do usuário existente:");
                            String nomeUsuarioExistente = scanner.next();
                            try {
                                Usuario usuarioAtual = grandePapagaio.entrarUsuario(nomeUsuarioExistente);
                                // Menu de funcionalidades do usuário
                                System.out.println("1. Postar");
                                System.out.println("2. Seguir");
                                System.out.println("3. Deixar de seguir");
                                System.out.println("4. Ver perfil");
                                int escolhaFuncionalidadeUsuario = scanner.nextInt();
                                switch (escolhaFuncionalidadeUsuario) {
                                    case 1:
                                        System.out.println("Digite sua mensagem para postar:");
                                        String mensagemPost = scanner.next();
                                        grandePapagaio.postar(nomeUsuarioExistente, mensagemPost);
                                        System.out.println("Mensagem postada com sucesso!");
                                        break;
                                    case 2:
                                        System.out.println("Digite o nome do usuário para seguir:");
                                        String usuarioSeguir = scanner.next();
                                        try {
                                            grandePapagaio.seguir(nomeUsuarioExistente, usuarioSeguir);
                                            System.out.println("Você está seguindo " + usuarioSeguir + " agora!");
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Digite o nome do usuário para deixar de seguir:");
                                        String usuarioDeixarSeguir = scanner.next();
                                        try {
                                            grandePapagaio.deixarSeguir(nomeUsuarioExistente, usuarioDeixarSeguir);
                                            System.out.println("Você deixou de seguir " + usuarioDeixarSeguir + " agora!");
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 4:
                                        System.out.println(grandePapagaio.verPerfil(nomeUsuarioExistente));
                                        break;
                                    default:
                                        System.out.println("Opção inválida.");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
