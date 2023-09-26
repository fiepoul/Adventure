import java.util.Scanner;

public class UserInterface {

    private Adventure adventure;

    public UserInterface(Adventure adventure) {
        this.adventure = adventure;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the quest for the American Dream! You stand at the threshold. You are almost there..");

        while (true) {
            Room currentRoom = adventure.getCurrentRoom();
            System.out.println("\n" + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
            System.out.print("Where would you like to go? (Type 'look' for a closer look): ");
            input = scanner.nextLine().toLowerCase();

            command(input);
        }

    }

            public void command(String input) {
            Room currentRoom = adventure.getCurrentRoom();

                if (input.equals("look")) {
                    System.out.println("\n" + currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                } else if (input.equals("go north")) {
                    Room northRoom = currentRoom.getExit("north");
                    if (northRoom != null) {
                        adventure.setCurrentRoom(northRoom);
                        System.out.println("You have moved north.");
                    } else {
                        System.out.println("You cannot go north from here.");
                    }
                } else if (input.equals("go south")) {
                    Room southRoom = currentRoom.getExit("south");
                    if (southRoom != null) {
                        adventure.setCurrentRoom(southRoom);
                        System.out.println("You have moved south.");
                    } else {
                        System.out.println("You cannot go south from here.");
                    }
                } else if (input.equals("go east")) {
                    Room eastRoom = currentRoom.getExit("east");
                    if (eastRoom != null) {
                        adventure.setCurrentRoom(eastRoom);
                        System.out.println("You have moved east.");
                    } else {
                        System.out.println("You cannot go east from here.");
                    }
                } else if (input.equals("go west")) {
                    Room westRoom = currentRoom.getExit("west");
                    if (westRoom != null) {
                        adventure.setCurrentRoom(westRoom);
                        System.out.println("You have moved west.");
                    } else {
                        System.out.println("You cannot go west from here.");
                    }
                } else if (input.equals("help")) {
                    printHelp();
                } else if (input.equals("exit")) {
                    exitGame();
                    System.exit(0);
                } else {
                    System.out.println("I don't understand that command.");
                }
            }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("- look: View the current room description.");
        System.out.println("- go north/south/east/west: Move in the specified direction.");
        System.out.println("- help: Seek guidance on your quest.");
        System.out.println("- exit: Farewell and goodbye.");
    }
    private void exitGame() {
        System.out.println("Farewell! Thank you for trying your luck in America.");
        System.exit(0);
    }

}
