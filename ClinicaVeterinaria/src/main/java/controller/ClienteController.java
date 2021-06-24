/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author kairos-04
 */
public class ClienteController {

    public ClienteController() {
        
    }
    
    public ResultSet selectAllFromClienteByCpf(String cpfCliente){
        Cliente clienteObj = new Cliente();
        return clienteObj.selectAllFromClienteByCpf(cpfCliente);
    }
    
    public boolean editarCliente(Cliente cliente){
        return cliente.editarCliente(cliente);
    }
    
    public boolean cadastrarCliente(Cliente cliente){
        return cliente.cadastrarCliente(cliente);
    }
    
    public ArrayList<Cliente> pegarClientes(Cliente cliente){
        return cliente.pegarClientes(cliente);
    }
    public boolean exluirCliente(Cliente cliente, String cpf){
        return cliente.excluirCliente(cpf);
        
    }
    
}
