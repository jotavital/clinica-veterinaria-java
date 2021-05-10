/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kairos-04
 */
public class Animal {
    Connector connector = new Connector();
    Connection conn = connector.connect();
    String nome, especie, raca;
    int idade;

    public Animal() {
        
    }

    public Animal(String nome, String especie, String raca, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public boolean cadastrarAnimal(Animal animal){
        
        String sql = "INSERT INTO animal (nome, especie, raca, idade) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO cliente_animal (fk_cliente, fk_animal) VALUES (?, ?)"; // parei aqui
        
        PreparedStatement stm;
        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, animal.getNome());
            stm.setString(2, animal.getEspecie());
            stm.setString(3, animal.getRaca());
            stm.setInt(4, animal.getIdade());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
