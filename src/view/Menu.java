package view;

import controller.CustomerManagement;
import controller.FruitManagement;
import controller.Validation;
import model.Customer;

public class Menu {

    private void menu() {
        System.out.println("=============FRUIT SHOP SYSTEM=============");
        System.out.println("1.Create Fruit");
        System.out.println("2.View orders");
        System.out.println("3.Shopping(for buyer)");
        System.out.println("4.Exit");
    }

    public void display() {
        FruitManagement fm = new FruitManagement();
        CustomerManagement cm = new CustomerManagement();
        Customer c = new Customer();
        Validation v = new Validation();
        fm.generate();
        int n;
        do {
            menu();
            n = v.getInt("Your choice:", 1, 4);
            switch (n) {
                case 1:
                    fm.createProduct();
                    break;
                case 2:
                    cm.displayCustomerOrdersList();
                    break;
                case 3:
                    cm.shopping(fm, c);
                    break;
                case 4:
                    break;
            }
        } while (n != 4);
    }
}
