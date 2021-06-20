/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kairos-04
 */
public class Consulta {

    Connector connector = new Connector();
    Connection conn = connector.connect();
    String descricao;
    double valor;
    String data_consulta, data_prevista, data_agendamento;
    int id, fk_animal, fk_atendente;

    public Consulta() {

    }

    public Consulta(String descricao, double valor, String data_consulta, String data_prevista) {
        this.descricao = descricao;
        this.valor = valor;
        this.data_consulta = data_consulta;
        this.data_prevista = data_prevista;
    }

    private Consulta(int id, String descricao, double valor, String data_consulta, String data_prevista, String data_agendamento, int fk_animal, int fk_atendente) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data_consulta = data_consulta;
        this.data_prevista = data_prevista;
        this.data_agendamento = data_agendamento;
        this.fk_animal = fk_animal;
        this.fk_atendente = fk_atendente;
    }

    public String getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(String data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean CadastrarConsulta(Consulta consulta, String nomeAnimal, String nomeAtendente, String nomeVeterinario) {
        String sql = "INSERT INTO consulta (descricao, valor, data_consulta, data_prevista, data_agendamento, fk_animal, fk_atendente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO veterinario_consulta (fk_veterinario, fk_consulta) VALUES (?, LAST_INSERT_ID())";

        Animal animal = new Animal();
        Atendente atendente = new Atendente();
        Veterinario veterinario = new Veterinario();
        
        int idAnimal = animal.getAnimalIdByNome(nomeAnimal);
        int idAtendente = atendente.getAtendenteIdByNome(nomeAtendente);
        int idVeterinario = veterinario.getVeterinarioIdByNome(nomeVeterinario);
        
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
            
            stm = conn.prepareStatement(sql2);
            stm.setInt(1, idVeterinario);
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso!");

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar consulta!");
            e.printStackTrace();
            
            return false;
        }
    }
    
    public ArrayList<Consulta> pegarConsultas(Consulta consulta){
        String sql = "SELECT * FROM consulta";
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        
        try {
            ResultSet res;
            PreparedStatement stm = conn.prepareStatement(sql);
            
            res = stm.executeQuery();
            while(res.next()){
                consulta.setId(res.getInt("id"));
                consulta.setDescricao(res.getString("descricao"));
                consulta.setValor(res.getDouble("valor"));
                consulta.setData_consulta(res.getString("data_consulta"));
                consulta.setData_prevista(res.getString("data_prevista"));
                consulta.setData_agendamento(res.getString("data_agendamento"));
                consulta.setFk_animal(res.getInt("fk_animal"));
                consulta.setFk_atendente(res.getInt("fk_atendente"));
                Consulta novaConsulta = new Consulta(id, descricao, valor, data_consulta, data_prevista, data_agendamento, fk_animal, fk_atendente);
                
                listaConsultas.add(novaConsulta);
            }
            
            return listaConsultas;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
