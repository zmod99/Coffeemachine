package machine;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        while (true) {
            coffeeMachine.askForService();
        }

    }


}


