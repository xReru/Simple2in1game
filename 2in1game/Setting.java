/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2in1game.pkgfinal;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Janrell Quiaroro | syempre ako, Lance Kenji Parce
 */
public class Game extends Mechanics{
      // SETTINGS OF GAMES HERE!

  void playGame(int k) {
    int total_score = 0;
    for (int j = 1; j <= 5; j++) {
      System.out.println("Total Score: " + total_score);
      System.out.println("Level " + j);
      total_score += 20;
      if (k == 1) {
        playCG(total_score);
      } else if (k == 2) {
        playFWG(j, total_score, 0);
      }
      if (j == 5) {
        victory(total_score);
      }
    }
    if (verifier == 1) {
      total_score -= 20;
      gameOver(total_score);
    }

  }

  static int verifier = 0;

  public static int doThis(int trigger) {
    int x = trigger;
    verifier = x;
    return x;
  }

  void playCG(int c) {

    String guess;
    String color = null;

    // creating Array for the items
    String[] arr = {
      "Banana",
      "Orange",
      "Apple",
      "Cucumber",
      "Grapes"
    };

    Random random_method = new Random();
    int index = random_method.nextInt(arr.length);

    Scanner sc = new Scanner(System.in);

    if (arr[index].equals("Banana")) {
      color = "Yellow";
    } else if (arr[index].equals("Orange")) {
      color = "Orange";
    } else if (arr[index].equals("Apple")) {
      color = "Red";
    } else if (arr[index].equals("Cucumber")) {
      color = "Green";
    } else if (arr[index].equals("Grapes")) {
      color = "Violet";
    }

    System.out.print("What color is the " + arr[index] + "?\n");
    System.out.print("Answer=> ");
    guess = sc.nextLine();

    if (guess.equalsIgnoreCase(color)) {
      System.out.print("Good! You're about to proceed to the next level!\n");

    } else {
      System.out.print(guess + " is not the color of " + arr[index] + "\n");
      gameOver(c);
      doThis(1);

    }

  }

  void playFWG(int j, int n, int g) {
    if (g == 0) {
      n -= 20;
    }
    Scanner scans = new Scanner(System.in);
    System.out.print("Choose (fire, water, grass): ");
    String yourmove = scans.nextLine();

    Random random = new Random();
    int randomnum = random.nextInt(2);

    String enemymove;
    if (randomnum == 0) {
      enemymove = "fire";
    } else if (randomnum == 1) {
      enemymove = "water";
    } else {
      enemymove = "grass";
    }

    System.out.print("Your Enemy chose: " + enemymove + "!\n");

    if (yourmove.equalsIgnoreCase(enemymove)) {
      tie(j, n, 1);
    } else if (youwin(yourmove, enemymove)) {
      System.out.print("Good! You're about to proceed to the next level!\n");
    } else {
      n += 20;
      gameOver(n);
      doThis(1);
    }

  }
  boolean youwin(String yourmove, String enemymove) {
    if (yourmove.equalsIgnoreCase("water")) {
      return enemymove.equalsIgnoreCase("fire");
    } else if (yourmove.equalsIgnoreCase("grass")) {
      return enemymove.equalsIgnoreCase("water");
    } else {
      return enemymove.equalsIgnoreCase("grass");
    }

  }
  
  //TIE MESSAGE HERE
  void tie(int j, int o, int p) {
    System.out.print("Its a tie! Restarting the level...\n");
    System.out.println("Total Score: " + o + "\n");
    playFWG(j, o, p);

  }
}
