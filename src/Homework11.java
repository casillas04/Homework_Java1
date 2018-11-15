
import java.util.Scanner;
class Weight_Pounds{
   
    private double weight;
    
    
    public Weight_Pounds(){
       
    }
    public void setWeight(double newPounds){
        
        if(newPounds<0) this.weight=100.0;
        else this.weight=newPounds;
    
    }
    
    public double getMoonWeight(){
       return this.weight*0.1;
    }
    
    public double getMercuryWeight(){
        return this.weight*0.3;
    }
    
    public double getVenusWeight(){
        return this.weight*0.9;
    }
    
    public double getMarsWeight() {
    
        return this.weight*0.3;
    }
    
    public double getWeight(){
        return this.weight;
    }

}
class TestPoundsDemo{
    
    Scanner sc=new Scanner(System.in);
    private double weight;
    private int answer_for_choice_star;
    
    public void menu_for_stars(){
    
        System.out.println("*************************");
        System.out.println("*Star menu              *");
        System.out.println("press # to make a choice*");
        System.out.println("1 weight on moon        *");
        System.out.println("2 weight on mercury     *");
        System.out.println("3 weight on venus       *");
        System.out.println("4 weight on mars        *");
        System.out.println("5 quit                  *");
        System.out.println("*************************");
    }
    
    public double askWeight(){
    
        System.out.println("tell me your weight on earth");
        weight=sc.nextDouble();
        return weight;
    }
    
    public int ask_choice_stars(){
    
        System.out.println("tell me your choice on the star menu");
        answer_for_choice_star=sc.nextInt();
        return answer_for_choice_star;
    }
    
    public void switchCase_for_stars_weight_bigger_zero(Weight_Pounds p,double newWeight,int answer_for_choice_star){
    
         switch(answer_for_choice_star){
         
             case 1: p.setWeight(newWeight);
                     System.out.println("weight on moon"+p.getMoonWeight());
                     break;
             case 2: p.setWeight(newWeight);
                     System.out.println("weight on mercury"+p.getMercuryWeight());
                     break;
             case 3: p.setWeight(newWeight);
                     System.out.println("weight on Venus"+p.getVenusWeight());
                     break;
             case 4: p.setWeight(newWeight);
                     System.out.println("weight on mars"+p.getMarsWeight());
             case 5: System.out.println("thank you");
                     break;
             default:System.out.println("please enter a valid choice");
         }
    }
    
    public void switchCase_for_stars_weight_smaller_Zero(Weight_Pounds p,double newWeight){
    
          p.setWeight(newWeight);
          System.out.println("weight on moon"+p.getMoonWeight());
          System.out.println("weight on mercury"+p.getMercuryWeight());
          System.out.println("weight on Venus"+p.getVenusWeight());
          System.out.println("weight on mars"+p.getMarsWeight());
    }
    
    public void looping_for_stars(){
        int choice;
        double weight;
        do{
           menu_for_stars();
           choice=ask_choice_stars();
           weight=askWeight();
           
           if(weight>0){
               switchCase_for_stars_weight_bigger_zero(new Weight_Pounds(),weight,choice);
           }else
               switchCase_for_stars_weight_smaller_Zero(new Weight_Pounds(),weight);
        
        }while(choice!=5);
    }

}

public class Homework11{

   public static void main(String []args){
   
       TestPoundsDemo tpd=new TestPoundsDemo();
       tpd.looping_for_stars();
   }
}