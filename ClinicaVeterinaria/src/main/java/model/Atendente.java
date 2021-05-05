/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AtendenteDAO;

/**
 *
 * @author picle
 */
public class Atendente {
    private String usuario, senha, nome, cpf, telefone;

    public Atendente() {
        
    }
    
    public Atendente(String usuario, String senha, String nome, String cpf, String telefone){
        setUsuario(usuario);
        setSenha(senha);
        setNome(nome);
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
    
    public void cadastrarAtendente(Atendente atendente){
        AtendenteDAO dao = new AtendenteDAO();
        
        dao.cadastrarAtendente(atendente);
    }
    
}
