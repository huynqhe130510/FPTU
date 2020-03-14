/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W3;

/**
 *
 * @author Kudo
 */
public class CanBo {
    String type;
    String name;

    public CanBo() {
    }

    public CanBo(String type, String name) {
        
        this.name = name;
        this.type = type;
        boolean isCV = true;
        char c;
        for(int i = 0; i < type.length(); i++){
           c = type.charAt(i);
           if(!Character.isLetter(c)){
               isCV = false;
           }
        }
        if(isCV == true ){
            this.name = "AA" + name;
        }
        else{
            this.name = "BBB" + name;
        }
    }
    

    

    public String getTen() {
         if(name.length() > 4){
            return this.name;
        }
        else 
            return "0000";
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
    
}
