/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;
import model.Cliente;
import controller.ClienteController;
import java.util.ArrayList;

/**
 *
 * @author picle
 */
public class ListarClientes extends javax.swing.JInternalFrame {
    Cliente cliente = new Cliente();
    ClienteController clienteController = new ClienteController();
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    /**
     * Creates new form ListarClientes
     */
    public ListarClientes() {
        initComponents();
        
        //criando a table e suas colunas, iniciando com os dados vazios para adicionar com o que vem do banco
        String colunas[] = {"Nome", "CPF", "Telefone", "Endereço"}; 
        Object[][] data = { }; // inicializa vazio pois os dados virão do banco
        DefaultTableModel modelo = new DefaultTableModel(data, colunas); // criando modelo com as colunas para colocar na table
        jTable1.setModel(modelo); //colocando o modelo na table
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN); //desativa tamanho automatico das colunas
        jTable1.getColumnModel().getColumn(0).setMinWidth(150); // seta tamanho das colunas
        jTable1.getColumnModel().getColumn(0).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(1).setMinWidth(100);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(2).setMinWidth(100);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
        
        jTable1.setAutoCreateRowSorter(true); //metodo que cria ordenador dos dados da table
        
        listaClientes = clienteController.pegarClientes(cliente); // metodo que vai chamar o controller > model e vai pegar os dados do banco e retornar em forma de arraylist
        
        for (Cliente c : listaClientes) { // para cada cliente no arraylist cria uma linha na table
            modelo.addRow(new Object[]{
                c.getNome(),
                c.getCpf(),
                c.getTelefone(),
                c.getRua() + ", " + c.getBairro() + " - " + c.getNumero()
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

        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setTitle("Clínica Veterinária - Todos os Clientes");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N

        jTable1.setModel(jTable1.getModel());
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
