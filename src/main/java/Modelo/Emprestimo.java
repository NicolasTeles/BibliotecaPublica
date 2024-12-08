package Modelo;

import java.time.LocalDate;

public class Emprestimo{
    private int id;
    private LocalDate dataInicial;
    private Livro livro;
    private LocalDate vencimento;
    private Cliente cliente;
    private boolean devolvido;

    public Emprestimo(LocalDate dataInicial, LocalDate vencimento, Cliente cliente, boolean devolvido, int id, Livro livro){
        this.dataInicial = dataInicial;
        this.vencimento = vencimento;
        this.cliente = cliente;
        this.devolvido = devolvido;
        this.id = id;
        this.livro = livro;
    }

    public Emprestimo(){
        this.dataInicial = null;
        this.vencimento = null;
        this.cliente = null;
        this.devolvido = false;
        this.id = 0;
        this.livro = null;
    }

    public Cliente getCliente() { return this.cliente; }
    public LocalDate getVencimento() { return this.vencimento; }
    public LocalDate getDataInicial() { return this.dataInicial; }
    public Livro getLivro(){ return this.livro; }
    public boolean getDevolvido(){ return this.devolvido; }
    public int getId(){ return this.id; }
    public void setCliente(Cliente cliente){this.cliente = cliente; }
    public void setVencimento(LocalDate vencimento){this.vencimento = vencimento; }
    public void setDataInicial(LocalDate dataInicial){this.dataInicial = dataInicial; }
    public void setDevolvido(Boolean devolvido){this.devolvido = devolvido; }
    public void setId(int id){ this.id = id; }
    public void setLivro(Livro livro){ this.livro = livro; }

    /*Talvez as funções não fiquem aqui porem já estão feitas, imagino que elas serao chamadas na tela de cliente*/

    public void verifacaoVencimento(Emprestimo emprest, Cliente usuario){
        if(LocalDate.now().isAfter(emprest.getVencimento())){
            usuario.setStatusCliente(false);
        }
    }

    public void emprestimoRetornado(Emprestimo emprest, Cliente usuario){
        if(emprest.getDevolvido()){
            usuario.setStatusCliente(true);
        }
    }

}