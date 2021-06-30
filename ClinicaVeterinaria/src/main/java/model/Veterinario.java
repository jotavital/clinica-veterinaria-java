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
 * @author lukas
 */
public class Veterinario {

    Connector conector = new Connector();
    Connection conn = conector.connect();

    String nome, cpf, telefone, rua, bairro, numero, tipo_telefone;
    int id;

    public Veterinario() {

    }

    public Veterinario(String nome, String cpf, String telefone, String rua, String bairro, String numero) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }
    
    public Veterinario(String nome, String cpf, String telefone, String rua, String bairro, String numero, String tipo_telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.tipo_telefone = tipo_telefone;
    }
    
    public Veterinario(int id, String nome, String cpf, String telefone, String rua, String bairro, String numero, String tipo_telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.tipo_telefone = tipo_telefone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean cadastrarVeterinario(Veterinario veterinario) {
        //sql para o cadastro do veterinario
        String sql = "INSERT INTO veterinario (nome, cpf, telefone, rua, bairro, numero, tipo_telefone) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, veterinario.getNome());
            stm.setString(2, veterinario.getCpf());
            stm.setString(3, veterinario.getTelefone());
            stm.setString(4, veterinario.getRua());
            stm.setString(5, veterinario.getBairro());
            stm.setString(6, veterinario.getNumero());
            stm.setString(7, veterinario.getTipo_telefone());
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Veterinário cadastrado com sucesso!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o veterinário!");
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Veterinario> pegarVeterinarios(Veterinario veterinario) {
        String sql = "SELECT * FROM veterinario";
        ArrayList<Veterinario> listaVeterinario = new ArrayList<>();

        try {
            ResultSet res = null;
            PreparedStatement stm = conn.prepareStatement(sql);

            res = stm.executeQuery();
            while (res.next()) {
                veterinario.setNome(res.getString("nome"));
                veterinario.setCpf(res.getString("cpf"));
                veterinario.setTelefone(res.getString("telefone"));
                veterinario.setRua(res.getString("rua"));
                veterinario.setBairro(res.getString("bairro"));
                veterinario.setNumero(res.getString("numero"));
                Veterinario novoVeterinario = new Veterinario(nome, cpf, telefone, rua, bairro, numero);

                listaVeterinario.add(novoVeterinario);
            }

            return listaVeterinario;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    int getVeterinarioIdByNome(String nomeVeterinario) {

        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT id FROM veterinario WHERE veterinario.nome = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, nomeVeterinario);
            res = stm.executeQuery();

            if (res.next()) {
                return res.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public boolean excluirVeterinario(String nomeCPF) {
        String sql = "DELETE FROM veterinario WHERE veterinario.cpf = ?";

        String[] splitted = nomeCPF.split(" - ");
        String cpf = splitted[1];
        String nome = splitted[0];

        try {
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, cpf);
            Object[] opcoes = {"Sim", "Não"};
            int escolha = JOptionPane.showOptionDialog(null, "Confirmar exclusão de: " + nome + " CPF: " + cpf + "?",
                    "Confirmar", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == JOptionPane.YES_OPTION) {
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Veterinario excluido com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "O veterinario não foi excluido");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir o veterinario");
            return false;
        }

    }

    public ResultSet selectAllFromVeterinarioByCpf(String cpfVet) {
        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT * FROM veterinario WHERE cpf = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setString(1, cpfVet);
            res = stm.executeQuery();

            if (res != null && res.next()) {
                return res;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean editarVeterinario(Veterinario veterinario){
        String sql = "UPDATE veterinario SET nome = ?, cpf = ?, telefone = ?, rua = ?, bairro = ?, numero = ?, tipo_telefone = ? WHERE id = ?";

        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, veterinario.getNome());
            stm.setString(2, veterinario.getCpf());
            stm.setString(3, veterinario.getTelefone());
            stm.setString(4, veterinario.getRua());
            stm.setString(5, veterinario.getBairro());
            stm.setString(6, veterinario.getNumero());
            stm.setString(7, veterinario.getTipo_telefone());
            stm.setInt(8, veterinario.getId());

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Veterinário editado com sucesso!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar o veterinário!");
            return false;
        }
    }
    
    public String getVetCpfById(int idVet){
        PreparedStatement stm;
        ResultSet res;

        String sql = "SELECT cpf FROM veterinario WHERE id = ?";

        try {
            stm = conn.prepareStatement(sql);
            stm.setInt(1, idVet);
            res = stm.executeQuery();

            if (res != null && res.next()) {
                return res.getString("cpf");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
