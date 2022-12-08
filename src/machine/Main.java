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

    int milk;
    int water;
    int beans;

    int cups;

    int money = 0;


    public void showMenu() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void askForService() {
        System.out.println("\nWrite action(buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "buy":
                String input;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                input = scanner.nextLine();
                if (input.equals("back")) {
                    break;
                }
                switch (Integer.parseInt(input)) {
                    case 1:
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
        boolean check = false;
        StringBuilder notEnoughMessage = new StringBuilder();
        if (water < 250) {
            notEnoughMessage.append("water");
            check = true;
        }
        if (beans < 16) {
            if (check) {
                notEnoughMessage.append(", ");
            }
            notEnoughMessage.append("beans");
        }
        if (cups < 1) {
            if (check) {
                notEnoughMessage.append("& ");
            }
            notEnoughMessage.append("cups.");
        }

        if (notEnoughMessage.isEmpty()) {
            this.water -= 250;
            this.beans -= 16;
            this.cups -= 1;
            this.money += 4;
            System.out.println("Espresso bought!");
        } else {
            System.out.println("Missing: " + notEnoughMessage);
        }

    }

    public void buyLatte() {
        boolean check = false;
        StringBuilder notEnoughMessage = new StringBuilder();
        if (water < 350) {
            notEnoughMessage.append("water");
            check = true;
        }
        if (milk < 75) {
            if (check) {
                notEnoughMessage.append(", ");
            }
            notEnoughMessage.append("milk");
        }
        if (beans < 20) {
            if (check) {
                notEnoughMessage.append(", ");
            }
            notEnoughMessage.append("beans");
        }
        if (cups < 1) {
            if (check) {
                notEnoughMessage.append("& ");
            }
            notEnoughMessage.append("cups.");
        }

        if (notEnoughMessage.isEmpty()) {
            this.water -= 350;
            this.milk -= 75;
            this.beans -= 20;
            this.cups -= 1;
            this.money += 7;
            System.out.println("Latte bought!");

        } else {
            System.out.println("Missing: " + notEnoughMessage);
        }
    }

    public void buyCappuccino() {
        boolean check = false;
        StringBuilder notEnoughMessage = new StringBuilder();
        if (water < 200) {
            notEnoughMessage.append("water");
            check = true;
        }
        if (milk < 100) {
            if (check) {
                notEnoughMessage.append(", ");
            }
            notEnoughMessage.append("milk");
        }
        if (beans < 12) {
            if (check) {
                notEnoughMessage.append(", ");
            }
            notEnoughMessage.append("beans");
        }
        if (cups < 1) {
            if (check) {
                notEnoughMessage.append(" & ");
            }
            notEnoughMessage.append("cups.");
        }

        if (notEnoughMessage.isEmpty()) {
            this.water -= 200;
            this.milk -= 100;
            this.beans -= 12;
            this.cups -= 1;
            this.money += 6;
            System.out.println("Cappuccino bought!");

        } else {
            System.out.println("Missing: " + notEnoughMessage);
        }

    }
}
