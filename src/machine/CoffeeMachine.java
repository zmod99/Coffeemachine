package machine;


class CoffeeMachine {

    int water;                      //postavljanje stanja, fields
    int milk;
    int beans;
    int cups;
    int money;


    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {

        this.water = water;           //konstruktor za kreiranje klase CoffeeMachine
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;



    }

    public void buy(CoffeeCup selectedCoffee) {
        if (!selectedCoffee.hasEnoughWater(this.water)) {
            System.out.println("Not enough water!");
        } else if (!selectedCoffee.hasEnoughMilk(this.milk)) {
            System.out.println("Not enough milk!");

        } else if (!selectedCoffee.hasEnoughBeans(this.beans)) {
            System.out.println("Not enough beans!");

        } else if (!selectedCoffee.hasEnoughCups(this.cups)) {
            System.out.println("Not enough cups!");
        } else {
            System.out.println(selectedCoffee.name + " bought!");
            this.water -= selectedCoffee.needsWater;
            this.milk -= selectedCoffee.needsMilk;
            this.beans -= selectedCoffee.needsBeans;
            this.cups -= selectedCoffee.needsCups;
            this.money += selectedCoffee.needsMoney;
        }


    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }


}
