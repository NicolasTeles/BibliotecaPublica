package Modelo;

public class Funcionario {
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private boolean Eadm;

    public Funcionario(){
        this.nome = "";
        this.cpf = "";
        this.login = "";
        this.senha = "";
        this.Eadm = false;
    }

    public Funcionario(String nome, String cpf, String login, String senha, boolean Eadm) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.Eadm = Eadm;
    }


    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public String getLogin() { return login; }

    public String getSenha() { return senha; }

    public boolean getEadm() { return Eadm; }


    public void setNome(String nome) { this.nome = nome; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setLogin(String login) { this.login = login; }

    public void setSenha(String senha) { this.senha = senha; }

    public void setEadm(boolean Eadm) { this.Eadm = Eadm; }

}