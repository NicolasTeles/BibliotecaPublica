package Controle;

import Persistencia.FuncionarioDAO;
import Modelo.Funcionario;

public class ControleAlteraCargoFuncionario {
   
    
    public void alteraEstado(String cargo, String cpf){
        FuncionarioDAO fd = FuncionarioDAO.getInstancia();
        Funcionario funcionario = new Funcionario();
        boolean status = false;
        if(cargo.equalsIgnoreCase("administrador"))
            status = true;
        else if(cargo.equalsIgnoreCase("funcionario"))
            status = false;
        funcionario.setEadm(status);
        funcionario.setCpf(cpf);
        fd.atualizaStatus(funcionario);
    }
    
    public boolean deletaFuncionario(String cpf){
        FuncionarioDAO fd = FuncionarioDAO.getInstancia();
        Funcionario funcionario = new Funcionario();
        boolean confere;
        
        funcionario = fd.consultaFuncionario(cpf);
        confere = fd.deletaFuncionario(funcionario);     
        return confere;
    }
    
}
