/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.animal;

import controller.AnimalController;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import model.Animal;
import model.Cliente;
import view.cliente.CadastrarCliente;
import view.Home;
import org.jdesktop.swingx.autocomplete.*;

/**
 *
 * @author kairos-04
 */
public class CadastrarAnimal extends javax.swing.JInternalFrame {
    
    JDesktopPane jDesktopPane1; // crio o painel que vai receber o painel principal da home
    /**
     * Creates new form CadastrarAnimal
     */
    public CadastrarAnimal(JDesktopPane jDpanel) {
        initComponents();
        jDesktopPane1 = jDpanel;  // atribui o painel que veio da home para uma variavel global
        
        populaCbDono();
        
    }
    
    public void populaCbDono(){
        limpaCbDono();
        
        //populando a combobox do dono do animal
        ArrayList<Cliente> listaClientes = new ArrayList<>(); // cria lista que vai armazenar os clientes do banco
        Object objCliente[] = {}; // vai armazenar cada cliente que vier do banco
        
        Cliente cliente = new Cliente();
        listaClientes = cliente.pegarClientes(cliente); // metodo vai puxar os clientes do banco e retornar pra dentro da lista
        
        for (Cliente c : listaClientes) { // para cada cliente que veio do banco, adiciona uma linha na combobox
            cbDono.addItem(c.getNome());
        }
        
        AutoCompleteDecorator.decorate(cbDono); // coloca funcao de autocomplete na combobox
        cbDono.setSelectedItem(null);
    }
    
    public void limpaCbDono(){
        cbDono.removeAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnForm = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblEspecie = new javax.swing.JLabel();
        lblRaca = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblDono = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEspecie = new javax.swing.JTextField();
        txtRaca = new javax.swing.JTextField();
        cbDono = new org.jdesktop.swingx.JXComboBox();
        btnCadastrar = new javax.swing.JButton();
        spnIdade = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        btnAddDono = new javax.swing.JButton();
        btnRefreshDono = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setTitle("Clínica Veterinária - Cadastrar Animais");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/heart_add.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/heart_add.png"))); // NOI18N
        lblTitulo.setText("Cadastrar Animais");

        javax.swing.GroupLayout pnTituloLayout = new javax.swing.GroupLayout(pnTitulo);
        pnTitulo.setLayout(pnTituloLayout);
        pnTituloLayout.setHorizontalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(175, 175, 175))
        );
        pnTituloLayout.setVerticalGroup(
            pnTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNome.setText("Nome:");

        lblEspecie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEspecie.setText("Espécie:");

        lblRaca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRaca.setText("Raça:");

        lblIdade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdade.setText("Idade:");

        lblDono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDono.setText("Dono:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        spnIdade.setModel(new javax.swing.SpinnerNumberModel(0, 0, 50, 1));

        jLabel1.setText("anos");

        btnAddDono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAddDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDonoActionPerformed(evt);
            }
        });

        btnRefreshDono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow_refresh.png"))); // NOI18N
        btnRefreshDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshDonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFormLayout = new javax.swing.GroupLayout(pnForm);
        pnForm.setLayout(pnFormLayout);
        pnFormLayout.setHorizontalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnFormLayout.createSequentialGroup()
                                .addComponent(lblRaca)
                                .addGap(18, 18, 18)
                                .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnFormLayout.createSequentialGroup()
                                .addComponent(lblEspecie)
                                .addGap(18, 18, 18)
                                .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnFormLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addComponent(lblIdade)
                        .addGap(18, 18, 18)
                        .addComponent(spnIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnFormLayout.createSequentialGroup()
                        .addComponent(lblDono)
                        .addGap(18, 18, 18)
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnFormLayout.createSequentialGroup()
                                .addComponent(btnAddDono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefreshDono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
                .addGap(151, 151, 151))
        );

        pnFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblDono, lblEspecie, lblIdade, lblNome, lblRaca});

        pnFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEspecie, txtNome, txtRaca});

        pnFormLayout.setVerticalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspecie)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaca)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(spnIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDono)
                    .addComponent(cbDono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddDono)
                    .addComponent(btnRefreshDono))
                .addGap(17, 17, 17)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(pnForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        AnimalController controller = new AnimalController();
        String nome, especie, raca;
        int idade;
        
        nome = txtNome.getText();
        especie = txtEspecie.getText();
        raca = txtRaca.getText();
        idade = (Integer)spnIdade.getValue();
        
        Animal animal = new Animal(nome, especie, raca, idade);
        String nomeDono = cbDono.getStringAt(cbDono.getSelectedIndex()); // pegando o nome selecionado na combobox
        
        controller.cadastrarAnimal(animal, nomeDono);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAddDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDonoActionPerformed
        // TODO add your handling code here:
        CadastrarCliente cadClienteView = new CadastrarCliente();
        jDesktopPane1.add(cadClienteView); // consigo adicionar no painel que veio por parametro da home, ou seja essa view aparece no painel da home
        cadClienteView.setVisible(true);
    }//GEN-LAST:event_btnAddDonoActionPerformed

    private void btnRefreshDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshDonoActionPerformed
        // TODO add your handling code here:
        populaCbDono();
    }//GEN-LAST:event_btnRefreshDonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDono;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnRefreshDono;
    private org.jdesktop.swingx.JXComboBox cbDono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDono;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRaca;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnForm;
    private javax.swing.JPanel pnTitulo;
    private javax.swing.JSpinner spnIdade;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRaca;
    // End of variables declaration//GEN-END:variables
}
