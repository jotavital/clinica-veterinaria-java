/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Veterinario;

/**
 *
 * @author lukas
 */
public class VeterinarioController {
    Veterinario veterinario = new Veterinario();

    public VeterinarioController() {
        
    }
    
    public boolean cadastrarVeterinario(Veterinario veterinario){
        return veterinario.cadastrarVeterinario(veterinario);
    }
    
    public ArrayList<Veterinario> pegarVeterinarios(Veterinario veterinario){
        return veterinario.pegarVeterinarios(veterinario);
    }
    
    public boolean excluirVeterinario(String nomeCPF){
        Veterinario veterinario = new Veterinario();
        
        return veterinario.excluirVeterinario(nomeCPF);    
    }
    
    public ResultSet selectAllFromVeterinarioByCpf(String cpfVet){
        return veterinario.selectAllFromVeterinarioByCpf(cpfVet);
    }
    
    public boolean editarVeterinario(Veterinario veterinario){
        return veterinario.editarVeterinario(veterinario);
    }
    
}
