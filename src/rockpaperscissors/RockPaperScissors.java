
package rockpaperscissors;
import java.util.*;
public class RockPaperScissors {

public int wins=0;
public int losses=0;
public int draws=0;
public int cats=1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand= new Random ();
        RockPaperScissors rps = new RockPaperScissors();
        boolean carryOn=true;
        int choice=0;
        boolean valid = false;
        while(carryOn==true){
            
            
            while(valid ==false){
                
                try {
                    if(rps.catUsed()==true){
                    System.out.println("please select your choice \n1>rock\n2>paper\n3>scissors\n");
                    }else if (rps.catUsed()==false){
                     System.out.println("please select your choice (you get to use 1 cat per session, they steal the scissors, eat the rock and rip the paper)\n1>rock\n2>paper\n3>scissors\n4>cat");
                    }
                     choice = input.nextInt();
                     valid = true;
                     if(rps.catUsed()==true && choice==4){
                         valid = false;
                         System.out.println("\nyou have already used the cat");
                     }
                } catch (Exception e) {
                    System.out.println("please enter an integer\n\n"+e);
                    input.next();
                }
       
            }
            valid=false;
        int computerChoice= rand.nextInt(2);
        if (computerChoice==0){
            System.out.println("the computer chose rock, you "+rps.rock(choice));
        }else if (computerChoice==1){
            System.out.println("the computer chose paper, you "+rps.paper(choice));
        }else if (computerChoice==2){
            System.out.println("the computer chose rock, you "+rps.scissors(choice));
        }
            System.out.println("   would you like to play again?\n   1>YES\n   2>NO");
            choice=input.nextInt();
            if(choice==2){
                carryOn=false;
            }
            System.out.println("\n\n");
        rps.results();
            System.out.println("\n\n");
        }
    }
    public String rock(int Choice){
        String outcome=null;
        if (Choice==1){
            outcome="draw";
            draws++;
        }else if (Choice==2){
            outcome="win";
            wins++;
        }else if (Choice==3){
            outcome="lose";
            losses++;
        }else if (Choice==4){
            outcome="win";
            wins++;
            cats--;
        }
        return outcome;
    }
    public String paper(int Choice){
        String outcome=null;
        if (Choice==1){
            outcome="lose";
            losses++;
        }else if (Choice==2){
            outcome="draw";
            draws++;
        }else if (Choice==3){
            outcome="win";
            wins++;
        }else if (Choice==4){
            outcome="win";
            wins++;
            cats--;
        }
        return outcome;
    }
    public String scissors(int Choice){
        String outcome=null;
        if (Choice==1){
            outcome="win";
            wins++;
        }else if (Choice==2){
            outcome="lose";
            losses++;
        }else if (Choice==3){
            outcome="draw";
            draws++;
        }else if (Choice==4){
            outcome="win";
            wins++;
            cats--;
        }
        return outcome;
    }
    public void results (){
        System.out.println("wins: "+wins);
        System.out.println("draws: "+ draws);
        System.out.println("losses: "+losses);
    }
    public boolean catUsed(){
        boolean used= false;
        if(cats == 1){
            used =false;
        }else if (cats==0){
            used = true;
        }
        return used;
    }
}
 