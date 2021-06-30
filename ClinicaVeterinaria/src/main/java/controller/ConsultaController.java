/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Consulta;

/**
 *
 * @author kairos-04
 */
public class ConsultaController {
    Consulta consulta = new Consulta();

    public ConsultaController() {
        
    }
    
    public boolean cadastrarConstulta(Consulta consulta, String nomeAnimal, String nomeAtendente, String nomeVeterinario){
        return consulta.cadastrarConsulta(consulta, nomeAnimal, nomeAtendente, nomeVeterinario);
    }
    
    public ArrayList<Consulta> pegarConsultas(Consulta consulta){
        return consulta.pegarConsultas(consulta);
    }
    
    public ResultSet selectAllFromConsultaByDescricao(String descricao){
        return consulta.selectAllFromConsultaByDescricao(descricao);
    }
}
