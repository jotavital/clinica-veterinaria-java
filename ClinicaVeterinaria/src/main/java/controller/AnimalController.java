/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Animal;
import model.ClienteAnimal;

/**
 *
 * @author kairos-04
 */
public class AnimalController {

    public AnimalController() {
        
    }
    
    public boolean cadastrarAnimal(Animal animal, String nomeDono){
        return animal.cadastrarAnimal(animal, nomeDono);
    }
    
    public ArrayList<Animal> pegarAnimais(Animal animal){
        return animal.pegarAnimais(animal);
    }
    
    public ArrayList<ClienteAnimal> pegarAnimaisComDonos(ClienteAnimal clienteAnimal){
        return clienteAnimal.pegarAnimaisComDonos(clienteAnimal);
    }
    
}
