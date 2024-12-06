package Modelo;

public class Emprestimo{
    private String dataInicial;
    private String vencimento;
    private String cpfOcupante;

    public String getCpfOcupante() { return cpfOcupante; }
    public String getVencimento() { return vencimento; }
    public String getDataInicial() { return dataInicial; }

    public void setCpfOcupante(String cpfOcupante){this.cpfOcupante = cpfOcupante; }
    public void setVencimento(String vencimento){this.vencimento = vencimento; }
    public void setDataInicial(String dataInicial){this.dataInicial = dataInicial; }



}