/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Connector;
import model.Animal;

/**
 *
 * @author kairos-04
 */
public class Consulta {

    Connector connector = new Connector();
    Connection conn = connector.connect();
    String descricao;
    double valor;
    String data_consulta, data_prevista;
    int fk_animal, fk_atendente;

    public Consulta() {

    }

    public Consulta(String descricao, double valor, String data_consulta, String data_prevista) {
        this.descricao = descricao;
        this.valor = valor;
        this.data_consulta = data_consulta;
        this.data_prevista = data_prevista;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(String data_prevista) {
        this.data_prevista = data_prevista;
    }

    public int getFk_animal() {
        return fk_animal;
    }

    public void setFk_animal(int fk_animal) {
        this.fk_animal = fk_animal;
    }

    public int getFk_atendente() {
        return fk_atendente;
    }

    public void setFk_atendente(int fk_atendente) {
        this.fk_atendente = fk_atendente;
    }

    public boolean CadastrarConsulta(Consulta consulta, String nomeAnimal, String nomeAtendente) {
        String sql = "INSERT INTO consulta (descricao, valor, data_consulta, data_prevista, data_agendamento, fk_animal, fk_atendente) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Animal animal = new Animal();
        Atendente atendente = new Atendente();
        
        int idAnimal = animal.getAnimalIdByNome(nomeAnimal);
        int idAtendente = atendente.getAtendenteIdByNome(nomeAtendente);
        
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, consulta.getDescricao());
            stm.setDouble(2, consulta.getValor());
            stm.setString(3, consulta.getData_consulta());
            stm.setString(4, consulta.getData_prevista());
            stm.setString(5, LocalDate.now().toString());
            stm.setInt(6, idAnimal);
            stm.setInt(7, idAtendente);
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso!");

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar consulta!");
            e.printStackTrace();
            
            return false;
        }
    }
}
