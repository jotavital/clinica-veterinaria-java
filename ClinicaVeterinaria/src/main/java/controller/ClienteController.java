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
        
        return cliente.cadastrarCliente(cliente);
        
    }
    
    public ArrayList<Cliente> pegarClientes(Cliente cliente){
        
        return cliente.pegarClientes(cliente);
        
    }
    
}
