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
public class Homework13 {
    public static void main(String []args){
       stringInput();
    }
    static void stringInput(){
        String a;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a string you want.");
        a=sc.nextLine();
        findMiddle(a);
    }
    
    static void findMiddle(String str){
        int len=str.length();
        
        if(len%2==1)
            System.out.println(str.charAt(len/2));
        else{
            System.out.print(str.charAt(len/2-1));
            System.out.print(str.charAt(len/2));
        }
    }
}
