package funcoes;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Animal;
import model.Atendente;
import model.Cliente;
import model.Veterinario;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

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
    
    public void resetFields(JPanel painel){
        for (Component c : painel.getComponents()) {
            if (c instanceof JTextField){
                ((JTextField)c).setText("");
            }else if (c instanceof JPasswordField){
                ((JPasswordField)c).setText("");
            }
        }
    }
    
    public void resetComboBox(org.jdesktop.swingx.JXComboBox combobox){
        combobox.removeAllItems();
    }
    
    public void populaComboBox(Cliente cliente, org.jdesktop.swingx.JXComboBox combobox){
        resetComboBox(combobox);
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        listaClientes = cliente.pegarClientes(cliente);
        
        for (Cliente c : listaClientes) {
            combobox.addItem(c.getNome());
        }
        
        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }
    
    public void populaComboBox(Atendente atendente, org.jdesktop.swingx.JXComboBox combobox){
        resetComboBox(combobox);
        
        ArrayList<Atendente> listaAtendentes = new ArrayList<>();
        
        listaAtendentes = atendente.pegarAtendentes(atendente);
        
        for (Atendente a : listaAtendentes) {
            combobox.addItem(a.getNome());
        }
        
        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }
    
    public void populaComboBox(Veterinario veterinario, org.jdesktop.swingx.JXComboBox combobox){
        resetComboBox(combobox);
        
        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
        
        listaVeterinarios = veterinario.pegarVeterinarios(veterinario);
        
        for (Veterinario v : listaVeterinarios) {
            combobox.addItem(v.getNome());
        }
        
        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }
    
    public void populaComboBox(Animal animal, org.jdesktop.swingx.JXComboBox combobox){
        resetComboBox(combobox);
        
        ArrayList<Animal> listaAnimais = new ArrayList<>();
        
        listaAnimais = animal.pegarAnimais(animal);
        
        for (Animal a : listaAnimais) {
            combobox.addItem(a.getNomeAnimal());
        }
        
        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }
}
