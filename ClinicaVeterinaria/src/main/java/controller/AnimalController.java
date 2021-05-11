/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Animal;

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
    
}
