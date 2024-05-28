import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
public class SistemaDeIngressos {
    private List<Visitante> visitantes;
    public SistemaDeIngressos() {
        this.visitantes = new ArrayList<>();
    }
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar visitante");
            System.out.println("2. Listar visitantes");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do visitante:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o ano de nascimento:");
                    int anoNascimento = scanner.nextInt();
                    scanner.nextLine();  // consumir nova linha
                    System.out.println("Digite o telefone:");
                    String telefone = scanner.nextLine();
                    adicionarVisitante(nome, anoNascimento, telefone);
                    break;
                case 2:
                    listarVisitantes();
                    break;
            }
        }
    }
    public void adicionarVisitante(String nome, int anoNascimento, String telefone) {
        Visitante visitante;
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int idade = anoAtual - anoNascimento;

        if (idade < 12) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Visitante adicionado como criança.");
            System.out.println("Digite o nome do responsável:");
            String nomeResponsavel = scanner.nextLine();
            System.out.println("Digite o telefone do responsável:");
            String telefoneResponsavel = scanner.nextLine();
            visitante = new Crianca(nome, anoNascimento, nomeResponsavel, telefoneResponsavel);
        } else {
            System.out.println("Visitante adicionado como adulto.");
            visitante = new Adulto(nome, anoNascimento, telefone);
        }

        visitantes.add(visitante);
    }

    public void listarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("Nenhum visitante cadastrado.");
        } else {
            System.out.println("Lista de visitantes:");
            for (Visitante visitante : visitantes) {
                System.out.println("Nome: " + visitante.getNome() + ", Ano de Nascimento: " + visitante.getAnoNascimento());
            }
        }
    }
}

