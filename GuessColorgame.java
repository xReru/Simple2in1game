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
        System.out.print("\nWelcome to Color Guess Game\n");
        
        for (int j = 1; j <= 5; j++) {
            System.out.println("Level " + j);
            playCG();
            
            if(j == 5) {
        		gameOver();
        	}
            }
        
    }

    /*int test = doThis(1);
    
    public static int doThis(int l) {
     l = 1;
     return l;
     }*/


    void playCG(){
        
        String guess;
        String color = null;
        
        
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
        
        
        
                System.out.print("What color is the "+arr[index]+"?\n");
        	System.out.print("Answer=> ");
        	guess = sc.nextLine();
        	
        	
                if(guess.equalsIgnoreCase(color)) {
        		victory();

        	}
                
                else {
        		System.out.print(guess+" is not the color of "+arr[index]+"\n");
                        lose();
                        
        	}
                
        	
        
}

    
    
    // SETTINGS OF GAME 2 HERE!
    void fwgGame(){
        for (int j = 1; j <= 5; j++) {
            System.out.print("\nWelcome to Fire,Water,Grass Game!\n");
            System.out.println("Level " + j);
            playFWG();
            if(j == 5) {
        		gameOver();
        	}
        }
            
    }
    void playFWG() {
                
    		Scanner scans = new Scanner(System.in);
                
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
        	
        	if(yourmove.equalsIgnoreCase(enemymove)) {
        		System.out.print("Its a tie!\n");
        	}
        	else if(youwin(yourmove, enemymove)) {
        		victory();
        	}
        	else {
        		lose();
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
            System.out.print("Congratulations! You won the game!\n");
            
        }
        
    //DEFEAT MESSAGE HERE!
        void lose(){
            System.out.println("You lose!\n");
        }    
        
        
    //GAMEOVER MESSAGE HERE!
        void gameOver(){
            System.out.print("Better Luck Next Time!\n");
            System.exit(0);
            
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
