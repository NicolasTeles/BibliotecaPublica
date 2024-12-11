package Modelo;

public class Session {
    private static Cliente cliente = null;
    private static Funcionario funcionario = null;
    
    public static void criaCliente(Cliente c){
        cliente = c;
    }
    
    public static void criaFuncionario(Funcionario f){
        funcionario = f;
    }
    
    public static Funcionario getFuncionario(){
        return funcionario;
    }
    
    public static Cliente getCliente(){
        return cliente;
    }
    
    public static void destroiCliente(){
        cliente = null;
    }
    
    public static void destroiFuncionario(){
        funcionario = null;
    }
}