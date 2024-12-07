package Modelo;

public class Sessao {
    private static Sessao instancia;
    private int idUsuario;

    private Sessao(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static Sessao iniciarSessao(int idUsuario) {
        if (instancia == null) {
            instancia = new Sessao(idUsuario);
        }
        return instancia;
    }

    public static Sessao getSessao() {
        return instancia;
    }

    public static void encerrarSessao() {
        instancia = null;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}

