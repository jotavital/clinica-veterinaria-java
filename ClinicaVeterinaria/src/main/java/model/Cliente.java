/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import model.Connector;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author kairos-04
 */
public class Cliente {
    Connector connector = new Connector();
    Connection conn = connector.connect();
    int id;
    String nome, cpf, telefone, rua, bairro, numero;

    public Cliente() {
        
    }

    public Cliente(int id, String nome, String cpf, String telefone, String rua, String bairro, String numero) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setRua(rua);
        setBairro(bairro);
        setNumero(numero);
    }
    
    public Cliente(String nome, String cpf, String telefone, String rua, String bairro, String numero) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setRua(rua);
        setBairro(bairro);
        setNumero(numero);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public boolean cadastrarCliente(Cliente cliente){
        
        //sql's
        String sql = "INSERT INTO cliente (nome, cpf, telefone, rua, bairro, numero) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setString(3, cliente.getTelefone());
            stm.setString(4, cliente.getRua());
            stm.setString(5, cliente.getBairro());
            stm.setString(6, cliente.getNumero());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente!");
            return false;
        }
        
    }
    
    public ArrayList<Cliente> pegarClientes(Cliente cliente){
        String sql = "SELECT * FROM cliente";
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        try {
            ResultSet res;
            PreparedStatement stm = conn.prepareStatement(sql);
            
            res = stm.executeQuery();
            while(res.next()){
                cliente.setId(res.getInt("id"));
                cliente.setNome(res.getString("nome"));
                cliente.setCpf(res.getString("cpf"));
                cliente.setTelefone(res.getString("telefone"));
                cliente.setRua(res.getString("rua"));
                cliente.setBairro(res.getString("bairro"));
                cliente.setNumero(res.getString("numero"));
                Cliente novoCliente = new Cliente(id, nome, cpf, telefone, rua, bairro, numero);
                
                listaClientes.add(novoCliente);
            }
            
            return listaClientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
