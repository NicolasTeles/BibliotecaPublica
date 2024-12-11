package Modelo;

public class Livro {
    private int id;
    private String nome;
    private String editora;
    private String autor;
    private int anoPubli;
    private boolean status;
    private int totalAvaliacao;
    private int numAvaliacoes;

    public Livro(){
        this.nome = "";
        this.editora = "";
        this.autor = "";
        this.anoPubli = 0;
        this.status = false;
        this.totalAvaliacao = -1;
        this.id = -1;
        this.numAvaliacoes = 0;
    }

    public Livro(String nome, String editora, String autor, int anoPubli){
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.anoPubli = anoPubli;
        this.status = true;
        this.totalAvaliacao = 0;
        this.id = 0;
        this.numAvaliacoes = 0;
    }

    public String getNome() { return nome; }

    public String getEditora() { return editora; }

    public String getAutor() { return autor; }

    public int getAnoPubli() { return anoPubli; }

    public boolean getStatus() { return status; }

    public int getTotalAvaliacao() { return totalAvaliacao; }

    public int getNumAvaliacoes(){
        return this.numAvaliacoes;
    }

    public void setNome(String nome) { this.nome = nome; }

    public void setEditora(String editora) { this.editora = editora; }

    public void setAutor(String autor) { this.autor = autor; }

    public void setAnoPubli(int anoPubli) { this.anoPubli = anoPubli; }

    public void setStatus(boolean status) { this.status = status; }

    public void setTotalAvaliacao(int totalAvaliacao) { this.totalAvaliacao = totalAvaliacao; }

    public void setNumAvaliacoes(int numAvaliacoes){
        this.numAvaliacoes = numAvaliacoes;
    }

    public double mediaAvaliacao(){
        if(this.numAvaliacoes == 0)
            return -1;
        else
            return (double)(this.totalAvaliacao)/(double)(this.numAvaliacoes);
    }

    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return this.id;
    }
}
