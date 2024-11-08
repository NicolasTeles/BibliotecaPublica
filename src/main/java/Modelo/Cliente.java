package Modelo;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Cliente(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(){
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.senha = "";
    }

    public String getNome() {
        return nome;
    }

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

    public void listarLivros(){}
    public void verStatusLivro(String nomeLivro, String editora){}
    public void verAvaliacaoLivro(String nomeLivro, String editora){}
    public void pegarLivro(String nomeLivro, String editora){}
    public void devolverLivro(String nomeLivro, String editora){}
    public void avaliarLivro(String nomeLivro, String editora, Integer avaliacao){}
    public void listarEmprestimos(String nomeLivro, String editora){}
    public void cadastrarCliente(String nome, String cpf, String email, String senha){}
    //talvez seja bom a funcao receber o nome do cliente, depende da interpretacao
    public void excluirCliente(){}
    public void verStatusCliente(String cpf){}
    public void loginCliente (String login, String senha){}
    public void logoutCliente(){}

}
