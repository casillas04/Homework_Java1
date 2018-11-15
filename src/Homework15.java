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
import java.io.*;
import java.util.Scanner;
class BankAccount {

     private ArrayList<Double>Deposit=new ArrayList<>();
     private ArrayList<Double>Withdraw=new ArrayList<>();
     private double balance;
     
     public void setDeposit(double deposit){
         Deposit.add(deposit);
     }
     
     public ArrayList<Double> getDeposit(){
         return this.Deposit;
     }
     
     public void setWithdraw(double withdraw){
         Withdraw.add(withdraw);
     }
     
     public ArrayList<Double>getWithdraw(){
         return this.Withdraw;
     }
     
     public void setBalance(){
         
       
         
         double all_deposit=0;
         double all_withdraw=0;
         
         
         for(double i:Deposit){
             all_deposit=all_deposit+i;
         }
         
         for(double i:Withdraw){
             all_withdraw=all_withdraw+i;
         }
         
         balance=all_deposit-all_withdraw;
         
     }
     
     public double getBalance(){
         return this.balance;
     }
     
     public void print_every_deposit(){
     
        for(double i:Deposit){
            System.out.println(i);
        }
     }
     
     public void print_every_withdraw(){
     
        for(double i:Withdraw){
            System.out.println(i);
        }
     }
     
     public void writeIntoFile(){
        File f=new File("bank.txt");
        
        try(
          PrintWriter output=new PrintWriter(f);
        ){
           output.print("deposit");
           output.print(" ");
           
           for(double i:Deposit){
               output.print(i);
               output.print(" ");
           }
           
           output.print("\n");
           
           output.print("withdraw");
           output.print(" ");
           
           for(double i:Withdraw){
               output.print(i);
               output.print(" ");
           }
           
          output.close();
           
        }catch(IOException ex){
        
           ex.printStackTrace();
        }
    }
     
     public void readFromFile()throws IOException{
     
         File f=new File("bank.txt");
     
         Scanner sc=new Scanner(f);
         while(sc.hasNext()){
            System.out.print(sc.next());
            System.out.println("\t");
         }
     }
     
}

class TestBankDemo {
    
     
     
     public void menu(){
     
         System.out.println("***************************");
         System.out.println("*Bank Account Program     *");
         System.out.println("*Enter # to choose        *");
         System.out.println("*1 Make a deposit         *");
         System.out.println("*2 Make a withdraw        *");
         System.out.println("*3 output the balance     *");
         System.out.println("*4 output all the deposit *");
         System.out.println("*5 output all the withdraw*");
         System.out.println("*6 write the data into file");
         System.out.println("*7 read the data from file ");
         System.out.println("*8 quit                   *");
         System.out.println("***************************");
     }
     
     public int ask_for_choice(){
        int answer;
        Scanner sc=new Scanner(System.in);
        System.out.println("what is your choice");
        answer=sc.nextInt();
        return answer;
     }
     
     public void looping(){
         int answer;
         double money ;
         BankAccount b=new BankAccount();
         do{
           menu();
           answer=ask_for_choice();
           switch_case(answer,b);
         
         }while(answer!=8);
     }
     
     public double askMoney(){
         double money;
         Scanner sc=new Scanner(System.in);
         System.out.println("How much money do you want ");
         money=sc.nextDouble();
         return money;
     }
     
     public void switch_case(int answer,BankAccount b){
       
        double money;
        switch(answer){
        
            case 1: money=askMoney();
                    b.setDeposit(money);
                    break;
            case 2: money=askMoney();
                    b.setWithdraw(money);
                    break;
            case 3: b.setBalance();
                    System.out.println("the balance in the account"+b.getBalance());
                    break;
            case 4: b.print_every_deposit();
                    break;
            case 5: b.print_every_withdraw();
                    break;
            case 6: b.writeIntoFile();
                    break;
            case 7: try{b.readFromFile();
                    }catch(IOException ex){ex.printStackTrace();}
                    break;
            case 8: System.out.println("Thank you");
                    break;
            default:System.out.println("please enter a valid number.");
        }
     
     }
}

public class Homework15 {
    public static void main(String []args){
    
        TestBankDemo t=new TestBankDemo();
        t.looping();
    }
}
