/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Connector;
import java.sql.Connection;
import view.atendente.*;
import view.cliente.*;
import view.veterinario.*;

/**
 *
 * @author kairos-04
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();

        Connector conector = new Connector();
        Connection conn = conector.connect();

        if (conn == null) {
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_error.png")));
            lblStatus.setText("Erro de conexão");
        } else {
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/database_connect.png"))); // NOI18N
            lblStatus.setText("Conectado");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        pnRodape = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuClientes = new javax.swing.JMenu();
        menuAddCliente = new javax.swing.JMenuItem();
        menuListCliente = new javax.swing.JMenuItem();
        menuExcCliente = new javax.swing.JMenuItem();
        menuEditCliente = new javax.swing.JMenuItem();
        menuAnimais = new javax.swing.JMenu();
        menuAddAnimal = new javax.swing.JMenuItem();
        menuListAnimal = new javax.swing.JMenuItem();
        menuExcAnimal = new javax.swing.JMenuItem();
        menuEditAnimal = new javax.swing.JMenuItem();
        menuAtendimentos = new javax.swing.JMenu();
        menuAddAtendimento = new javax.swing.JMenuItem();
        menuListAtendimento = new javax.swing.JMenuItem();
        menuExcAtendimento = new javax.swing.JMenuItem();
        menuEditAtendimento = new javax.swing.JMenuItem();
        menuAtendentes = new javax.swing.JMenu();
        menuAddAtendente = new javax.swing.JMenuItem();
        menuListAtendente = new javax.swing.JMenuItem();
        menuExcAtendente = new javax.swing.JMenuItem();
        menuEditAtendente = new javax.swing.JMenuItem();
        menuVeterinários = new javax.swing.JMenu();
        menuAddVeterinario = new javax.swing.JMenuItem();
        menuListVeterinario = new javax.swing.JMenuItem();
        menuExcVeterinario = new javax.swing.JMenuItem();
        menuEditVeterinario = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        submenuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        submenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica Veterinária - Home");
        setMinimumSize(new java.awt.Dimension(480, 240));

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/error.png"))); // NOI18N
        lblStatus.setText("Desconhecido");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ver. 1.0.0");

        javax.swing.GroupLayout pnRodapeLayout = new javax.swing.GroupLayout(pnRodape);
        pnRodape.setLayout(pnRodapeLayout);
        pnRodapeLayout.setHorizontalGroup(
            pnRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRodapeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnRodapeLayout.setVerticalGroup(
            pnRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jDesktopPane1.setLayer(pnRodape, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 434, Short.MAX_VALUE)
                .addComponent(pnRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        menuClientes.setText("Clientes");

        menuAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        menuAddCliente.setText("Adicionar");
        menuAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuAddCliente);

        menuListCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuListCliente.setText("Todos");
        menuListCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListClienteActionPerformed(evt);
            }
        });
        menuClientes.add(menuListCliente);

        menuExcCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_delete.png"))); // NOI18N
        menuExcCliente.setText("Excluir");
        menuClientes.add(menuExcCliente);

        menuEditCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_edit.png"))); // NOI18N
        menuEditCliente.setText("Editar");
        menuClientes.add(menuEditCliente);

        jMenuBar1.add(menuClientes);

        menuAnimais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/heart.png"))); // NOI18N
        menuAnimais.setText("Animais");

        menuAddAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/heart_add.png"))); // NOI18N
        menuAddAnimal.setText("Adicionar");
        menuAddAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddAnimalActionPerformed(evt);
            }
        });
        menuAnimais.add(menuAddAnimal);

        menuListAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuListAnimal.setText("Todos");
        menuAnimais.add(menuListAnimal);

        menuExcAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/heart_delete.png"))); // NOI18N
        menuExcAnimal.setText("Excluir");
        menuAnimais.add(menuExcAnimal);

        menuEditAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pencil.png"))); // NOI18N
        menuEditAnimal.setText("Editar");
        menuAnimais.add(menuEditAnimal);

        jMenuBar1.add(menuAnimais);

        menuAtendimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.png"))); // NOI18N
        menuAtendimentos.setText("Atendimentos");

        menuAddAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar_add.png"))); // NOI18N
        menuAddAtendimento.setText("Adicionar");
        menuAddAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddAtendimentoActionPerformed(evt);
            }
        });
        menuAtendimentos.add(menuAddAtendimento);

        menuListAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuListAtendimento.setText("Todos");
        menuAtendimentos.add(menuListAtendimento);

        menuExcAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar_delete.png"))); // NOI18N
        menuExcAtendimento.setText("Excluir");
        menuAtendimentos.add(menuExcAtendimento);

        menuEditAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar_edit.png"))); // NOI18N
        menuEditAtendimento.setText("Editar");
        menuAtendimentos.add(menuEditAtendimento);

        jMenuBar1.add(menuAtendimentos);

        menuAtendentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group.png"))); // NOI18N
        menuAtendentes.setText("Atendentes");
        menuAtendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtendentesActionPerformed(evt);
            }
        });

        menuAddAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_add.png"))); // NOI18N
        menuAddAtendente.setText("Adicionar");
        menuAddAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddAtendenteActionPerformed(evt);
            }
        });
        menuAtendentes.add(menuAddAtendente);

        menuListAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuListAtendente.setText("Todos");
        menuListAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListAtendenteActionPerformed(evt);
            }
        });
        menuAtendentes.add(menuListAtendente);

        menuExcAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_delete.png"))); // NOI18N
        menuExcAtendente.setText("Excluir");
        menuAtendentes.add(menuExcAtendente);

        menuEditAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_edit.png"))); // NOI18N
        menuEditAtendente.setText("Editar");
        menuAtendentes.add(menuEditAtendente);

        jMenuBar1.add(menuAtendentes);

        menuVeterinários.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vcard.png"))); // NOI18N
        menuVeterinários.setText("Veterinários");

        menuAddVeterinario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vcard_add.png"))); // NOI18N
        menuAddVeterinario.setText("Adicionar");
        menuAddVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddVeterinarioActionPerformed(evt);
            }
        });
        menuVeterinários.add(menuAddVeterinario);

        menuListVeterinario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N
        menuListVeterinario.setText("Todos");
        menuListVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListVeterinarioActionPerformed(evt);
            }
        });
        menuVeterinários.add(menuListVeterinario);

        menuExcVeterinario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vcard_delete.png"))); // NOI18N
        menuExcVeterinario.setText("Excluir");
        menuVeterinários.add(menuExcVeterinario);

        menuEditVeterinario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vcard_edit.png"))); // NOI18N
        menuEditVeterinario.setText("Editar");
        menuVeterinários.add(menuEditVeterinario);

        jMenuBar1.add(menuVeterinários);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bug.png"))); // NOI18N
        menuSobre.setText("Sobre");

        submenuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/help.png"))); // NOI18N
        submenuSobre.setText("Sobre o software");
        menuSobre.add(submenuSobre);

        jMenuBar1.add(menuSobre);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/door_out.png"))); // NOI18N
        menuSair.setText("Logout");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });

        submenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_go.png"))); // NOI18N
        submenuSair.setText("Sair");
        submenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSairActionPerformed(evt);
            }
        });
        menuSair.add(submenuSair);

        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddClienteActionPerformed
        // TODO add your handling code here:
        CadastrarCliente cadClienteVeiew = new CadastrarCliente();
        jDesktopPane1.add(cadClienteVeiew);
        cadClienteVeiew.setVisible(true);
    }//GEN-LAST:event_menuAddClienteActionPerformed

    private void menuAddAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAddAnimalActionPerformed

    private void menuAddAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddAtendimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAddAtendimentoActionPerformed

    private void menuAddAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddAtendenteActionPerformed
        // TODO add your handling code here:
        CadastrarAtendente cadAtendenteView = new CadastrarAtendente();
        jDesktopPane1.add(cadAtendenteView);
        cadAtendenteView.setVisible(true);
    }//GEN-LAST:event_menuAddAtendenteActionPerformed

    private void menuAddVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddVeterinarioActionPerformed
        // TODO add your handling code here:
        CadastroVeterinario cadVeterinarioView = new CadastroVeterinario();
        jDesktopPane1.add(cadVeterinarioView);
        cadVeterinarioView.setVisible(true);
    }//GEN-LAST:event_menuAddVeterinarioActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuSairActionPerformed

    private void submenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
        LoginAtendente loginAtendenteView = new LoginAtendente();
        loginAtendenteView.setVisible(true);
    }//GEN-LAST:event_submenuSairActionPerformed

    private void menuListClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListClienteActionPerformed
        // TODO add your handling code here:
        ListarClientes listarClientesView = new ListarClientes();
        jDesktopPane1.add(listarClientesView);
        listarClientesView.setVisible(true);
    }//GEN-LAST:event_menuListClienteActionPerformed

    private void menuListVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListVeterinarioActionPerformed
        // TODO add your handling code here:
        ListarVeterinarios listaVeterinarioView = new ListarVeterinarios();
        jDesktopPane1.add(listaVeterinarioView);
        listaVeterinarioView.setVisible(true);
    }//GEN-LAST:event_menuListVeterinarioActionPerformed

    private void menuAtendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtendentesActionPerformed

    }//GEN-LAST:event_menuAtendentesActionPerformed

    private void menuListAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListAtendenteActionPerformed
        // TODO add your handling code here:
        ListarAtendentes listaAtendenteView = new ListarAtendentes();
        jDesktopPane1.add(listaAtendenteView);
        listaAtendenteView.setVisible(true);
    }//GEN-LAST:event_menuListAtendenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem menuAddAnimal;
    private javax.swing.JMenuItem menuAddAtendente;
    private javax.swing.JMenuItem menuAddAtendimento;
    private javax.swing.JMenuItem menuAddCliente;
    private javax.swing.JMenuItem menuAddVeterinario;
    private javax.swing.JMenu menuAnimais;
    private javax.swing.JMenu menuAtendentes;
    private javax.swing.JMenu menuAtendimentos;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuEditAnimal;
    private javax.swing.JMenuItem menuEditAtendente;
    private javax.swing.JMenuItem menuEditAtendimento;
    private javax.swing.JMenuItem menuEditCliente;
    private javax.swing.JMenuItem menuEditVeterinario;
    private javax.swing.JMenuItem menuExcAnimal;
    private javax.swing.JMenuItem menuExcAtendente;
    private javax.swing.JMenuItem menuExcAtendimento;
    private javax.swing.JMenuItem menuExcCliente;
    private javax.swing.JMenuItem menuExcVeterinario;
    private javax.swing.JMenuItem menuListAnimal;
    private javax.swing.JMenuItem menuListAtendente;
    private javax.swing.JMenuItem menuListAtendimento;
    private javax.swing.JMenuItem menuListCliente;
    private javax.swing.JMenuItem menuListVeterinario;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JMenu menuVeterinários;
    private javax.swing.JPanel pnRodape;
    private javax.swing.JMenuItem submenuSair;
    private javax.swing.JMenuItem submenuSobre;
    // End of variables declaration//GEN-END:variables
}
