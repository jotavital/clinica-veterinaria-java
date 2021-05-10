/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author kairos-04
 */
public class ClienteController {

    public ClienteController() {
        
    }
    
    public boolean cadastrarCliente(Cliente cliente){
        
        if(cliente.cadastrarCliente(cliente)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public ArrayList<Cliente> pegarClientes(Cliente cliente){
        
        if(cliente.pegarClientes(cliente) != null){
            return cliente.pegarClientes(cliente);
        }else{
            return null;
        }
        
    }
    
}
