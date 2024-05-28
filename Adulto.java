public class Adulto extends Visitante {
    private String telefone;

    public Adulto(String nome, int anoNascimento, String telefone) {
        super(nome, anoNascimento);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
}