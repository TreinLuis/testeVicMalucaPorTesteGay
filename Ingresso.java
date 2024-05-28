import java.text.SimpleDateFormat;
import java.util.Date;

public class Ingresso {
    private String id;
    private Date data;
    private Visitante visitante;
    private Atracao atracao;
    private double preco;

    public Ingresso(String id, Date data, Visitante visitante, Atracao atracao, double preco) {
        this.id = id;
        this.data = data;
        this.visitante = visitante;
        this.atracao = atracao;
        this.preco = preco;
    }

    public Ingresso(String id, Date data, Visitante visitante,double preco) {
        this.id = id;
        this.data = data;
        this.visitante = visitante;
        this.preco = preco;
    }


    public String getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Atracao getAtracao() {
        return atracao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Ingresso{id='" + id + "', data=" + sdf.format(data) + ", visitante=" + visitante.getNome() + ", atracao=" + atracao.getNome() + ", preco=" + preco + '}';
    }
}