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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextField;
import model.Animal;
import model.Atendente;
import model.Cliente;
import model.Consulta;
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

    public void populaComboBox(Consulta consulta, org.jdesktop.swingx.JXComboBox combobox) throws ParseException {
        resetComboBox(combobox);

        ArrayList<Consulta> listaConsultas = new ArrayList<>();

        listaConsultas = consulta.pegarConsultas(consulta);

        for (Consulta c : listaConsultas) {
            //combobox.addItem(a.getNome());
            Date dataConsulta = new SimpleDateFormat("yyyy-MM-dd").parse(c.getData_consulta());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            combobox.addItem(formatador.format(dataConsulta) + " - " + c.getDescricao());
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
                // combobox.addItem(v.getNome());
                combobox.addItem(v.getNome() + " - " + v.getCpf());
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

    public void populaComboBoxAnimalComIdByDono(Animal animal, int idDono , org.jdesktop.swingx.JXComboBox combobox) {
        resetComboBox(combobox);

        ArrayList<Animal> listaAnimais = new ArrayList<>();

        listaAnimais = animal.getAnimaisByDono(animal, idDono);

        for (Animal a : listaAnimais) {
            combobox.addItem(a.getIdAnimal() + " - " + a.getNomeAnimal());
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

    public void populaComboBoxSelecionandoDono(Cliente cliente, org.jdesktop.swingx.JXComboBox combobox, String cpfDono) {
        resetComboBox(combobox);

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        listaClientes = cliente.pegarClientes(cliente);

        if (!listaClientes.isEmpty()) {
            combobox.setEnabled(true);

            int i = 0;

            for (Cliente c : listaClientes) {
                combobox.addItem(c.getNome() + " - " + c.getCpf());

                if (c.getCpf().equals(cpfDono)) {
                    combobox.setSelectedIndex(i);
                }
                i++;
            }

        }

        AutoCompleteDecorator.decorate(combobox);
    }
    
    public void populaComboBoxSelecionandoAnimal(Animal animal, org.jdesktop.swingx.JXComboBox combobox, int idAnimal) {
        resetComboBox(combobox);

        ArrayList<Animal> listaAnimais = new ArrayList<>();

        listaAnimais = animal.pegarAnimais(animal);

        if (!listaAnimais.isEmpty()) {
            combobox.setEnabled(true);

            int i = 0;

            for (Animal a : listaAnimais) {
                combobox.addItem(a.getIdAnimal()+ " - " + a.getNomeAnimal());

                if (a.getIdAnimal() == idAnimal) {
                    combobox.setSelectedIndex(i);
                }
                i++;
            }

        }

        AutoCompleteDecorator.decorate(combobox);
    }
    
    public void populaComboBoxSelecionandoAnimalByDono(Animal animal, org.jdesktop.swingx.JXComboBox combobox, int idAnimal, int idDono) {
        resetComboBox(combobox);

        ArrayList<Animal> listaAnimais = new ArrayList<>();

        listaAnimais = animal.getAnimaisByDono(animal, idDono);

        if (!listaAnimais.isEmpty()) {
            combobox.setEnabled(true);

            int i = 0;

            for (Animal a : listaAnimais) {
                combobox.addItem(a.getIdAnimal()+ " - " + a.getNomeAnimal());

                if (a.getIdAnimal() == idAnimal) {
                    combobox.setSelectedIndex(i);
                }
                i++;
            }

        }

        AutoCompleteDecorator.decorate(combobox);
    }
    
    public void populaComboBoxSelecionandoVeterinario(Veterinario veterinario, org.jdesktop.swingx.JXComboBox combobox, String cpfVet) {
        resetComboBox(combobox);

        ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();

        listaVeterinarios = veterinario.pegarVeterinarios(veterinario);

        if (!listaVeterinarios.isEmpty()) {
            combobox.setEnabled(true);

            int i = 0;

            for (Veterinario v : listaVeterinarios) {
                combobox.addItem(v.getNome() + " - " + v.getCpf());

                if (v.getCpf().equals(cpfVet)) {
                    combobox.setSelectedIndex(i);
                }
                i++;
            }

        }

        AutoCompleteDecorator.decorate(combobox);
    }
}
