/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.JOptionPane;
import view.Home;

/**
 *
 * @author picle
 */
public final class Atendente {

    Connector conector = new Connector();
    Connection conn = conector.connect();

    private String usuario, senha, nome, cpf, telefone;

    public Atendente() {

    }

    public Atendente(String usuario, String senha, String nome, String cpf, String telefone) {
        setUsuario(usuario);
        setSenha(senha);
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
    }

    public Atendente(String usuario, String senha) {
        setUsuario(usuario);
        setSenha(senha);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public boolean cadastrarAtendente(Atendente atendente) {

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
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            e.printStackTrace();
            return false;
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
            } else {
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
