package Modelo;

public class Livro {
    private String nome;
    private String editora;
    private String autor;
    private int anoPubli;
    private boolean status;
    private double avaliacao;
    private String cpfClienteOcupante;

    public Livro(){
        this.nome = "";
        this.editora = "";
        this.autor = "";
        this.anoPubli = 0;
        this.status = false;
        this.avaliacao = -1;
        this.cpfClienteOcupante = "";
    }

    public Livro(String nome, String editora, String autor, int anoPubli){
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.anoPubli = anoPubli;
        this.status = true;
        this.avaliacao = 0;
        this.cpfClienteOcupante = "";
    }

    public String getNome() { return nome; }

    public String getEditora() { return editora; }

    public String getAutor() { return autor; }

    public int getAnoPubli() { return anoPubli; }

    public boolean getStatus() { return status; }

    public double getAvaliacao() { return avaliacao; }

    public String getCpfClienteOcupante() { return cpfClienteOcupante; }

    public void setNome(String nome) { this.nome = nome; }

    public void setEditora(String editora) { this.editora = editora; }

    public void setAutor(String autor) { this.autor = autor; }

    public void setAnoPubli(int anoPubli) { this.anoPubli = anoPubli; }

    public void setStatus(boolean status) { this.status = status; }

    public void setAvaliacao(double avaliacao) { this.avaliacao = avaliacao; }

    public void setCpfClienteOcupante(String cpf){ this.cpfClienteOcupante = cpf; }
}
