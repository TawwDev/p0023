package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Order> listOrder;

    public Customer() {
        listOrder = new ArrayList<>();
    }

    public Customer(String name, List<Order> listOrder) {
        this.name = name;
        this.listOrder = listOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }

    public void displayListOrders() {
        double total = 0;
        System.out.println("Customer: " + name);
        System.out.printf("%-10s%-15s%-15s%-10s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : listOrder) {
            for (Fruit fruit : order.getFruitOrder()) {
                System.out.printf("%-10s%-15d%-15.2f%-10.2f\n", fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity());
                total += fruit.getPrice() * fruit.getQuantity();
            }
        }
        System.out.printf("Total: %.2f$\n\n", total);
    }

}
