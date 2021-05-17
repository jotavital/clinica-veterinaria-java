/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.animal;

import controller.AnimalController;
import controller.ClienteController;
import java.util.ArrayList;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Animal;
import model.ClienteAnimal;

/**
 *
 * @author kairos-04
 */
public class ListarAnimais extends javax.swing.JInternalFrame {

    ArrayList<ClienteAnimal> listaAnimaisDonos = new ArrayList<>();
    AnimalController animalController = new AnimalController();
    ClienteController clienteController = new ClienteController();
    Animal animal = new Animal();
    ClienteAnimal clienteAnimal = new ClienteAnimal();

    /**
     * Creates new form ListarAnimais
     */
    
    public ListarAnimais() {
        initComponents();

        String colunas[] = {"ID", "Nome", "Espécie", "Raça", "Idade", "Dono - Telefone"};
        Object data[][] = {};
        DefaultTableModel modelo = new DefaultTableModel(data, colunas);

        jTable1.setModel(modelo);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        jTable1.getColumnModel().getColumn(0).setMinWidth(40);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(4).setMinWidth(50);

        //ordenando pela coluna de nome
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 1;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();

        listaAnimaisDonos = animalController.pegarAnimaisComDonos(clienteAnimal);

        for (ClienteAnimal ca : listaAnimaisDonos) {
            modelo.addRow(new Object[]{
                ca.getIdAnimal(),
                ca.getNomeAnimal(),
                ca.getEspecieAnimal(),
                ca.getRacaAnimal(),
                ca.getIdadeAnimal(),
                ca.getNomeDono() + " - " + ca.getTelefoneDono()
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
        setTitle("Clínica Veterinária - Todos os Animais");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/book_open.png"))); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
