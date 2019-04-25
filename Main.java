 import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Computerbot computer = new Computerbot();
    Customerbot customer = new Customerbot();

    computer.clearScreen();
    
    System.out.println("ComputerBot: " + computer.getGreeting());
// MINICH SAYS - you cannot check string equality with == or !=
// YOU MUST USE .equals method and !
    //while (customer.customerResponse != "Goodbye!")
    while (!customer.customerResponse.equals("Goodbye"))
    {
      System.out.println("CustomerBot: " + customer.getCustomerResponse(computer.computerResponse));
      System.out.println("ComputerBot: " + computer.getComputerResponse(customer.customerResponse));
    }
    
    String NAME = "Sven";
    
    System.out.println("Hello, I am the world's first smart vending macine. My name is " + NAME + "!");

    InventoryList itemsForSale = new InventoryList();

    itemsForSale.addItem("energy bar");
    itemsForSale.displayList();
    itemsForSale.addItem("Diet Coke");
    itemsForSale.displayList();
    itemsForSale.removeItem("energy bar");
    itemsForSale.displayList();
    System.out.println(itemsForSale.selectItem(0));

    Scanner keyboard = new Scanner(System.in);
    String userRequest = keyboard.nextLine();

    if (itemsForSale.containsItem(userRequest))
    {
      System.out.println("yes, " + userRequest + " is available.");
    }
    else
    {
      System.out.println("no, " + userRequest + " is not available.");
    }

    System.out.println("Goodbye");
  }

}// end of Main class


