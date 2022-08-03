/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2in1game.pkgfinal;

import java.util.Scanner;

/**
 *
 * @author Janrell Quiaroro | syempre ako, Lance Kenji Parce 
 */
public class Setting extends Game {
    public static void main(String[] args){
        Game game = new Game();

    boolean isRunning = true;

    while (isRunning) {
      System.out.println("\nWelcome!");

      System.out.println("-----------------------");
      System.out.println("1. Color Guess Game ");
      System.out.println("2. Fire, Water, Grass Game");
      System.out.print("Please choose a number!(or type exit) :");
      Scanner scan = new Scanner(System.in);
      String choice = scan.nextLine();

      //Terminate the program
      if (choice.equalsIgnoreCase("exit")) {
        System.out.println("Program Terminated Succesfully");
        isRunning = false;
      }

      switch (choice) {
        //COLOR GUESS GAME
      case "1":
        System.out.print("\nWelcome to Color Guess Game\n");
        game.playGame(1);
        break;

      case "2":
        //COLOR GUESS GAME
        System.out.print("\nWelcome to Fire,Water,Grass Game!\n");
        game.playGame(2);
        break;
      }

    }
    
    }
}
