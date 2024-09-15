import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<Player> playerList = new ArrayList<>();
        //Array med alla menyer, för att lättare kunna lägga till och ta bort
        String[] menuItems = {
                "1. Add score",
                "2. Show all scores",
                "3. Show highest score",
                "4. Show average score",
                "5. Clear list",
                "6. Exit"};
        while (running) {
            int playerCount = playerList.size();
            printMenu(playerCount, menuItems);
            String userInput = scanner.nextLine();
            if (checkInput(userInput, menuItems)) {
                switch (userInput) {
                    case "1": {
                        createPlayer(playerList);
                        break;
                    }
                    case "2": {
                        printList(playerList);
                        break;
                    }
                    case "3": {
                        printHighScore(playerList);
                        break;
                    }
                    case "4": {
                        printAverageScore(playerList);
                        break;
                    }
                    case "5": {
                        clearScoreList(playerList);
                        break;
                    }
                    case "6": {
                        System.out.println("Closing...");
                        running = false;

                    }
                }
            } else {
                System.out.println("Incorrect input, try again...");
            }

        }
    }

    //TODO adjust to new Player class
    private static void printList(ArrayList<Integer> scoresList) {
        if (!scoresList.isEmpty()) {
            System.out.println("All scores:");
            for (int score : scoresList) {
                System.out.println(score);
            }
        } else {
            System.out.println("Score list is empty...");
        }
    }

    //TODO adjust to new Player class
    private static void clearScoreList(ArrayList<Integer> scoresList) {
        scoresList.clear();
        System.out.println("List cleared...");
    }

    //TODO adjust to new Player class
    private static void printAverageScore(ArrayList<Integer> scoresList) {
        if (!scoresList.isEmpty()) {
            int totalScore = 0;
            for (int score : scoresList) {
                totalScore = totalScore + score;
            }
            double averageScore = (double) totalScore / scoresList.size();
            System.out.println("The average score out of a total of " + scoresList.size() + " scores is: " + averageScore);
        } else {
            System.out.println("Score list is empty...");
        }
    }

    //TODO adjust to new Player class
    private static void printHighScore(ArrayList<Integer> scoresList) {
        int highScore = 0;
        if (!scoresList.isEmpty()) {
            for (int score : scoresList) {
                if (score > highScore) {
                    highScore = score;
                }
            }
            System.out.println("The highest score is: " + highScore);
        } else {
            System.out.println("No scores in list...");
        }
    }


    private static Player createPlayer(ArrayList<Player> playerList) {
        Scanner scanner = new Scanner(System.in);
        Player newPlayer = new Player();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter new player name:");
                newPlayer.setName(scanner.nextLine());
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Felaktigt namn, försök igen!");
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter new player's score: ");
                newPlayer.setScore(scanner.nextInt());
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Felaktig poäng, försök igen!");
            }
        }
        scanner.nextLine();
        return newPlayer;
    }

    private static void printMenu(int scoreCount, String[] menuItems) {
        System.out.println("\n*** Total number of scores in list: " + scoreCount + " ***\n");
        for (String item : menuItems) {
            System.out.println(item);
        }
        System.out.println("Enter:");
    }

    //Loopar igenom meny-arrayen och kollar om user input är ett val som finns
    private static boolean checkInput(String input, String[] menuItems) {
        boolean checkBoolean = false;
        for (int i = 1; i < menuItems.length + 1; i++) {
            if (input.equals(String.valueOf(i))) {
                checkBoolean = true;
                break;
            }
        }
        return checkBoolean;
    }
}