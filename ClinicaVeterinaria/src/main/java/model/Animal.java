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

    public int getClienteId(String nomeDono) {

        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT id FROM cliente WHERE cliente.nome = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, nomeDono);
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

    public boolean cadastrarAnimal(Animal animal, String nomeDono) {

        String sql = "INSERT INTO animal (nome, especie, raca, idade) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO cliente_animal (fk_cliente, fk_animal) VALUES (?, LAST_INSERT_ID())";

        int idDono = getClienteId(nomeDono);
        
        PreparedStatement stm;
        PreparedStatement stm2;

        try {
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, animal.getNome());
            stm.setString(2, animal.getEspecie());
            stm.setString(3, animal.getRaca());
            stm.setInt(4, animal.getIdade());
            stm.executeUpdate();
            
            stm2 = conn.prepareStatement(sql2);
            stm2.setInt(1, idDono);
            stm2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    
    public ArrayList<Animal> pegarAnimais(Animal animal){
        String sql = "SELECT * FROM animal";
        ArrayList<Animal> listaAnimais = new ArrayList<>();
        
        try {
            ResultSet res;
            PreparedStatement stm = conn.prepareStatement(sql);
            
            res = stm.executeQuery();
            while(res.next()){
                animal.setNome(res.getString(2));
                animal.setEspecie(res.getString(3));
                animal.setRaca(res.getString(4));
                animal.setIdade(res.getInt(5));
                animal = new Animal(nome, especie, raca, idade);
                
                listaAnimais.add(animal);
            }
            
            return listaAnimais;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
