 import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Computerbot computer = new Computerbot();
    Customerbot customer = new Customerbot();

    computer.clearScreen();
    
    System.out.println("ComputerBot: " + computer.getGreeting());

    while (!customer.customerResponse.equals("Goodbye"))
    {
      System.out.println("CustomerBot: " + customer.getCustomerResponse(computer.computerResponse));
      System.out.println("ComputerBot: " + computer.getComputerResponse(customer.customerResponse));
    }
    
    
  }

}// end of Main class
