/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import model.Atendente;
import view.Home;
import view.atendente.LoginAtendente;

/**
 *
 * @author picle
 */
public class AtendenteDAO {

    Connector conector = new Connector();
    Connection conn = conector.connect();

    public AtendenteDAO() {

    }

    public void cadastrarAtendente(Atendente atendente) {

        String sql = "INSERT INTO atendente (usuario, senha, nome, cpf, telefone) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, atendente.getUsuario());
            stm.setString(2, atendente.getSenha());
            stm.setString(3, atendente.getNome());
            stm.setString(4, atendente.getCpf());
            stm.setString(5, atendente.getTelefone());
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atendente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            e.printStackTrace();
        }

    }

    public boolean loginAtendente(Atendente atendente) {

        String sql = "SELECT usuario, senha FROM atendente WHERE usuario=? and senha=?";
        ResultSet res = null;

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, atendente.getUsuario());
            stm.setString(2, atendente.getSenha());
            res = stm.executeQuery();

            if (res.next()) {
                Home home = new Home();
                home.setVisible(true);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar");
            e.printStackTrace();
            return false;
        }

    }

}
