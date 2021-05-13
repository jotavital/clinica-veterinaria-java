/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.atendente;

import java.util.ArrayList;
import model.Atendente;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import controller.AtendenteController;
import funcoes.Funcoes;

/**
 *
 * @author mateu
 */
public class ExcluirAtendente extends javax.swing.JInternalFrame {
    
    Funcoes funcoes = new Funcoes();

    /**
     * Creates new form ExcluirAtendente
     */
    public ExcluirAtendente() {
        initComponents();
        
        populaCbAtendente();
    }

    public void populaCbAtendente() {
        funcoes.resetComboBox(cbAtendende);
        
        ArrayList<Atendente> listaAtendentes = new ArrayList<>();
        Atendente atendente = new Atendente();
        listaAtendentes = atendente.pegarAtendentes(atendente);

        for (Atendente a : listaAtendentes) {
            cbAtendende.addItem(a.getUsuario());
        }

        AutoCompleteDecorator.decorate(cbAtendende);
        cbAtendende.setSelectedItem(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basicMultiThumbSliderUI1 = new org.jdesktop.swingx.plaf.basic.BasicMultiThumbSliderUI();
        lblBuscar = new javax.swing.JLabel();
        cbAtendende = new org.jdesktop.swingx.JXComboBox();
        btnExcluir = new javax.swing.JButton();
        btnRefreshAtendente = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();

        setClosable(true);

        lblBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBuscar.setText("Buscar:");

        cbAtendende.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbAtendendeFocusLost(evt);
            }
        });
        cbAtendende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAtendendeActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnRefreshAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_refresh.png"))); // NOI18N
        btnRefreshAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshAtendenteActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_delete.png"))); // NOI18N
        lblTitulo.setText("Excluir atendentes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(btnRefreshAtendente)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(cbAtendende, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAtendende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefreshAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAtendendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAtendendeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbAtendendeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Atendente atendente = new Atendente();
        AtendenteController controller = new AtendenteController();
        String usuarioAtendente = cbAtendende.getStringAt(cbAtendende.getSelectedIndex());

        System.out.println(usuarioAtendente);

        if (!usuarioAtendente.isEmpty()) {
            controller.excluirAtendente(usuarioAtendente, atendente);
            populaCbAtendente();
        } else {
            jXLabel1.setText("O campo não pode esta vazio");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnRefreshAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshAtendenteActionPerformed
        // TODO add your handling code here:
        populaCbAtendente();
    }//GEN-LAST:event_btnRefreshAtendenteActionPerformed

    private void cbAtendendeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbAtendendeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAtendendeFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.plaf.basic.BasicMultiThumbSliderUI basicMultiThumbSliderUI1;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnRefreshAtendente;
    private org.jdesktop.swingx.JXComboBox cbAtendende;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
