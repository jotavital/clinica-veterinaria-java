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

        if (atendente.cadastrarAtendente(atendente)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loginAtendente(Atendente atendente) {

        if (atendente.loginAtendente(atendente)) {
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Atendente> pegarAtendentes(Atendente atendente){
        if(atendente.pegarAtendentes(atendente) != null){
            return atendente.pegarAtendentes(atendente);
        }else{
            return null;
        }
    }
}
