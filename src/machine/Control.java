package machine;

import java.io.*;
import java.util.Scanner;

class Control {
    static final String savedLocation = "doc/coffee_machine_state.txt";       /*Access klasa 3 static metode za spremanje/ucitavanje stanja masine
                                                                                     i ucitavanje unosa kod logina i provjere ispravnosti iz istog filea
                                                                                  gdje su spremljena stanja, doc/coffee_machine_state.txt
*/
    static CoffeeMachine readCoffeeMachine() throws FileNotFoundException {    //checked exception
        Scanner scanner = new Scanner(new File(savedLocation));
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        scanner.useDelimiter(";");
        while (scanner.hasNextInt()) {
            water = scanner.nextInt();      //treba biti tocan forrmat inace runtime exception
            milk = scanner.nextInt();
            beans = scanner.nextInt();
            cups = scanner.nextInt();
            money = scanner.nextInt();

        }
        return new CoffeeMachine(water, milk, beans, cups, money);
    }

    static void writeCoffeeMachine() throws IOException {                   //checked exception
        String savedLocation = "doc/coffee_machine_state.txt";
        FileWriter filewriter = new FileWriter(savedLocation);
        filewriter.write(Main.coffeeMachine.water + ";");
        filewriter.write(Main.coffeeMachine.milk + ";");
        filewriter.write(Main.coffeeMachine.beans + ";");
        filewriter.write(Main.coffeeMachine.cups + ";");
        filewriter.write(Main.coffeeMachine.money + ";");
        filewriter.write("\n" + "admin;admin12345;");
        filewriter.close();
    }

    static boolean tryLogin() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);                //cita unos s terminala
        Scanner reader = new Scanner(new File(savedLocation));     //cita iz datoteke
        reader.nextLine();
        reader.useDelimiter(";");
        System.out.println("Enter username:");
        String user = scanner.nextLine();
        System.out.println("Enter password:");
        String pass = scanner.nextLine();
        return reader.next().equals(user) && reader.next().equals(pass);
    }

}

