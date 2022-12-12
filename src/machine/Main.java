package machine;

import java.io.IOException;
import java.util.Scanner;

import static machine.Control.readCoffeeMachine;
import static machine.Control.writeCoffeeMachine;
import static machine.Control.tryLogin;

public class Main {

    static CoffeeCup espresso = new CoffeeCup(250, 0, 16, 1, 4, "Espresso");
    static CoffeeCup latte = new CoffeeCup(350, 75, 20, 1, 7, "Latte");
    static CoffeeCup cappuccino = new CoffeeCup(200, 100, 12, 1, 6, "Cappuccino");

    static Scanner scanner = new Scanner(System.in);

    static boolean adminAccess = false;

    static CoffeeMachine coffeeMachine;


    public static void main(String[] args) throws IOException {
        coffeeMachine = readCoffeeMachine();
        while (true) {
            processUserMenu();
            showAdminMenu();
        }

    }


    public static void showState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(coffeeMachine.water + " ml of water");
        System.out.println(coffeeMachine.milk + " ml of milk");
        System.out.println(coffeeMachine.beans + " g of coffee beans");
        System.out.println(coffeeMachine.cups + " disposable cups");
        System.out.println("$" + coffeeMachine.money + " of money");
    }

    public static void buyMenu() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine();
        if (input.equals("back")) {
            return;
        }
        switch (Integer.parseInt(input)) {
            case 1:
                coffeeMachine.buy(espresso);
                break;
            case 2:
                coffeeMachine.buy(latte);
                break;
            case 3:
                coffeeMachine.buy(cappuccino);
                break;
            default:
                System.out.println("Wrong input");

        }
    }

    public static void processUserMenu() throws IOException {
        while (!adminAccess) {
            System.out.println("Write action (buy, admin, exit):");
            switch (scanner.nextLine()) {
                case "buy":
                    buyMenu();
                    break;
                case "admin":
                    adminAccess = tryLogin();
                    break;
                case "exit":
                    Control.writeCoffeeMachine();
                    System.exit(1);
                default:
                    System.out.println("Wrong input!");

            }

        }

    }

    public static void showAdminMenu() throws IOException {
        System.out.println("\nWrite action(buy, fill, take, remaining, exit):");
        switch (scanner.nextLine()) {
            case "buy":
                buyMenu();
                break;

            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                int water = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many ml of milk you want to add: ");
                int milk = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add:  ");
                int beans = Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many disposable cups you want to add:");
                int cups = Integer.parseInt(scanner.nextLine());
                coffeeMachine.fill(water, milk, beans, cups);
                break;

            case "take":
                System.out.println("I gave you $" + coffeeMachine.money);
                coffeeMachine.money = 0;
                break;

            case "remaining":
                showState();
                break;

            case "exit":
                writeCoffeeMachine();
                System.exit(0);

            default:
                System.out.println("Wrong input");
        }

    }


}


