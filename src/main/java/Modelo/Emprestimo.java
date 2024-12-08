package Modelo;

import java.time.LocalDate;

public class Emprestimo{
    private static final int TEMPO_ATRASO_MAXIMO = 10;
    private LocalDate dataInicial;
    private Livro Book;
    private LocalDate vencimento;
    private String cpfOcupante;
    private boolean devolvido;
    private int id;

    public Emprestimo(LocalDate dataInicial, LocalDate vencimento, String cpfOcupante, boolean devolvido, int id, Livro book){
        this.dataInicial = dataInicial;
        this.vencimento = vencimento;
        this.cpfOcupante = cpfOcupante;
        this.devolvido = devolvido;
        this.id = id;
        this.Book = book;
    }

    public Emprestimo(){
        this.dataInicial = null;
        this.vencimento = null;
        this.cpfOcupante = "";
        this.devolvido = false;
        this.id = 0;
        this.Book = null;
    }

    public String getCpfOcupante() { return this.cpfOcupante; }
    public LocalDate getVencimento() { return this.vencimento; }
    public LocalDate getDataInicial() { return this.dataInicial; }
    public Livro getBook(){ return  this.Book; }
    public boolean getDevolvido(){ return this.devolvido; }
    public int getId(){ return this.id; }

    public void setCpfOcupante(String cpfOcupante){this.cpfOcupante = cpfOcupante; }
    public void setVencimento(LocalDate vencimento){this.vencimento = vencimento; }
    public void setDataInicial(LocalDate dataInicial){this.dataInicial = dataInicial; }
    public void setDevolvido(Boolean devolvido){this.devolvido = devolvido; }
    public void setId(int id){ this.id = id; }
    public void setBook(Livro book){ this.Book = book; }
}