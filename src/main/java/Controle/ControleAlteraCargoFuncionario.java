package Controle;

import Modelo.DAO.FuncionarioDAO;
import Modelo.Funcionario;

public class ControleAlteraCargoFuncionario {
   
    
    public void alteraEstado(String cargo, String cpf){
        FuncionarioDAO fd = new FuncionarioDAO(); 
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
    
}
