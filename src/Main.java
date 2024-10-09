import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen! Vad vill du döpa din Tamagochi till?");
        String name = scanner.nextLine();
        Tamagochi tamagochi = new Tamagochi(name);


        boolean gameRunning = true;
        while (gameRunning && tamagochi.isAlive()) {
            System.out.println("\nVad vill du göra med " + tamagochi.name + "?");
            System.out.println("1. Teach " + tamagochi.name + " a new word");
            System.out.println("2. Talk to " + tamagochi.name );
            System.out.println("3. Feed " + tamagochi.name);
            System.out.println("4. Do nothing/Let time pass");
            System.out.println("5. Visa status");
            System.out.println("6. Avsluta");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Vilket ord vill du lära" + tamagochi.name + "?");
                    String word = scanner.nextLine();
                    tamagochi.teach(word);
                    break;
                case 2:
                    tamagochi.speak();
                    break;
                case 3:
                    tamagochi.feed();
                    break;
                case 4:
                    System.out.println("You did nothing");
                    tamagochi.tick();
                    break;
                case 5:
                    tamagochi.printStats();
                    break;
                case 6:
                    gameRunning = false;
                    System.out.println("Spelet avslutas");
                    break;

                default:
                    System.out.println("Ogiltig val, försök igen");
            }
        }

        scanner.close();
    }
}