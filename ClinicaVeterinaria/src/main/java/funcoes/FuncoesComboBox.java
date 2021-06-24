/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;
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

    public void resetComboBox(org.jdesktop.swingx.JXComboBox combobox) {
        combobox.removeAllItems();
    }

    public void populaComboBox(Cliente cliente, org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        listaClientes = cliente.pegarClientes(cliente);

        if (!listaClientes.isEmpty()) {
            combobox.setEnabled(true);

            for (Cliente c : listaClientes) {
                combobox.addItem(c.getNome() + " - " + c.getCpf());
            }
            
        }

        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }

    public void populaComboBox(Atendente atendente, org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Atendente> listaAtendentes = new ArrayList<>();

        listaAtendentes = atendente.pegarAtendentes(atendente);

        for (Atendente a : listaAtendentes) {
            //combobox.addItem(a.getNome());
            combobox.addItem(a.getUsuario());
        }

        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }

    public void populaComboBox(Veterinario veterinario, org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

        listaVeterinarios = veterinario.pegarVeterinarios(veterinario);

        if (!listaVeterinarios.isEmpty()) {
            combobox.setEnabled(true);

            for (Veterinario v : listaVeterinarios) {
                combobox.addItem(v.getNome());
            }

        }

        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }

    public void populaComboBox(Animal animal, org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Animal> listaAnimais = new ArrayList<>();

        listaAnimais = animal.pegarAnimais(animal);

        for (Animal a : listaAnimais) {
            combobox.addItem(a.getNomeAnimal());
        }

        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }

    public void populaComboBox(Animal animal, int idDono, org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Animal> listaAnimais = new ArrayList<>();

        listaAnimais = animal.getAnimaisByDono(animal, idDono);

        for (Animal a : listaAnimais) {
            combobox.addItem(a.getNomeAnimal());
        }

        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }
    
    public void populaComboBoxAnimalComId(Animal animal, org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Animal> listaAnimais = new ArrayList<>();

        listaAnimais = animal.pegarAnimais(animal);

        for (Animal a : listaAnimais) {
            combobox.addItem(a.getIdAnimal() + " - " + a.getNomeAnimal());
        }

        AutoCompleteDecorator.decorate(combobox);
        combobox.setSelectedItem(null);
    }
}
