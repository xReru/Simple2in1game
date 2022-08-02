/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesscolorgame;
import static guesscolorgame.GuessColorgame.play;
import java.util.*;
/**
 *
 * @author Janrell Quiaroro
 */


class gameMech{
    void colorGuess(){
        System.out.print("\nWelcome to Color Guess Game\n");
        // creating ArrayList
        ArrayList<String> al = new ArrayList<String>();
  
        // adding object in ArrayList
        al.add("Banana");
        al.add("Orange");
        al.add("Apple");
        al.add("Cucumber");
        al.add("Grapes");
  
        Collections.shuffle(al);
  
        Random random_method = new Random();
        int index = random_method.nextInt(al.size());
        int i;
        String guess;
        String color = null;
        
        Scanner sc = new Scanner(System.in);
        
        String item = al.get(index);
        if(item == "Banana") {
        	color = "Yellow";
        }
        else if(item == "Orange") {
        	color = "Orange";
        }
        else if(item == "Apple") {
        	color = "Red";
        }
        else if(item == "Cucumber") {
        	color = "Green";
        }
        else if(item == "Grapes") {
        	color = "Violet";
        }
        
        System.out.print("What color is the "+item+"?\nYou have 5 tries to proceed on the next level.\n");
        for(i = 0; i < 5; i++) {
        	System.out.print("Answer=> ");
        	guess = sc.nextLine();
        	
        	if(guess.equalsIgnoreCase(color)) {
        		System.out.print("Congratulations! You are about to proceed to the next level!\n");
        		break;
        	} else {
        		System.out.print(guess+" is not the color of "+item+"\n");
        		System.out.print("DEBUG: TRIES LEFT: "+i+"\n");
        	}
        	if(i == 4) {
        		System.out.print("You used your 5 trials.\n");
        		System.out.print("The color of "+item+" is "+color+"\n");
        	}
        	
        }
    }
    
    void fwgGame(){
        for (int j = 0; j < 5; j++) {
            play();
            if(j == 4) {
        		System.out.print("You used your 5 trials.\n");
        		System.out.print("You lose! Better Luck Next Time!\n");
        	}
            }
    }

}
public class GuessColorgame extends gameMech {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gameMech game = new gameMech();
        boolean isRunning = true;
        
        while (isRunning){
        System.out.println("\nWelcome!");
        
        System.out.println("-----------------------");
        System.out.println("1. Color Guess Game ");
        System.out.println("2. Fire, Water, Grass Game");
        System.out.print("Please choose a number!(or type exit) :");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
   
        //Terminate the program
        if (choice.equalsIgnoreCase("exit")){
            System.out.println("Program Terminated Succesfully");
            isRunning = false;
        }
        
        
        switch(choice){
            case "1" :
                game.colorGuess();
            break;
            
            case "2":
                game.fwgGame();
            break;
        }
            
        }
        
        
    }
    //FIRE WATER GRASS GAME
    static void play() {
    		Scanner scans = new Scanner(System.in);
                System.out.print("\nWelcome to Fire,Water,Grass Game!\n");
    		System.out.print("Choose (fire, water, grass): ");
        	String yourmove = scans.nextLine();
        	
        	Random random = new Random();
        	int randomnum = random.nextInt(3);
        	
        	String enemymove;
        	if(randomnum == 0) {
        		enemymove = "fire";
        	}
        	else if(randomnum == 1) {
        		enemymove = "water";
        	}
        	else {
        		enemymove = "grass";
        	}
        	System.out.print("Your Enemy chose: "+enemymove+"!\n");
        	
        	if(yourmove.equals(enemymove)) {
        		System.out.print("TIE!\n");
        	}
        	else if(youwin(yourmove, enemymove)) {
        		System.out.print("You win! you are about to proceed to the next level!\n");
        	}
        	else {
        		System.out.print("You lose!\n");
        	}
    	}
    	static boolean youwin(String yourmove, String enemymove) {
            if (yourmove.equalsIgnoreCase("fire")) {
                return enemymove.equalsIgnoreCase("water");
            } else if (yourmove.equalsIgnoreCase("grass")) {
                return enemymove.equalsIgnoreCase("fire");
            } else {
                return enemymove.equalsIgnoreCase("grass");
            }
    
        }
}
