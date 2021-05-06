/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Atendente;

/**
 *
 * @author picle
 */
public class AtendenteController {

    public AtendenteController() {
        
    }
    
    public void cadastrarAtendente(String usuario, String senha, String nome, String cpf, String telefone){
        Atendente atendente = new Atendente(usuario, senha, nome, cpf, telefone);
        
        atendente.cadastrarAtendente(atendente);
    }
    
    public boolean loginAtendente(String usuario, String senha){
        Atendente atendente = new Atendente(usuario, senha);
        
        if(atendente.loginAtendente(atendente)){
            return true;
        }else{
            return false;
        }
    }
    
}
