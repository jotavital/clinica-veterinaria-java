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
    
    public boolean cadastrarAtendente(String usuario, String senha, String nome, String cpf, String telefone){
        Atendente atendente = new Atendente(usuario, senha, nome, cpf, telefone);
        
        atendente.cadastrarAtendente(atendente);
        
        return false;
    }
    
}
