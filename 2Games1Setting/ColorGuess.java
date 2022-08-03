package pkgfinal;
import java.util.Random;
import java.util.Scanner;

public class ColorGuess extends Setting {
  public static void playCG(int c) {

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

    @SuppressWarnings("resource")
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
  public static void main(String[] args) {
	cg(); //WELCOME
	
	/* LOOP TIL 5 (MAX LEVEL) */
    for (int x = 1; x <= 5; x++) {
    	
      /* GET TOTAL SCORE AND LEVEL FROM SETTING.JAVA */ 
      System.out.println("=========================================");
      System.out.println("Total Score: " + total_score);
      System.out.println("Level " + x);
      System.out.println("=========================================");
      total_score += 20;
      
      /* EXECUTE */
      playCG(total_score);
      
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