/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Fruit;

public class FruitManagement {
    private Validation v = new Validation();
    ArrayList<Fruit> fruitList = new ArrayList<>();

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
    
    public boolean addFruit(Fruit fruit) {
        for (Fruit f : fruitList) {
            if (f.getFruitId().equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        fruitList.add(fruit);
        return true;
    }
    
    public boolean isOutOfStock(){
        return fruitList.isEmpty();
    }
    
    public Fruit getFruit(int itemNumber){
        int countItem = 0;
        for(Fruit f : fruitList){
            if(f.getQuantity() >= 0){
                countItem++;
                if(countItem == itemNumber){
                    return f;
                }
            }
        }
        return null;
    }
    
    public void createProduct() {
        while (true) {
            String id = v.getString("Enter id: ");
            String name = v.getString("Enter name: ");
            double price = v.getDouble("Enter price: ");
            int quantity = v.getInt("Enter quantity: ",1, Integer.MAX_VALUE);
            String origin = v.getString("Enter origin: ");

            Fruit newFruit = new Fruit(id, name, price, quantity, origin);
            if (addFruit(newFruit)) {
                System.out.println("Successful");
            } else {
                System.err.println("ID or Name is already, cannot create new fruit.");
            }

            if (!v.checkYN("Do you want to continue(Y/N): ")) {
                break;
            }
        }
    }
    
    public void displayFruits() {
        if(fruitList.isEmpty()){
            System.err.println("Out of stock");
            return;
        }
        int countItem = 0;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit Name", "Origin", "Price");
        for (Fruit f : fruitList) {
            if (f.getQuantity() >= 0) {
                countItem++;
                System.out.printf("%-10d", countItem);
                f.display();
            }
        }
    }
    
    public void generate() {
        addFruit(new Fruit("1", "Apple", 4, 10, "Viet Nam"));
        addFruit(new Fruit("2", "Banana", 6, 10, "China"));
    }
}
