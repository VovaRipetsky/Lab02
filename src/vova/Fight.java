package vova;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fight implements Runnable {

    private Thread t;
    private BattleDroid droidOne;
    private BattleDroid droidTwo;
    private BattleDroid action;
    private int choice;

    public Fight(String firstDroidName, String secondDroidName) {

        this.droidOne = new BattleDroid(firstDroidName);
        this.droidTwo = new BattleDroid(secondDroidName);
        this.action = new BattleDroid();
    }


    public void switchMode(BattleDroid droidOne, BattleDroid droidTwo){
        switch (choice) {

            case 1:
                this.action.laserAttack(droidOne, droidTwo);
                break;
            case 2:
                this.action.Repair(droidOne);
                break;
            case 3:
                this.action.Charging(droidOne);
                break;
            case 4:
                this.action.Strike((int) (Math.random() * 10), droidTwo);
                break;
            default: run();

        }
    }

    public void run() {

        try {

            boolean isUnderControl = false;
            boolean Multiplayer = false;
            String s;

            System.out.println("Type 'Control' - if you want to control the droid.");
            System.out.println("Type 'Multiplayer' -  for two players.");
            System.out.println("Otherwise, type any letter for auto fight.");

            Scanner scanText = new Scanner(System.in);
            s = scanText.nextLine();

            System.out.println("Fight is started ");
            if(s.equalsIgnoreCase("Control")){
                isUnderControl = true;
            }

            if(s.equalsIgnoreCase("Multiplayer")){
                isUnderControl = true;
                Multiplayer = true;
            }


            System.out.println("Current HP of: " + droidOne.getName() + " " + droidOne.getHpLevel());
            System.out.println("Current HP of: " + droidTwo.getName() + " " + droidTwo.getHpLevel());

            while (droidOne.getHpLevel() > 0 && droidTwo.getHpLevel() > 0) {
               // System.out.println();

                if (isUnderControl == true) {
                    System.out.println();
                    System.out.println(droidOne.getName() + " turn ");
                    System.out.println("Enter '1' for Laser Shot (Cost: 50 MP).     Enter '2' for Repair (Cost: 30 MP).      Enter '3' for Charging MP.      Enter '4' for Attack.");
                    Scanner scanInt = new Scanner(System.in);
                    try {
                        choice = scanInt.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Exception thrown  :" + e);
                    }
                    switchMode(droidOne, droidTwo);


                if(Multiplayer == true) {
                    System.out.println();
                    System.out.println(droidTwo.getName() + " turn ");
                    System.out.println("Enter '1' for Laser Shot (Cost: 50 MP).     Enter '2' for Repair (Cost: 30 MP).      Enter '3' for Charging MP.      Enter '4' for Attack.");
                    scanInt = new Scanner(System.in);
                    try {
                        choice = scanInt.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Exception thrown  :" + e);
                    }
                    switchMode(droidTwo, droidOne);

                    }
                }


                    if (Multiplayer == false) {
                        droidTwo.Strike((int) (Math.random() * 10), droidOne);
                    }

                    if (isUnderControl == false) {
                        droidOne.Strike((int) (Math.random() * 10), droidTwo);
                    }
                    Thread.sleep(500);


            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        if (droidOne.getHpLevel() <= 0 && droidTwo.getHpLevel() <= 0) {
            System.out.println("Everyone is Dead! Draw.");
        }

        else if (droidOne.getHpLevel() <= 0) {
            System.out.println("Thread exiting " + droidOne.getName() + " is Dead");
            System.out.println(droidTwo.getName() + " Won!");
        }
        else if (droidTwo.getHpLevel() <= 0) {
            System.out.println("Thread exiting " + droidTwo.getName() + " is Dead");
            System.out.println(droidOne.getName() + " Won!");
        }
    }

    public void start() {
        System.out.println("Starting");

        t = new Thread(this);
        t.start();

    }
}