public class Atracao {
    private String nome;
    private int visitantes;

    public Atracao(String nome) {
        this.nome = nome;
        this.visitantes = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVisitantes() {
        return visitantes;
    }

    public void adicionarVisitante() {
        this.visitantes++;
    }
}