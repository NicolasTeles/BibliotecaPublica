package Modelo;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private boolean statusCliente;


    public Cliente(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.statusCliente = true;
    }

    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.senha = "";
        this.statusCliente = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean getStatusCliente(){ return statusCliente; }

    public  void setStatusCliente(boolean statusCliente){ this.statusCliente = statusCliente; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
