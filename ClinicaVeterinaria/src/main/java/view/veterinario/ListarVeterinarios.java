/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.veterinario;

import controller.VeterinarioController;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.*;
import model.Veterinario;

/**
 *
 * @author lukas
 */
public class ListarVeterinarios extends javax.swing.JInternalFrame {
    Veterinario veterinario = new Veterinario();
    VeterinarioController veterinarioController = new VeterinarioController();
    ArrayList<Veterinario> listaVeterinario = new ArrayList<>();
    
    /**
     * Creates new form ListarVeterinario
     */
    public ListarVeterinarios() {
        initComponents();
        
        String colunas[] = {"Nome", "CPF", "Telefone", "Endereço"};
        Object[] [] data = { };
        DefaultTableModel modelo = new DefaultTableModel(data, colunas);    
        jTable1.setModel(modelo);
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN); //desativa tamanho automatico das colunas
        jTable1.getColumnModel().getColumn(0).setMinWidth(150);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(1).setMinWidth(100);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(2).setMinWidth(100);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
        
        jTable1.setAutoCreateRowSorter(true);
        listaVeterinario = veterinarioController.pegarVeterinarios(veterinario);

        for (Veterinario v : listaVeterinario){
            modelo.addRow(new Object[]{
                v.getNome(),
                v.getCpf(),
                v.getTelefone(),
                v.getRua() + ", " + v.getBairro() + " - " +v.getNumero()
        });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Clínica Veterinária - Todos os Veterinários");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N

        jTable1.setModel(jTable1.getModel());
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
