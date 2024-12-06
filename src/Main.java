import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            try {
                mostrarMenuPrincipal();
                int perfil = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (perfil) {
                    case 1:
                        menuFuncionario(scanner, biblioteca);
                        break;

                    case 2:
                        menuCliente(scanner, biblioteca);
                        break;

                    case 3:
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada! Por favor, insira um número válido.");
                scanner.nextLine(); // Limpar buffer do scanner
            }
        }
    }

    // Método para mostrar o menu principal
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema da Biblioteca ---");
        System.out.println("Você é:");
        System.out.println("1. Funcionário");
        System.out.println("2. Cliente");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método para o menu do Funcionário
    private static void menuFuncionario(Scanner scanner, Biblioteca biblioteca) {
        while (true) {
            System.out.println("\n--- Menu Funcionário ---");
            System.out.println("1. Incluir Livro");
            System.out.println("2. Incluir Revista");
            System.out.println("3. Incluir Sala");
            System.out.println("4. Listar acervo");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcaoFuncionario = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            try {
                switch (opcaoFuncionario) {
                    case 1:
                        incluirLivro(scanner, biblioteca);
                        break;

                    case 2:
                        incluirRevista(scanner, biblioteca);
                        break;

                    case 3:
                        incluirSala(scanner, biblioteca);
                        break;

                    case 4:
                        biblioteca.listarAcervo();
                        break;

                    case 5:
                        System.out.println("Voltando ao menu principal...");
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada! Por favor, insira um número válido.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }
    }

    // Método para incluir um livro
    private static void incluirLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro: ");
        String tituloLivro = scanner.nextLine();

        int anoLivro = 0;
        boolean entradaValida = false;

        // Tratamento de exceção para o ano do livro
        while (!entradaValida) {
            try {
                System.out.print("Digite o ano de publicação: ");
                anoLivro = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                if (anoLivro < 1500 || anoLivro > 2024) {
                    throw new IllegalArgumentException("Ano de publicação inválido.");
                }
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        System.out.print("Digite o gênero do livro: ");
        String generoLivro = scanner.nextLine();
        Livro novoLivro = new Livro(tituloLivro, anoLivro, generoLivro);
        biblioteca.adicionarItem(novoLivro);
        System.out.println("Livro adicionado com sucesso!");
    }

    // Método para incluir uma revista
    private static void incluirRevista(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título da revista: ");
        String tituloRevista = scanner.nextLine();

        int anoRevista = 0;
        boolean entradaValida = false;

        // Tratamento de exceção para o ano da revista
        while (!entradaValida) {
            try {
                System.out.print("Digite o ano de publicação: ");
                anoRevista = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                if (anoRevista < 1500 || anoRevista > 2024) {
                    throw new IllegalArgumentException("Ano de publicação inválido.");
                }
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        System.out.print("Digite a edição da revista: ");
        String edicaoRevista = scanner.nextLine();
        Revista novaRevista = new Revista(tituloRevista, anoRevista, edicaoRevista, true);
        biblioteca.adicionarItem(novaRevista);
        System.out.println("Revista adicionada com sucesso!");
    }

    // Método para incluir uma sala
    private static void incluirSala(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o nome da sala: ");
        String nomeSala = scanner.nextLine();
        System.out.print("Digite a capacidade da sala: ");
        int capacidadeSala = scanner.nextInt();
        scanner.nextLine();
        System.out.print("A sala possui suporte para videochamada? (true/false): ");
        boolean videochamada = scanner.nextBoolean();
        scanner.nextLine();  // Consumir a quebra de linha
        SalaDeReuniao novaSala = new SalaDeReuniao(nomeSala, capacidadeSala, videochamada);
        biblioteca.adicionarSala(novaSala);
        System.out.println("Sala adicionada com sucesso!");
    }

    // Método para o menu do Cliente
    private static void menuCliente(Scanner scanner, Biblioteca biblioteca) {
        while (true) {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1. Emprestar Livro");
            System.out.println("2. Emprestar Revista");
            System.out.println("3. Devolver Livro");
            System.out.println("4. Devolver Revista");
            System.out.println("5. Reservar Sala");
            System.out.println("6. Listar acervo");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcaoCliente = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (opcaoCliente) {
                case 1:
                    emprestarLivro(scanner, biblioteca);
                    break;

                case 2:
                    emprestarRevista(scanner, biblioteca);
                    break;

                case 3:
                    devolverLivro(scanner, biblioteca);
                    break;

                case 4:
                    devolverRevista(scanner, biblioteca);
                    break;

                case 5:
                    reservarSala(scanner, biblioteca);
                    break;

                case 6:
                    biblioteca.listarAcervo();
                    break;

                case 7:
                    System.out.println("Voltando ao menu principal...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para emprestar livro
    private static void emprestarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro para empréstimo: ");
        String tituloLivroEmprestimo = scanner.nextLine();
        boolean livroEncontrado = false;
        for (Item item : biblioteca.getAcervo()) {
            if (item != null && item instanceof Livro && item.getTitulo().equalsIgnoreCase(tituloLivroEmprestimo)) {
                ((Livro) item).emprestar();
                livroEncontrado = true;
                break;
            }
        }
        if (!livroEncontrado) {
            System.out.println("Livro não encontrado no acervo.");
        }
    }

    // Método para emprestar revista
    private static void emprestarRevista(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título da revista para empréstimo: ");
        String tituloRevistaEmprestimo = scanner.nextLine();
        boolean revistaEncontrada = false;
        for (Item item : biblioteca.getAcervo()) {
            if (item != null && item instanceof Revista && item.getTitulo().equalsIgnoreCase(tituloRevistaEmprestimo)) {
                ((Revista) item).emprestar();
                revistaEncontrada = true;
                break;
            }
        }
        if (!revistaEncontrada) {
            System.out.println("Revista não encontrada no acervo.");
        }
    }

    // Método para devolver livro
    private static void devolverLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título do livro para devolução: ");
        String tituloLivroDevolucao = scanner.nextLine();
        for (Item item : biblioteca.getAcervo()) {
            if (item != null && item instanceof Livro && item.getTitulo().equalsIgnoreCase(tituloLivroDevolucao)) {
                ((Livro) item).devolver();
                break;
            }
        }
    }

    // Método para devolver revista
    private static void devolverRevista(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o título da revista para devolução: ");
        String tituloRevistaDevolucao = scanner.nextLine();
        for (Item item : biblioteca.getAcervo()) {
            if (item != null && item instanceof Revista && item.getTitulo().equalsIgnoreCase(tituloRevistaDevolucao)) {
                ((Revista) item).devolver();
                break;
            }
        }
    }

    // Método para reservar sala
    private static void reservarSala(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Digite o nome da sala para reserva: ");
        String nomeSalaReserva = scanner.nextLine();
        System.out.print("Digite a data do evento (Formato: dd/MM/yyyy): ");
        String dataEvento = scanner.nextLine();

        boolean salaEncontrada = false;
        for (Salas sala : biblioteca.getSalas()) {
            if (sala != null && sala.getNome().equalsIgnoreCase(nomeSalaReserva)) {
                sala.reservar(nomeSalaReserva, dataEvento);
                salaEncontrada = true;
                break;
            }
        }
        if (!salaEncontrada) {
            System.out.println("Sala não encontrada.");
        }
    }
}
