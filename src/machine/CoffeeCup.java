package machine;

public class CoffeeCup extends CoffeeMachine {                  // child class, subclass of Coffeemachine,

    String name;


    public CoffeeCup(int water, int milk, int beans, int cups, int money, String name) { //mogu lako dodavati nove vrste kave ove klase
        super(water, milk, beans, cups, money);
        this.name = name;
    }


    public boolean hasEnoughWater(int water) {
        return water >= this.water;
    }

    public boolean hasEnoughMilk(int milk) {                // tu predajem sastojke od MAŠINE
        return milk >= this.milk;
    }

    public boolean hasEnoughBeans(int beans) {
        return beans >= this.beans;
    }

    public boolean hasEnoughCups(int cups) {
        return cups >= this.cups;
    }


}
