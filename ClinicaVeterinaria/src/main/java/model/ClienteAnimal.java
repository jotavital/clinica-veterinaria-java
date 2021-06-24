/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kairos-04
 */
public class ClienteAnimal extends Animal{
    String nomeDono, telefoneDono;

    public ClienteAnimal() {
        
    }

    public ClienteAnimal(String nomeDono, String TelefoneDono, int id, String nome, String especie, String raca, int idade) {
        super(id, nome, especie, raca, idade);
        this.nomeDono = nomeDono;
        this.telefoneDono = TelefoneDono;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getTelefoneDono() {
        return telefoneDono;
    }

    public void setTelefoneDono(String telefoneDono) {
        this.telefoneDono = telefoneDono;
    }

    public ArrayList<ClienteAnimal> pegarAnimaisComDonos(ClienteAnimal clienteAnimal) {
        String sql = "SELECT a.*, c.nome, c.telefone FROM animal a, cliente c INNER JOIN cliente_animal ca WHERE ca.fk_cliente = c.id AND ca.fk_animal = a.id ORDER BY a.id";
        ArrayList<ClienteAnimal> listaAnimaisDonos = new ArrayList<>();
        
        try {
            ResultSet res;
            PreparedStatement stm = conn.prepareStatement(sql);

            res = stm.executeQuery();
            while (res.next()) {
                clienteAnimal.setIdAnimal(res.getInt(1));
                clienteAnimal.setNomeAnimal(res.getString(2));
                clienteAnimal.setEspecieAnimal(res.getString(3));
                clienteAnimal.setRacaAnimal(res.getString(4));
                clienteAnimal.setIdadeAnimal(res.getInt(5));
                clienteAnimal.setNomeDono(res.getString(6));
                clienteAnimal.setTelefoneDono(res.getString(7));
                
                clienteAnimal = new ClienteAnimal(nomeDono, telefoneDono, idAnimal, nomeAnimal, especieAnimal, racaAnimal, idadeAnimal);
                listaAnimaisDonos.add(clienteAnimal);
            }
            
            return listaAnimaisDonos;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean desvincularDonoAnimal(String cpfDono){
        PreparedStatement stm;
        ResultSet res;
        
        int idCPF = 0;
        String[] splitted = cpfDono.split(" - ");
        String cpf = splitted[1]; 
        
        String slqCPF = "SELECT cliente.id FROM cliente WHERE cliente.cpf = ?";
        String sql = "DELETE FROM cliente_animal WHERE cliente_animal.fk_cliente = ?";
      
        try {
            stm = conn.prepareStatement(slqCPF);
            stm.setString(1, cpf);
            stm.execute();
            res = stm.executeQuery();

            if(res.next()){
                idCPF = res.getInt(1);  
            }else{
                System.out.println("erro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try { 
            String id = Integer.toString(idCPF);
            System.out.println(id);
            stm = conn.prepareCall(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
