import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaDeIngressos {
    private List<Visitante> visitantes;
    private List<Ingresso> ingressos;
    private int contadorIngressos;

    public SistemaDeIngressos() {
        this.visitantes = new ArrayList<>();
        this.ingressos = new ArrayList<>();
        this.contadorIngressos = 0;
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar visitante");
            System.out.println("2. Listar visitantes");
            System.out.println("3. Emitir ingresso");
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
                case 3:
                    System.out.println("Digite o nome do visitante para emitir o ingresso:");
                    String nomeVisitanteIngresso = scanner.nextLine();
                    Visitante visitanteIngresso = encontrarVisitantePorNome(nomeVisitanteIngresso);
                    if (visitanteIngresso != null) {
                        emitirIngresso(new Date(), visitanteIngresso);
                    } else {
                        System.out.println("Visitante não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
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

    public Visitante encontrarVisitantePorNome(String nome) {
        for (Visitante visitante : visitantes) {
            if (visitante.getNome().equalsIgnoreCase(nome)) {
                return visitante;
            }
        }
        return null;
    }

    public void emitirIngresso(Date data, Visitante visitante) {
        if (data == null || visitante == null) {
            System.out.println("Dados de entrada inválidos.");
            return;
        }

        if (contadorIngressos < 500) {
            double preco = (visitante instanceof Crianca) ? 80.00 : 100.00;
            String id = new SimpleDateFormat("ddMMyyyy").format(data) + String.format("%03d", ++contadorIngressos);
            Ingresso ingresso = new Ingresso(id, data, visitante, preco);
            ingressos.add(ingresso);
            System.out.println("Ingresso emitido: " + ingresso);
        } else {
            System.out.println("Limite de ingressos atingido para o dia.");
        }
    }
}
