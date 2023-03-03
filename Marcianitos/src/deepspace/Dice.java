/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deepspace;

import java.util.Random;

/**
 *
 * @author mario
 */
class Dice {
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    
    private Random generator;
    
    Dice (){
        this.NHANGARSPROB = 0.25f;
        this.NSHIELDSPROB = 0.25f;
        this.NWEAPONSPROB = 0.33f;
        this.FIRSTSHOTPROB = 0.5f;
        
        this.generator = new Random();
    }
    
    int initWithNHangars (){
        int retorno = 1;
        
        if (this.generator.nextFloat() < NHANGARSPROB){
            retorno = 0;
        }
        
        return (retorno);
    }
    
    int initWithNWeapons (){
        int retorno = 3;
        
        float num = this.generator.nextFloat();
        
        if (num < NWEAPONSPROB){
            retorno = 1;
            
        } else if (num < 2*NWEAPONSPROB){
            retorno = 2;
        }
        
        return (retorno);
    }    
    
}
