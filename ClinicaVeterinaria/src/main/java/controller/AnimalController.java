/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Animal;

/**
 *
 * @author kairos-04
 */
public class AnimalController {

    public AnimalController() {
        
    }
    
    public boolean cadastrarAnimal(Animal animal){
        
        if(animal.cadastrarAnimal(animal)){
            return true;
        }else{
            return false;
        }
        
    }
    
}
