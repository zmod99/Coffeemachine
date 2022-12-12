package machine;

public class CoffeeCup{

    int needsWater;
    int needsMilk;
    int needsBeans;
    int needsCups;
    int needsMoney;

    String name;


    public CoffeeCup(int needsWater, int needsMilk, int needsBeans, int cups, int money, String name) {
        this.needsWater = needsWater;
        this.needsMilk = needsMilk;
        this.needsBeans = needsBeans;
        this.needsCups = cups;
        this.needsMoney = money;
        this.name = name;
    }


    public boolean hasEnoughWater(int water) {
        return water >= this.needsWater;
    }

    public boolean hasEnoughMilk(int milk) {                // tu predajem sastojke od MAŠINE
        return milk >= this.needsMilk;
    }

    public boolean hasEnoughBeans(int beans) {
        return beans >= this.needsBeans;
    }

    public boolean hasEnoughCups(int cups) {
        return cups >= this.needsCups;
    }


}
