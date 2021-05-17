/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import java.util.ArrayList;
import model.Animal;
import model.Atendente;
import model.Cliente;
import model.Veterinario;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kairos-04
 */
public class FuncoesComboBox {
    
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
