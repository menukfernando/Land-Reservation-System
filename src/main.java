import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Menuk Fernando
 */
public class main {
        public static final String GREEN = "\033[0;32m";
        public static final String RED = "\033[0;31m";
        public static final String YELLOW = "\033[0;33m";
        public static final String CYAN = "\033[0;36m";
        
        private static String name;
        private static String email;
        private static int contact;
        
    public static void main(String[] args) {
        int choice = 0;
        ArrayList<Shape> shapes = new ArrayList<>();
        ArrayList<Shape> reserveBlock = new ArrayList<>();
        
        //create objects
        Square A = new Square("A-Block", 59, 59);
        Square B = new Square("B-Block",59, 59);
        Trapeziod_Triangle C = new Trapeziod_Triangle("C-Block", 59, 59);
        Rectangle D = new Rectangle("D-Block", 39.3, 73);
        Rectangle E = new Rectangle("E-Block", 39.3, 73);
        Rectangle F = new Rectangle("F-Block", 39.3, 73);
        Trapezoid G = new Trapezoid("G-Block", 38.5, 49, 73);
        Triangle H = new Triangle("H-Block", 49, 73.5);
        
        //add shapes to the the arraylist "shapes"
        shapes.add(A);
        shapes.add(B);
        shapes.add(C);
        shapes.add(D);
        shapes.add(E);
        shapes.add(F);
        shapes.add(G);
        shapes.add(H);
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("                            *******************************                            ");
        System.out.println("                             The Future Land Sales Pvt Ltd                            ");
        System.out.println("                            *******************************                            ");
        
        System.out.println("Silver Reed Lands");
        System.out.println("-----------------");
        System.out.println(" ");
        
        do {
            printMenu();
            System.out.print("Enter your choice (1-4): ");
            choice = input.nextInt();
            handleChoice(choice, shapes, reserveBlock);

        } while (choice != 4); // Continue until the user chooses to exit
   
    }


    private static void printMenu() {
        System.out.println("1. Block's Size and prices.");
        System.out.println("2. Select a block to reserve.");
        System.out.println("3. Display The Reserved Blocks Details:");
        System.out.println("4. Exit");
               
    }

    private static void handleChoice(int choice, ArrayList<Shape> shapes, ArrayList<Shape> reserveBlock) {
        switch (choice) {
            case 1:
                displayBlockSizesAndPrices(shapes);
                break;
            case 2:
                selectBlockToReserve(shapes, reserveBlock);
                break;
            case 3:
                displayReservedBlocksDetails(shapes, reserveBlock);
                break;
            case 4:
                exitProgram();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }

    }

    private static void displayBlockSizesAndPrices(ArrayList<Shape> shapes) {
        System.out.println("\nDisplaying Block's Size and prices...\n");
        for (int i = 0; i < shapes.size(); i++) {
                    System.out.println(String.format(CYAN+shapes.get(i).name+"\nArea in Perches: "+"%.2f", shapes.get(i).PerchArea())+" perches");
                    System.out.println(String.format("Price of the Block: Rs."+"%,.2f",shapes.get(i).BlockPrice()));
                    System.out.println("-----------------------------------");
            }
        System.out.println(" ");
    }

    private static void selectBlockToReserve(ArrayList<Shape> shapes, ArrayList<Shape> reserveBlock) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("a. Enter Customer Name");
        name = input.nextLine(); 

        System.out.println("b. Enter Email Address");
        email = input.nextLine();

        System.out.println("c. Enter Contact Number");
        contact = input.nextInt(); 
        input.nextLine();
        

        System.out.println("\nSelecting a block to reserve...\n");
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println((i + 1)+". "+shapes.get(i).name);
            System.out.println(" ");
        }
        System.out.println("_________________________________________________");
        System.out.print("Enter the index of the block you want to reserve: ");
        int selectedIndex = input.nextInt();

        // Check if the index is valid
        if (selectedIndex >= 1 && selectedIndex < shapes.size()+1) {
        Shape selectedBlock = shapes.get(selectedIndex - 1);

        if (!reserveBlock.contains(selectedBlock)) {
            // Add the reserved block to the reserveblocks ArrayList
            reserveBlock.add(selectedBlock);
            System.out.println(GREEN+"Block " + selectedBlock.name +GREEN+ " reserved successfully!");
            System.out.println(" ");
            // Ask for payment
            System.out.println("Select Payment Option:");
            System.out.println("1. Full Payment");
            System.out.println("2. Partial Payment");

            System.out.print("Enter your choice (1-2): ");
            int paymentChoice = input.nextInt();
            double discountedPrice = selectedBlock.BlockPrice();
            
            switch (paymentChoice) {
                
                case 1:
                    // Full payment with a 10% discount
                    
                    System.out.println(String.format("Total Price: Rs."+"%,.2f", discountedPrice));
                    System.out.print("Total Price with 10% discount: Rs.");
                    System.out.println(String.format("%,.2f", discountedPrice*0.9));
                    
                    // Ask the user to enter the payment amount
                    System.out.print("Enter the payment amount: Rs.");
                    double paymentAmount = input.nextDouble();


                    if (paymentAmount >= (discountedPrice*0.9)) {
                        System.out.println(" ");
                        System.out.println(GREEN +"Payment Successful");
                        System.out.println("-------------------");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println(RED+"Make the full payment.");
                        System.out.println("-------------------");
                        System.out.println(" ");
                    }

                    break;
                    
                case 2:
                    double dueAmount;
                    System.out.print("The full amount of the block is Rs.");
                    System.out.println(String.format("%,.2f", discountedPrice));
                    // Ask the user to enter the payment amount
                    System.out.print("A minimum of 10% of the block price must be paid. (Rs.");
                    System.out.println(String.format("%,.2f", discountedPrice * 10/100)+")");
                    System.out.println("Enter Partial Amount: "); 
                    double partialAmount = input.nextDouble();                   
                                       
                    if (partialAmount > (discountedPrice-partialAmount)) {
                        System.out.println(RED+"Invalid Input, please try again");
                    }
                    System.out.print(YELLOW+"The due amount is: Rs.");
                    System.out.println(String.format(YELLOW+"%,.2f", (discountedPrice-partialAmount)));
                    System.out.println(" ");
                    break;
                default:
                    System.out.println(RED+"Invalid payment choice.");
                    break;
            }
        } else {
            System.out.println("The selected block is already reserved. Please choose another block.");
        }
    } else {
        System.out.println("Invalid index. Please enter a valid index.");
    }
}


    private static void displayReservedBlocksDetails(ArrayList<Shape> shapes, ArrayList<Shape> reserveBlock) {
        
        
        System.out.println("Displaying The Reserved Blocks Details...");
        for (int i = 0; i < reserveBlock.size(); i++) {
            System.out.println("---------------------------");
            System.out.println(reserveBlock.get(i).name);
            System.out.println(String.format("Area of the Block: "+"%.2f", reserveBlock.get(i).PerchArea())+" perches");
            System.out.println(String.format("Full Price: Rs."+"%,.2f", reserveBlock.get(i).BlockPrice()));
            System.out.println("___________________________");
            System.out.println("Buyer Name: "+name);
            System.out.println("Buyer Email: "+email);
            System.out.println("Buyer Contact: "+contact);
            System.out.println("---------------------------");
            System.out.println(" ");
        } 
    }

    private static void exitProgram() {
        System.out.println(" ");
        System.out.println("Exiting the program...");
        System.exit(0);
    }
}
