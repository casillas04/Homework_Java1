
import java.util.Scanner;
import java.io.*;
public class Homework10 {
    public static void main(String []args){
    
       choice();
    }
    
    
    static void menu(){
    
        System.out.println("1.print out all the integers in the array");
        System.out.println("2.sum and output all the odd numbers");
        System.out.println("3.sum and output all the even numbers");
        System.out.println("4.show the mean average");
        System.out.println("5.outout the middle value of the array");
        System.out.println("6.output the first value of the array");
        System.out.println("7.output the last value of the array");
        System.out.println("8.sort the array and print them into txt");
        System.out.println("9.find the number in linear search");
        System.out.println("10.quit");
    }
    
    static void choice(){
        int answer;
        Random r=new Random();
        r.setArray();
        do{
           menu();
           System.out.println("Tell me which options do you want to choose");
           Scanner sc=new Scanner(System.in);
           answer=sc.nextInt();
         
           
        switch(answer){
        
            case 1: r.printOut();
                    break;
            case 2: r.setOdd();
                    System.out.println("the sum of the odd is"+r.getOdd());
                    break;
            case 3: r.setEven();
                    System.out.println("the sum of the even is"+r.getEven());
                    break;
            case 4: r.setMean();
                    System.out.println("the mean of the array is"+r.getMean());
                    break;
            case 5: r.getMiddle();
                    break;
            case 6: System.out.println("the first of the array is"+r.getFirst());
                    break;
            case 7: System.out.println("the last of the array is"+r.getLast());
                    break;
            case 8: r.printInText();
                    break;
            case 9: r.linearSearch();
                    break;
            case 10: System.out.println("thanks for choosing");
                    break;
            default:System.out.println("please enter a valid choice");
        }
        
        }while(answer!=10);
    }
    
    
}

class Random {
   private int array_size=500;
   private int[]array=new int[array_size];
   private int odd;
   private int even;
   private double mean;
   
   public void setArray(){
   
        for(int i=0;i<array_size;i++){
      
          double a;
          a=Math.random()*1000;
          array[i]=(int)a;
      }
   
   }
   
   public int[] getArray(){
   
       return array;
   }
   
   public void printOut(){
      
       
       for(int i:array){
           System.out.println(i);
       }
   }
   
   public void setEven(){
   
       
        int result=0;
         for(int i:array){
        
           if(i%2==0){
               System.out.println(i);
               result=result+i;
           }
        }
       this.even=result;
   }
   
   public int getEven(){
       return even;
   }
   
   public void setOdd(){
   
       
       int result=0;
        for(int i:array){
        
           if(i%2==1){
               System.out.println(i);
               result=result+i;
           }
        }
      this.odd=result;
   }
   
   public int getOdd(){
       return this.odd;
   }

   public void setMean(){
       
       
       int result1=0;
      
       
       for(int i:array){
           result1=result1+i;
       }
       
       mean=result1/array.length;
   }
   
   public double getMean(){
       return mean;
   }
   
   public void getMiddle(){
  
       System.out.println(array[array.length/2-1]);
       System.out.println(array[array.length/2]);
   }
   
   public int getFirst(){
   
      
      return array[0];
   }
   
   public int getLast(){

      return array[array.length-1];
   }
   
   public int [] bubbleSort(int []array){
   
        int n = array.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (array[j] > array[j+1]) 
                { 
                    // swap temp and arr[i] 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                } 
        
        return array;
   }
   
   public void printInText(){
   
       array=bubbleSort(array);
       for(int i:array){
           System.out.println(i);
       }
          File f=new File("angel.txt");
       try(
           
           PrintWriter output =new PrintWriter(f);
       ){
           for(int i:array)
               output.write(i);
       }catch(IOException ex){
       
           ex.printStackTrace();
       }
       
    }
   
    public void linearSearch(){
        
       array=bubbleSort(array);
       int position=1;
       int count=0;
       int answer;
       Scanner sc=new Scanner(System.in);
       System.out.println("tell me the number you want to search?");
       answer=sc.nextInt();
       
       for(int i:array){
          if(answer==i){
               System.out.println("the number you want is in the position "+position);
               count++;
          }
          position++;
       }
       
       if(count==0)
            System.out.println("the number you want is not in the array");
    }
}
