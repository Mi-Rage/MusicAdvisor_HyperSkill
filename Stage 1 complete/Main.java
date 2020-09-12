package advisor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String query = scanner.nextLine();
        while(!query.equals("exit")) {
            switch (query) {
                case ("new"):
                    System.out.println("---NEW RELEASES---");
                    System.out.println("Mountains [Sia, Diplo, Labrinth]\n" +
                            "Runaway [Lil Peep]\n" +
                            "The Greatest Show [Panic! At The Disco]\n" +
                            "All Out Life [Slipknot]");
                    break;
                case ("featured"):
                    System.out.println("---FEATURED---");
                    System.out.println("Mellow Morning\n" +
                            "Wake Up and Smell the Coffee\n" +
                            "Monday Motivation\n" +
                            "Songs to Sing in the Shower");
                    break;
                case ("categories"):
                    System.out.println("---CATEGORIES---");
                    System.out.println("Top Lists\n" +
                            "Pop\n" +
                            "Mood\n" +
                            "Latin");
                    break;
                case ("playlists Mood"):
                    System.out.println("---MOOD PLAYLISTS---");
                    System.out.println("Walk Like A Badass  \n" +
                            "Rage Beats  \n" +
                            "Arab Mood Booster  \n" +
                            "Sunday Stroll");
                    break;

            }
            query = scanner.nextLine();
        }
        System.out.println("---GOODBYE!---");
    }
}
