package Modelo;

import java.time.LocalDate;

public class Emprestimo{
    private int id;
    private LocalDate dataInicial;
    private Livro livro;
    private LocalDate vencimento;
    private String cpfOcupante;
    private boolean devolvido;

    public Emprestimo(LocalDate dataInicial, LocalDate vencimento, String cpfOcupante, boolean devolvido, int id, Livro livro){
        this.dataInicial = dataInicial;
        this.vencimento = vencimento;
        this.cpfOcupante = cpfOcupante;
        this.devolvido = devolvido;
        this.id = id;
        this.livro = livro;
    }

    public Emprestimo(){
        this.dataInicial = null;
        this.vencimento = null;
        this.cpfOcupante = "";
        this.devolvido = false;
        this.id = 0;
        this.livro = null;
    }

    public String getCpfOcupante() { return this.cpfOcupante; }
    public LocalDate getVencimento() { return this.vencimento; }
    public LocalDate getDataInicial() { return this.dataInicial; }
    public Livro getLivro(){ return this.livro; }
    public boolean getDevolvido(){ return this.devolvido; }
    public int getId(){ return this.id; }
    public void setCpfOcupante(String cpfOcupante){this.cpfOcupante = cpfOcupante; }
    public void setVencimento(LocalDate vencimento){this.vencimento = vencimento; }
    public void setDataInicial(LocalDate dataInicial){this.dataInicial = dataInicial; }
    public void setDevolvido(Boolean devolvido){this.devolvido = devolvido; }
    public void setId(int id){ this.id = id; }
    public void setLivro(Livro livro){ this.livro = livro; }

    //teste da comparacao
}