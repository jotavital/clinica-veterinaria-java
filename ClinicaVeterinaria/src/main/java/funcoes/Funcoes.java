package funcoes;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kairos-04
 */
public class Funcoes { // classe que armazena funcoes globais do sistema

    public Funcoes() {

    }

    public void resetFields(JPanel painel) {
        for (Component c : painel.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JPasswordField) {
                ((JPasswordField) c).setText("");
            } else if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
            }else if (c instanceof JSpinner){
                ((JSpinner) c).setValue(0);
            }
        }
    }

    public void disableFields(JPanel painel) {
        for (Component c : painel.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setEnabled(false);
            } else if (c instanceof JPasswordField) {
                ((JPasswordField) c).setEnabled(false);
            } else if (c instanceof JSpinner){
                ((JSpinner) c).setEnabled(false);
            }
        }
    }
    
    public void uncheckRadio(JPanel painel){
        for (Component c : painel.getComponents()) {
            if (c instanceof JRadioButton) {
                ((JRadioButton) c).setSelected(false);
            }
        }
    }

}
