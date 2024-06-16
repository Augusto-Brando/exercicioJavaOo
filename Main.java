import Models.Usuario;
import java.util.Scanner;

public class Main {
    private static GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private static GerenciadorCarros gerenciadorCarros = new GerenciadorCarros();
    private static GerenciadorAlugueis gerenciadorAlugueis = new GerenciadorAlugueis();
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioAtual;

    public static void main(String[] args) {
        // Adicionando alguns carros ao sistema
        gerenciadorCarros.adicionarCarro("ABC1234", "Toyota Corolla");
        gerenciadorCarros.adicionarCarro("XYZ5678", "Honda Civic");
        gerenciadorCarros.adicionarCarro("JKL9876", "Ford Focus");
        gerenciadorCarros.adicionarCarro("MNO6543", "Chevrolet Cruze");
        gerenciadorCarros.adicionarCarro("PQR3210", "Hyundai Elantra");

        while (true) {
            if (usuarioAtual == null) {
                System.out.println("1. Cadastrar");
                System.out.println("2. Login");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (escolha) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("1. Ver Carros");
                System.out.println("2. Alugar Carro");
                System.out.println("3. Ver Meus Aluguéis");
                System.out.println("4. Logout");
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (escolha) {
                    case 1:
                        verCarros();
                        break;
                    case 2:
                        alugarCarro();
                        break;
                    case 3:
                        verAlugueis();
                        break;
                    case 4:
                        usuarioAtual = null;
                        System.out.println("Logout realizado com sucesso.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }

    private static void cadastrar() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (gerenciadorUsuarios.cadastrarUsuario(nome, email, senha)) {
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Email já existe. Tente outro.");
        }
    }

    private static void login() {
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        usuarioAtual = gerenciadorUsuarios.loginUsuario(email, senha);
        if (usuarioAtual != null) {
            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioAtual.getNome() + ".");
        } else {
            System.out.println("Email ou senha inválidos. Tente novamente.");
        }
    }

    private static void verCarros() {
        for (Carro carro : gerenciadorCarros.getTodosCarros()) {
            System.out.println("Placa: " + carro.getPlaca() + ", Modelo: " + carro.getModelo() + ", Disponível: " + carro.isDisponivel());
        }
    }

    private static void alugarCarro() {
        System.out.print("Digite a placa do carro que deseja alugar: ");
        String placa = scanner.nextLine();
        Carro carro = gerenciadorCarros.getCarro(placa);

        if (carro != null) {
            gerenciadorAlugueis.alugarCarro(usuarioAtual, carro);
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    private static void verAlugueis() {
        System.out.println("Meus Aluguéis:");
        for (Aluguel aluguel : gerenciadorAlugueis.getAlugueisUsuario(usuarioAtual)) {
            System.out.println("Modelo do Carro: " + aluguel.getCarro().getModelo() + ", Data do Aluguel: " + aluguel.getDataAluguel());
        }
    }
}
