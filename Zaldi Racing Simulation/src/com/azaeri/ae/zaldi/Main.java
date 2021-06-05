package com.azaeri.ae.zaldi;

import java.util.Scanner;

class Main {
  public static void main(String[] args) throws InterruptedException {
   
    Scanner kard = new Scanner(System.in);

    int[] tracks = new int[70];
    int bet;
    
    System.out.println("\n" + "==========================" + "\n\t|| Zaldi Downs ||" + "\n\t|| Race Track  ||" + "\n" + "==========================" + "\nTry your luck at the Track" + "\n" + "\nChoose how many Horses you would like to Run.." + "\n(Only 5-14 Horses are allowed to Race this Track)");

    int horses;
    do {
        horses = kard.nextInt();
    } while (horses < 5 || horses > 14);
  
    int[] move = new int[horses];
    double[] betHorse = new double[horses];
   
    System.out.println("\nHow many People will be Betting?" );
    
    int number = kard.nextInt(); 
    for (int i = 1; i <= number; i++) {
        System.out.println("\nPlace Your Bets!" + "\n----------------");
        do {
            for (int j = 1; j <= horses; j++) {
                System.out.println("[" + j + "]" + " for Horse #" + j);
            }
            System.out.println("----------------" + "\nBettor Number " + i + ":\nEnter the number of Horse:");
            bet = kard.nextInt();
        } while (bet < 1 || bet > horses);
        for (int p = 1; p <= horses; p++) {
            if (bet == p) {
                System.out.println("Enter the amount of your bet:");
                betHorse[bet - 1] += kard.nextFloat();
                if(betHorse[bet - 1] < 1){
                  System.out.println("\nBets must be greater than $1.00\n" + "Please Enter Your Wager:");
                  betHorse[bet - 1] = kard.nextFloat(); 
                }
            }
        }
         System.out.println();
        for (int j = 1; j <= horses; j++) {
          System.out.println("Bet for Horse #" + j + ": $" + String.format("%.2f" , betHorse[j-1]));
        }
    }
    kard.close();

    System.out.println("\nAll Bets Have Been Settled.." + "\nRace begins in:");
    int strtPstl = 5;
    for (int i = 1; i <= strtPstl; strtPstl--) {
        System.out.println(strtPstl);
        Thread.sleep(1000);
    }
    do {
        Thread.sleep(1000);

        for (int i = 0; i < horses; i++) {
            int die = 1 + (int)(Math.random()*6);
            if (die >= 1 && die <= 3) {
               move[i]++;
            } else if (die == 4 || die == 5) {
               move[i] = move[i] + 3;
            } else { 
               move[i] = move[i] + 5;
            }
        }  
         int racenum = 1606;
        for (int i = 0; i < racenum; i++){
            i = racenum++;
        }
         System.out.println("\n" + "Race #" + racenum);
         for (int i = 1; i <= horses; i++) {   
           System.out.println("Horse " + i +" position:" + move[i-1]); 
        } 

      System.out.println("\n\n");
    } while (move[horses - 1] < tracks.length );
      System.out.println("----------------------" + "\n\tWinners Circle" + "\n----------------------");
      for (int i = 1; i <= horses; i++) {
        if (move[i - 1] > tracks.length) {
            System.out.println("Horse #" + i + " finished Place " + move[i-1] + " | Bet Payout $" + String.format("%.2f", betHorse[i - 1] * 2)); 
        }
     }

  }
}