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
    String nomeAnimal, especieAnimal, racaAnimal;
    int idAnimal, idadeAnimal;

    public Animal() {

    }

    public Animal(String nome, String especie, String raca, int idade) {
        this.nomeAnimal = nome;
        this.especieAnimal = especie;
        this.racaAnimal = raca;
        this.idadeAnimal = idade;
    }

    public Animal(int id, String nome, String especie, String raca, int idade) {
        this.idAnimal = id;
        this.nomeAnimal = nome;
        this.especieAnimal = especie;
        this.racaAnimal = raca;
        this.idadeAnimal = idade;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
    }

    public String getRacaAnimal() {
        return racaAnimal;
    }

    public void setRacaAnimal(String racaAnimal) {
        this.racaAnimal = racaAnimal;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public boolean cadastrarAnimal(Animal animal, String nomeDono) {

        String sql = "INSERT INTO animal (nome, especie, raca, idade) VALUES (?, ?, ?, ?)";
        String sql2 = "INSERT INTO cliente_animal (fk_cliente, fk_animal) VALUES (?, LAST_INSERT_ID())";

        Cliente dono = new Cliente();
        int idDono = dono.getClienteIdByNome(nomeDono);

        PreparedStatement stm;
        PreparedStatement stm2;

        try {
            stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, animal.getNomeAnimal());
            stm.setString(2, animal.getEspecieAnimal());
            stm.setString(3, animal.getRacaAnimal());
            stm.setInt(4, animal.getIdadeAnimal());
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

    public ArrayList<Animal> pegarAnimais(Animal animal) {

        String sql = "SELECT * FROM animal";
        ArrayList<Animal> listaAnimais = new ArrayList<>();

        try {
            ResultSet res;
            PreparedStatement stm = conn.prepareStatement(sql);

            res = stm.executeQuery();
            while (res.next()) {
                animal.setIdAnimal(res.getInt(1));
                animal.setNomeAnimal(res.getString(2));
                animal.setEspecieAnimal(res.getString(3));
                animal.setRacaAnimal(res.getString(4));
                animal.setIdadeAnimal(res.getInt(5));
                animal = new Animal(idAnimal, nomeAnimal, especieAnimal, racaAnimal, idadeAnimal);

                listaAnimais.add(animal);
            }

            return listaAnimais;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public int getAnimalIdByNome(String nomeAnimal){
        
        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT id FROM animal WHERE animal.nome = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, nomeAnimal);
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
    
    public ArrayList<Animal> getAnimaisByDono(Animal animal) {
        return null;
    }

}
