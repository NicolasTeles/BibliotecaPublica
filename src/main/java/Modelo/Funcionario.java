package Modelo;

public class Funcionario {
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private boolean eADM;

    public Funcionario(){
        this.nome = "";
        this.cpf = "";
        this.login = "";
        this.senha = "";
        this.eADM = false;
    }

    public Funcionario(String nome, String cpf, String login, String senha, boolean eADM) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.eADM = eADM;
    }


    public String getNome() { return nome; }

    public String getCpf() { return cpf; }

    public String getLogin() { return login; }

    public String getSenha() { return senha; }

    public boolean getEadm() { return eADM; }


    public void setNome(String nome) { this.nome = nome; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setLogin(String login) { this.login = login; }

    public void setSenha(String senha) { this.senha = senha; }

    public void setEadm(boolean Eadm) { this.eADM = Eadm; }

}