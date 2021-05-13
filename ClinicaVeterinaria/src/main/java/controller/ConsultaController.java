/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Consulta;

/**
 *
 * @author kairos-04
 */
public class ConsultaController {

    public ConsultaController() {
        
    }
    
    public boolean cadastrarConstulta(Consulta consulta, String nomeAnimal, String nomeAtendente, String nomeVeterinario){
        if(consulta.CadastrarConsulta(consulta, nomeAnimal, nomeAtendente, nomeVeterinario)){
            return true;
        }else{
            return false;
        }
    }
    
}
