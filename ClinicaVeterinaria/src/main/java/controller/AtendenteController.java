/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Atendente;

/**
 *
 * @author picle
 */
public class AtendenteController {

    public AtendenteController() {

    }

    public boolean cadastrarAtendente(Atendente atendente) {
        return atendente.cadastrarAtendente(atendente);
    }

    public boolean loginAtendente(Atendente atendente) {
        return atendente.loginAtendente(atendente);
    }

    public ArrayList<Atendente> pegarAtendentes(Atendente atendente) {
        return atendente.pegarAtendentes(atendente);
    }

    public boolean excluirAtendente(Atendente atendente, String usuario) {
        return atendente.excluirAtendente(usuario);
    }
    
    public String getAtendenteNomeById(int idAtendente){
        Atendente atendenteObj = new Atendente();
        return atendenteObj.getAtendenteNomeById(idAtendente);
    }
}
