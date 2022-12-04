package machine;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.money = 550;
        coffeeMachine.water = 400;
        coffeeMachine.milk = 540;
        coffeeMachine.beans = 120;
        coffeeMachine.cups = 9;
        while (true) {
            coffeeMachine.askForService();
        }

    }


}


class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);

    int milk;
    int water;
    int beans;

    int cups;

    int money = 0;



    public void showMenu() {
        //The coffee machine has:
        //200 ml of water
        //440 ml of milk
        //108 g of coffee beans
        //8 disposable cups
        //$556 of money
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void askForService() {
        String chooser;
        System.out.println("\nWrite action(buy, fill, take, remaining, exit):");
        chooser = scanner.nextLine();
        switch (chooser) {
            case "buy":
                String input;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                input = scanner.next();
                if (input.equals("back")) {
                    break;
                } else {
                    switch (Integer.parseInt(input)) {
                        case 1:                         //I have enough resources, making you a coffee!
                            buyEspresso();
                            break;
                        case 2:
                           buyLatte();
                            break;
                        case 3:
                           buyCappuccino();
                            break;
                        default:
                            System.out.println("Wrong input");
                    }
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                water += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many ml of milk you want to add: ");
                milk += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add:  ");
                beans += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many disposable cups you want to add:");
                cups += Integer.parseInt(scanner.nextLine());
                break;
            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                break;
            case "remaining":
                showMenu();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Wrong input");
        }

    }

    public void buyEspresso() {
        if (water >= 250 && beans >= 16 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            beans -= 16;
            cups -=1;
            money += 4;
        } else if (water < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (beans < 16) {
            System.out.println("Sorry, not enough beans!");
        } else
            System.out.println("Sorry, not enough cups!");
    }

    public void buyLatte() {
        if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups -=1;
            money += 7;
        } else if (water < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 20) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }

    public void buyCappuccino() {
        if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups -=1;
            money += 6;
        } else if (water < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < 12) {
            System.out.println("Sorry, not enough beans!");
        } else {
            System.out.println("Sorry, not enough cups!");
        }
    }
}
