import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<Player> players = new ArrayList<>();
        //Array med alla menyer, för att lättare kunna lägga till och ta bort
        String[] menuItems = {
                "1. Add player",
                "2. Show all players",
                "3. Show highest score",
                "4. Show average score",
                "5. Delete all players",
                "6. Exit"};
        while (running) {
            int playerCount = players.size();
            printMenu(playerCount, menuItems);
            String userInput = scanner.nextLine();
            if (checkInput(userInput, menuItems)) {
                switch (userInput) {
                    case "1": {
                        addPlayer(players);
                        break;
                    }
                    case "2": {
                       printList(players);
                        break;
                    }
                    case "3": {
                       printHighScore(players);
                        break;
                    }
                    case "4": {
                       printAverageScore(players);
                        break;
                    }
                    case "5": {
                       deleteAllPlayers(players);
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

    
    private static void printList(ArrayList<Player> players) {
        if (!players.isEmpty()) {
            System.out.println("All players:");
            for (Player player : players) {
                System.out.println(player);
            }
        } else {
            System.out.println("List of players is empty...");
        }
    }

    private static void deleteAllPlayers(ArrayList<Player> players) {
        players.clear();
        System.out.println("All players deleted...");
    }

   
    private static void printAverageScore(ArrayList<Player> players) {
        if (!players.isEmpty()) {
            int totalScore = 0;
            for (Player player : players) {
                totalScore += player.getScore();
            }
            double averageScore = (double) totalScore / players.size();
            System.out.println("The average score out of a total of " + players.size() + " players is: " + averageScore);
        } else {
            System.out.println("List of players is empty...");
        }
    }

    
    private static void printHighScore(ArrayList<Player> players) {
        int highScore = 0;
        String recordPlayer = "";
        if (!players.isEmpty()) {
            for (Player player : players) {
                if (player.getScore() > highScore) {
                    highScore = player.getScore();
                    recordPlayer = player.getName();
                }
            }
            System.out.println("The highest score is: " + highScore + " and is held by " +recordPlayer);
        } else {
            System.out.println("No scores in list...");
        }
    }


    private static void addPlayer(ArrayList<Player> players) {
        Scanner scanner = new Scanner(System.in);
        Player newPlayer = new Player();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter new player name:");
                newPlayer.setName(scanner.nextLine());
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input of name, try again!");
                scanner.nextLine();
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter new player's score: ");
                newPlayer.setScore(scanner.nextInt());
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input of score, try again!");
                scanner.nextLine();
            }
        }
        players.add(newPlayer);
        scanner.nextLine();

    }

    private static void printMenu(int scoreCount, String[] menuItems) {
        System.out.println("\n*** Total number of players: " + scoreCount + " ***\n");
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

