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
        
        if(animal.cadastrarAnimal(animal, nomeDono)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public ArrayList<Animal> pegarAnimais(Animal animal){
        
        if(animal.pegarAnimais(animal) != null){
            return animal.pegarAnimais(animal);
        }else{
            return null;
        }
    }
    
    public ArrayList<ClienteAnimal> pegarAnimaisComDonos(ClienteAnimal clienteAnimal){
        
        if(clienteAnimal.pegarAnimaisComDonos(clienteAnimal) != null){
            return clienteAnimal.pegarAnimaisComDonos(clienteAnimal);
        }else{
            return null;
        }
    }
    
}
