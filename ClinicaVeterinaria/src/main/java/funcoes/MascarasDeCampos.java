/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author kairos-04
 */
public class MascarasDeCampos {

    public MascarasDeCampos() {

    }

    public void mascaraCpf(JFormattedTextField campo) {
        try {
            campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraTelefoneFixo(JFormattedTextField campo) {
        campo.setValue(null);
        campo.setFormatterFactory(null);

        try {
            campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
            campo.setEnabled(true);
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraCelular(JFormattedTextField campo) {
        campo.setValue(null);
        campo.setFormatterFactory(null);

        try {
            campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
            campo.setEnabled(true);
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }

}
