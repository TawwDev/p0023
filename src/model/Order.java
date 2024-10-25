package model;

import java.util.ArrayList;

public class Order {

    private ArrayList<Fruit> fruitOrder;

    public Order() {
        fruitOrder = new ArrayList<>();
    }

    public Order(ArrayList<Fruit> fruitOrder) {
        this.fruitOrder = fruitOrder;
    }

    public ArrayList<Fruit> getFruitOrder() {
        return fruitOrder;
    }

    public void setFruitOrder(ArrayList<Fruit> fruitOrder) {
        this.fruitOrder = fruitOrder;
    }
}
