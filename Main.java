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
    
    
  }

}// end of Main class


