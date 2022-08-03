package pkgfinal;
import java.util.Random;
import java.util.Scanner;

public class FireWaterGrass extends Setting {
  public static void playFWG(int j, int n, int g) {
	
	/* CHECK IF TIE, THEN IF TIE, PREVENT TO ADD 20 TO TOTAL_SCORE */
    if (g == 0) {
      n -= 20;
    }
    
    @SuppressWarnings("resource")
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
      tie(j, total_score, 1);
    } else if (youwin(yourmove, enemymove)) {
      System.out.println("=========================================");
      System.out.print("Good! You're about to proceed to the next level!\n");
    } else {
      n += 20;
      gameOver(n);
      doThis(1);
    }

  }
  static boolean youwin(String yourmove, String enemymove) {
    if (yourmove.equalsIgnoreCase("water")) {
      return enemymove.equalsIgnoreCase("fire");
    } else if (yourmove.equalsIgnoreCase("grass")) {
      return enemymove.equalsIgnoreCase("water");
    } else {
      return enemymove.equalsIgnoreCase("grass");
    }

  }
  static void tie(int j, int o, int p) {
    System.out.println("=========================================");
    System.out.print("Its a tie! Restarting the level...\n");
    o -= 20;
    System.out.print("Total Score: " + o + "\n");
    System.out.println("=========================================");
    playFWG(j, o, p);
  }
  public static void main(String[] args) {
	fwg(); // WELCOME
	
	/* LOOP TIL 5 (MAX LEVEL) */
    for (int x = 1; x <= 5; x++) {
    	
      /* GET TOTAL SCORE AND LEVEL FROM SETTING.JAVA */ 
      System.out.println("=========================================");
      System.out.println("Total Score: " + total_score);
      System.out.println("Level " + x);
      System.out.println("=========================================");
      total_score += 20;
      
      /* EXECUTE */
      playFWG(x, total_score, 0);
      
      if (x == 5) {
    	/* 5 LEVELS MAX */
        victory(total_score);
      }
      
      if (verifier == 1) {
        total_score -= 20;
        gameOver(total_score);
      }
    }
  }
}