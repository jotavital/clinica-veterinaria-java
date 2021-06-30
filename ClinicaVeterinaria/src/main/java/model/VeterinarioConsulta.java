/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author picle
 */
public class VeterinarioConsulta {
    Connector conector = new Connector();
    Connection conn = conector.connect();
    
    int fk_veterinario, fk_consulta;

    public int getFk_veterinario() {
        return fk_veterinario;
    }

    public void setFk_veterinario(int fk_veterinario) {
        this.fk_veterinario = fk_veterinario;
    }

    public int getFk_consulta() {
        return fk_consulta;
    }

    public void setFk_consulta(int fk_consulta) {
        this.fk_consulta = fk_consulta;
    }
    
    public int getVetIdByConsultaId(int idConsulta){
        PreparedStatement stm;
        ResultSet res;
        
        String sql = "SELECT fk_veterinario FROM veterinario_consulta WHERE fk_consulta = ?";
        
        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, idConsulta);
            
            res = stm.executeQuery();
            
            if (res != null && res.next()) {
                return res.getInt("fk_veterinario");
            } else {
                return -1;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
