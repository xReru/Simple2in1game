package pkgfinal;
public class Setting {
	
  //TOTAL SCORE
  static int total_score = 0;
  
  /* [START] VERIFIER FOR GAME OVER [START] */
  static int verifier = 0;
  public static int doThis(int trigger) {
    int x = trigger;
    verifier = x;
    return x;
  }
  /* [END] VERIFIER FOR GAME OVER [END] */
  
  /* [START] MESSAGES [START] */
  
  //WELCOME MESSAGE FIRE WATER GRASS HERE!
  static void fwg() {
	  System.out.println("=========================================");
	  System.out.println("Welcome to Fire,Water,Grass Game!");
  }
  
  //WELCOME MESSAGE COLOR GUESS HERE!
  static void cg() {
	  System.out.println("=========================================");
	  System.out.println("Welcome to Color Guess Game");
  }
  
  //VICTORY MESSAGE HERE!
  static void victory(int a) {
    System.out.println("=========================================");
    System.out.print("Congratulations! You won the game!\n");
    System.out.print("Total Score: " + a + "\n");
    System.out.println("=========================================");
    System.exit(0);
  }

  //GAMEOVER MESSAGE HERE!
  static void gameOver(int b) {
    b -= 20;
    System.out.println("=========================================");
    System.out.print("Better Luck Next Time!\n");
    System.out.print("Total Score: " + b + "\n");
    System.out.println("=========================================");
    System.exit(0);
  }
  
  /* [END] MESSAGES [END] */

}