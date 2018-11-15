/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casillas
 */
import java.util.Scanner;

class Weight_kilograms extends Weight_Pounds{
    private double weight;
    public void setWeight(double newPounds){
        
        if(newPounds<0) this.weight=2.2046;
        else this.weight=newPounds;
        
        super.setWeight(this.weight);
    }
    
    public double getWeight(){
       return weight;
    }
}

class TestDemo2 {
    private double weight;
    private int choice_for_unit;
    Scanner sc=new Scanner(System.in);
    
    public void menu_for_unit(){
        
        System.out.println("***********************");
        System.out.println("enter # to choice unit*");
        System.out.println("1)pounds              *");
        System.out.println("2)grams               *");
        System.out.println("3)quit                *");
        System.out.println("***********************");
    }
    
    public int ask_for_unit(){
    
        System.out.println("please tell me which unit you want to use?");
        choice_for_unit=sc.nextInt();
        return choice_for_unit;
    }
    
    public void switchCase_for_unit(int choice_for_unit){
         double weight;
         TestPoundsDemo tpd=new TestPoundsDemo();
         switch(choice_for_unit){
         
             case 1:tpd.looping_for_stars();
                    break;
                    
             case 2:tpd.menu_for_stars();
                    Weight_kilograms g=new Weight_kilograms();
                    g.setWeight(askGrams());
                    if(g.getWeight()>0){
                        tpd.switchCase_for_stars_weight_bigger_zero(g,g.getWeight(),tpd.ask_choice_stars());
                    }else
                        tpd.switchCase_for_stars_weight_smaller_Zero(g,g.getWeight());
                        
                    break;
                    
             case 3:System.out.println("quit");
                    break;
             default:System.out.println("please enter a valid choice");
         } 
    }
    
    public void looping_for_unit(){
    
        int choice;
        double weight;
        do{
           menu_for_unit();
           choice=ask_for_unit();
           switchCase_for_unit(choice);
        
         }while(choice!=3);
    }
    
    public double askGrams(){
       
         System.out.println("tell me your weight on earth");
         weight=sc.nextDouble();
         return weight;
    }
    
}

public class Homework12 {
     public static void main(String []args){
     
           TestDemo2 td2=new TestDemo2();
           td2.looping_for_unit();
     }
}