/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador;


public class Letras {
    
   char letra;
    int cont=0;
    
public Letras(char letra){
     cont=1;
     this.letra = letra;
}

   @Override
   public String toString(){
    return  letra + "= " + cont;
}
    
}
