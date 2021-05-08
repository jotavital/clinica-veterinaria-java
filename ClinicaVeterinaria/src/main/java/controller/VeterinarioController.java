/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Veterinario;

/**
 *
 * @author lukas
 */
public class VeterinarioController {

    public VeterinarioController() {
        
    }
    
    public boolean CadastrarVeterinario(Veterinario veterinario){
        if (veterinario.cadastrarVeterinario(veterinario)){
            return true;
        }else{
            return false;
        }
    }
    
}
