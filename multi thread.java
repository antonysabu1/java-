package th;

import java.util.Random;

class Thread01 extends Thread {

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                Random r = new Random();
                int n = r.nextInt(25);  // generates random number between 0–24

                System.out.println("Generated number: " + n);

                if (n % 2 == 0) {
                    System.out.println("Even");
                    EvenThread th02 = new EvenThread(n);
                    th02.start();
                } else {
                    System.out.println("Odd");
                    OddThread th03 = new OddThread(n);
                    th03.start();
                }

                Thread.sleep(1000);  // Pause for 1 second
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}

class EvenThread extends Thread {
    int number;

    EvenThread(int n) {
        this.number = n;
    }

    public void run() {
        int square = number * number;
        System.out.println("Square of " + number + " is: " + square + "\n");
    }
}

class OddThread extends Thread {
    int nu
