/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guesscolorgame;
import java.util.*;
/**
 *
 * @author Janrell Quiaroro
 */

// !GAME 1 = COLOR GUESS GAME
// !GAME 2 = FIRE WATER GRASS GAME

class gameMech{
    
    
    // SETTINGS OF GAME 1 HERE!

    void cgGame(){
        
        for (int j = 1; j <= 5; j++) {
            playCG();
            
            if(j == 4) {
        		gameOver();
        	}
            }
    }
    
    void playCG(){
        int lvlCounter = 1;
        String guess;
        String color = null;
        int i;
        System.out.print("\nWelcome to Color Guess Game\n");
        System.out.println("Level " + lvlCounter);
        lvlCounter++;
        // creating Array for the items
        String []arr = {"Banana","Orange","Apple","Cucumber","Grapes"};
  
        Random random_method = new Random();
        int index = random_method.nextInt(arr.length);
        
        Scanner sc = new Scanner(System.in);

        if(arr[index].equals("Banana")) {
        	color = "Yellow";
        }
        else if(arr[index].equals("Orange")) {
        	color = "Orange";
        }
        else if(arr[index].equals("Apple")) {
        	color = "Red";
        }
        else if(arr[index].equals("Cucumber")) {
        	color = "Green";
        }
        else if(arr[index].equals("Grapes")) {
        	color = "Violet";
        }
        
        
        for(i = 1; i <= 5; i++) {
                System.out.print("What color is the "+arr[index]+"?\n");
        	System.out.print("Answer=> ");
        	guess = sc.nextLine();
        	
        	
                if(guess.equalsIgnoreCase(color)) {
        		victory();

        	}
                
                else {
        		System.out.print(guess+" is not the color of "+arr[index]+"\n");
                        System.out.println("Level " + lvlCounter);
        	}
        	if(i == 4) {
        		gameOver();
        		System.out.print("The color of "+arr[index]+" is "+color+"\n");
                        break;
        	}
        	
        }
}

    
    
    // SETTINGS OF GAME 2 HERE!
    void fwgGame(){
        for (int j = 0; j < 5; j++) {
            playFWG();
            if(j == 4) {
        		gameOver();
        	}
            }
    }
    void playFWG() {
                int lvlCounter = 1;
    		Scanner scans = new Scanner(System.in);
                System.out.print("\nWelcome to Fire,Water,Grass Game!\n");
                System.out.println("Level " + lvlCounter);
                lvlCounter++;
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
                        System.out.println("Level " + lvlCounter);
        		victory();
        	}
        	else {
                        System.out.println("Level " + lvlCounter);
        		gameOver();
        	}
    	}
    boolean youwin(String yourmove, String enemymove) {
            if (yourmove.equalsIgnoreCase("fire")) {
                return enemymove.equalsIgnoreCase("water");
            } else if (yourmove.equalsIgnoreCase("grass")) {
                return enemymove.equalsIgnoreCase("fire");
            } else {
                return enemymove.equalsIgnoreCase("grass");
            }
    
        }
  
    //VICTORY MESSAGE HERE!
        void victory(){
            System.out.print("Congratulations! You are about to proceed to the next level!\n");
            System.exit(0);
        }
        
    //DEFEAT MESSAGE HERE!
        void gameOver(){
            System.out.print("You used your 5 trials.\n");
            System.out.print("You lose! Better Luck Next Time!\n");
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
            //COLOR GUESS GAME
            case "1" :
                game.cgGame();
            break;
            
            case "2":
            //COLOR GUESS GAME
                game.fwgGame();
            break;
        }
            
        }
        
        
    }
    
        
}
