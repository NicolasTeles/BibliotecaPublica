package Modelo;

import java.time.LocalDate;

public class Emprestimo{
    private static final int TEMPO_ATRASO_MAXIMO = 10;
    private LocalDate dataInicial;
    private LocalDate vencimento;
    private String cpfOcupante;
    private boolean devolvido;
    private int id;

    public String getCpfOcupante() { return this.cpfOcupante; }
    public LocalDate getVencimento() { return this.vencimento; }
    public LocalDate getDataInicial() { return this.dataInicial; }
    public boolean getDevolvido(){ return this.devolvido; }
    public int getId(){ return this.id; }

    public void setCpfOcupante(String cpfOcupante){this.cpfOcupante = cpfOcupante; }
    public void setVencimento(LocalDate vencimento){this.vencimento = vencimento; }
    public void setDataInicial(LocalDate dataInicial){this.dataInicial = dataInicial; }
    public void setDevolvido(Boolean devolvido){this.devolvido = devolvido; }
    public void setId(int id){ this.id = id; }
}