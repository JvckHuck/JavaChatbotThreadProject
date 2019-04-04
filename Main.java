import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    Computerbot computer = new Computerbot();
    Customerbot customer = new Customerbot();

    
    System.out.println(computer.getGreeting());

    while (customer.customerResponse != "Goodbye!")
    {
      System.out.println(customer.getCustomerResponse(computer.computerResponse));
      System.out.println(computer.getComputerResponse(customer.customerResponse));
    }
    
    
  }

}// end of Main class
