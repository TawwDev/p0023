package controller;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Fruit;
import model.Order;

public class CustomerManagement {

    ArrayList<Customer> customerList = new ArrayList<>();

    Validation v = new Validation();

    public void displayCustomerOrdersList() {
        if (customerList.isEmpty()) {
            System.err.println("No data found\n");
        } else {
            System.out.println("View Order:");
            for (Customer x : customerList) {
                x.displayListOrders();
            }
        }
    }

    public void shopping(FruitManagement fm, Customer c) {
        if (fm.isOutOfStock()) {
            System.out.println("No fruits available for shopping.");
            return;
        }
        List<Order> orderList = new ArrayList<>();
        Customer customer = new Customer();
        String customerName;

        while (true) {
            fm.displayFruits();
            
            int item = v.getInt("Please select a fruit item: ", 1, fm.getFruitList().size());
            Fruit selectedFruit = fm.getFruit(item);
            System.out.println("You selected: " + selectedFruit.getFruitName());

            int quantity = v.getInt("Please input quantity: ", 0, Integer.MAX_VALUE);

            if (quantity > selectedFruit.getQuantity()) {
                System.out.println("Not enough stock available!\n");
            } else {
                fm.getFruit(item).setQuantity(selectedFruit.getQuantity() - quantity);
                Fruit fruitOrder = new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(), selectedFruit.getPrice(), quantity, selectedFruit.getOrigin());
                Order order = new Order();
                order.getFruitOrder().add(fruitOrder);
                orderList.add(order);

                if (v.checkYN("Do you want to order now (Y/N)?")) {
                    break;
                }
            }
        }

        customerName = v.getString("Input your name: ");
        customer.setName(customerName);
        customer.setListOrder(orderList);

        customerList.add(customer);
        System.out.println("Order completed. Thank you!\n");
    }
}
