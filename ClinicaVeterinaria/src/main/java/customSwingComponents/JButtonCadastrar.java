/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customSwingComponents;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author kairos-04
 */
public class JButtonCadastrar extends JButton {

    public JButtonCadastrar() {
        this.setText("Cadastrar");
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/accept.png"))); // NOI18N
        this.setPreferredSize(new java.awt.Dimension(110, 40));
        this.setMaximumSize(new java.awt.Dimension(110, 40));
    }

    public JButtonCadastrar(Icon icon) {
        super(icon);
    }

    public JButtonCadastrar(String text) {
        super(text);
    }

    public JButtonCadastrar(Action a) {
        super(a);
    }

    public JButtonCadastrar(String text, Icon icon) {
        super(text, icon);
    }
    
}
