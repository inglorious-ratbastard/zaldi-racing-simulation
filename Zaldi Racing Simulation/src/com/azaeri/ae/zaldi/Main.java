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
   
    System.out.println("How many People will be Betting?" );
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
                betHorse[bet - 1] += kard.nextDouble();
            }
        }
         System.out.println();
        for (int j = 1; j <= horses; j++) {
            System.out.println("Bet for Horse #" + j + ": $ " + betHorse[j - 1]);
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
        
        int racenum = 1;
        int[] numbers = new int[horses];
        for (int i = 0; i < horses; i++) {
          numbers[i] = 1 + (int) (Math.random() * 6);
        }
        for (int i = 0; i < horses; i++) {
            if (numbers[i] >= 1 && numbers[i] <= 3) {
                move[i]++;
            } else if (numbers[i] == 4 && numbers[i] == 5) {
                move[i] = move[i] + 3;
            } else if (numbers[i] == 6) {
                move[i] = move[i] + 5;
            } 
        } racenum = racenum+=1;

        System.out.println("\n" + "Race #" + racenum);
        for (int i = 1; i <= horses; i++){   
           System.out.println("Horse " + i +" position:" + move[i-1]);
        } 

        /*  visual display of horses current track 
            position for possible use in JPanel/Swing 
        */
        // for (int i = 1; i <= horses; i++) {


          
        //     for (int j = 0; j < move[i - 1]; j++) {
        //         System.out.print("--");
        //     }
        //     System.out.println(i + "H" + move[i - 1]);

        // }

          System.out.println("\n\n");
    } while (move[horses - 1] < tracks.length );
      System.out.println("----------------------" + "\n\tWinners Circle" + "\n----------------------");
    for (int i = 1; i <= horses; i++) {
        if (move[i - 1] > tracks.length) {
            System.out.println("HORSE " + i + " finished the track! One who bets for HORSE " + i + " won P" + betHorse[i - 1] * 2);
        }
    }

  }
}