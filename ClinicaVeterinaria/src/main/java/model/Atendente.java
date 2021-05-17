/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
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

    public Atendente(String nome, String cpf, String telefone) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
    }

    public Atendente(String nome, String usuario, String cpf, String telefone) {
        setNome(nome);
        setUsuario(usuario);
        setCpf(cpf);
        setTelefone(telefone);
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

        String sql = "SELECT id, usuario, senha FROM atendente WHERE usuario=? and senha=?";
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

    public ArrayList<Atendente> pegarAtendentes(Atendente atendente) {
        String sql = "SELECT * FROM atendente";
        ArrayList<Atendente> listaAtendente = new ArrayList<>();
        try {
            ResultSet res = null;
            PreparedStatement stm = conn.prepareStatement(sql);

            res = stm.executeQuery();
            while (res.next()) {
                atendente.setNome(res.getString("nome"));
                atendente.setUsuario(res.getString("usuario"));
                atendente.setCpf(res.getString("cpf"));
                atendente.setTelefone(res.getString("telefone"));
                Atendente novoAtendente = new Atendente(nome, usuario, cpf, telefone);

                listaAtendente.add(novoAtendente);
            }

            return listaAtendente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean excluirAtendentee(String usuario) {
        String sql = "DELETE FROM atendente WHERE atendente.usuario = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, usuario);
            
            Object[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Confirmar exclusão de " + usuario + "?", "Confirmar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
            
            if (escolha == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Atendente excluido com sucesso");
                stm.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "O atendente não foi excluído");
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir o atendente");
            return false;
        }
    }

    int getAtendenteIdByNome(String nomeAtendente) {
        
        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT id FROM atendente WHERE atendente.nome = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, nomeAtendente);
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
}
