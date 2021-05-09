/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import model.Connector;
import java.sql.*;

/**
 *
 * @author kairos-04
 */
public class Cliente {
    Connector connector = new Connector();
    Connection conn = connector.connect();
    String nome, cpf, telefone, rua, bairro, numero;

    public Cliente() {
        
    }

    public Cliente(String nome, String cpf, String telefone, String rua, String bairro, String numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
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
}
