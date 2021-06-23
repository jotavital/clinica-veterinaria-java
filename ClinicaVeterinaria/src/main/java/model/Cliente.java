/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kairos-04
 */
public class Cliente {
    Connector connector = new Connector();
    Connection conn = connector.connect();
    int id;
    String nome, cpf, telefone, rua, bairro, numero, tipo_telefone;

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
    
    public Cliente(String nome, String telefone){
        setNome(nome);
        setTelefone(telefone);
    }

    public Cliente(String nome, String cpf, String telefone, String rua, String bairro, String numero, String tipo_telefone) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setRua(rua);
        setBairro(bairro);
        setNumero(numero);
        setTipo_telefone(tipo_telefone);
    }
    
    public Cliente(int id, String nome, String cpf, String telefone, String rua, String bairro, String numero, String tipo_telefone) {
        setId(id);
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setRua(rua);
        setBairro(bairro);
        setNumero(numero);
        setTipo_telefone(tipo_telefone);
    }

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
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
    
    public int getClienteIdByNome(String nomeCliente) {

        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT id FROM cliente WHERE cliente.nome = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, nomeCliente);
            res = stm.executeQuery();

            if(res.next()){
                return res.getInt(1);    
            }else{
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public ResultSet selectAllFromClienteByCpf(String cpfCliente) {

        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT * FROM cliente WHERE cliente.cpf = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, cpfCliente);
            res = stm.executeQuery();

            if(res.next()){
                return res;    
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean cadastrarCliente(Cliente cliente){
        
        //sql's
        String sql = "INSERT INTO cliente (nome, cpf, telefone, rua, bairro, numero, tipo_telefone) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setString(3, cliente.getTelefone());
            stm.setString(4, cliente.getRua());
            stm.setString(5, cliente.getBairro());
            stm.setString(6, cliente.getNumero());
            stm.setString(7, cliente.getTipo_telefone());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente!");
            return false;
        }
        
    }
    
    public boolean editarCliente(Cliente cliente){
        
        //sql's
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, rua = ?, bairro = ?, numero = ?, tipo_telefone = ? WHERE id = ?";
        
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setString(3, cliente.getTelefone());
            stm.setString(4, cliente.getRua());
            stm.setString(5, cliente.getBairro());
            stm.setString(6, cliente.getNumero());
            stm.setString(7, cliente.getTipo_telefone());
            stm.setInt(8, cliente.getId());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar o cliente!");
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
    public boolean excluirCliente(String cpf){
        String sql = "DELETE FROM cliente WHERE cliente.cpf = ?";
        try {
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, cpf);
            
            Object[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Confirmar eclusão de" + cpf + "?",
                    "Confirmar",JOptionPane.DEFAULT_OPTION,   JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
            
            if (escolha == JOptionPane.YES_OPTION) {
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Atendente excluido com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "O cliente não foi excluido");
            }
            return true;
        } catch (SQLException e) {
             e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente");
            return false;
        }
        
    }
    
}
