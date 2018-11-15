/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casillas
 */
import java.util.ArrayList;
class Name{
    ArrayList<String>name=new ArrayList<>();
    public void setName(String s){
        name.add(s);
    }
    
    public ArrayList<String> getName(){
        return name;
    }
}
public class Homework14 {
    public static void main(String []args){
    
       Name n=new Name();
       n.setName("Siyuan");
       n.setName("Kaka");
       for(String i:n.getName()){
          
           System.out.println(i);
       }
    }
}
