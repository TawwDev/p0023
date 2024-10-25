
package controller;

import java.util.Scanner;

public class Validation {
    private Scanner sc = new Scanner (System.in);
    
    public int getInt(String msg, int min, int max){
        while(true){
            try{
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if(n>= min && n<=max){
                    return n;
                } else{
                    System.err.println("re-input");
                }
            }catch(NumberFormatException nfe){
                System.err.println("re-input");
            }
        }
    }
    
    public double getDouble(String msg){
        while(true){
            try{
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine());
                if(n > 0){
                    return n;
                } else{
                    System.err.println("Input must be greater than 0");
                }
            }catch(NumberFormatException nfe){
                System.err.println("re-input");
            }
        }
    }
    
    public String getString(String msg){
        while(true){
            System.out.print(msg);
            String s = sc.nextLine();
            if(!s.isEmpty()){
                return s;
            } else{
                System.out.println("String just not empty");
            }
        }
    }
    
    public boolean checkYN(String msg){
        while(true){
            String s = getString(msg);
            if(s.equalsIgnoreCase("y")){
                return true;
            } else if(s.equalsIgnoreCase("n")){
                return false;
            } else{
                System.err.println("Input must be Yes or No, please re-input!");
            }
        }
    }
}
