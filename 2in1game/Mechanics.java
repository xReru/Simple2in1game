/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2in1game.pkgfinal;

/**
 *
 * @author Janrell Quiaroro
 */
public class Mechanics{
    //VICTORY MESSAGE HERE!
  void victory(int a) {
    System.out.print("Congratulations! You won the game!\n");
    System.out.println("Total Score: " + a + "\n");
    System.exit(0);
  }

  //GAMEOVER MESSAGE HERE!
  void gameOver(int b) {
    b -= 20;
    System.out.print("Better Luck Next Time!\n");
    System.out.println("Total Score: " + b + "\n");
    System.exit(0);

  }

}
