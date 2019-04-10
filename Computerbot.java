import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//boolean: shoppingcart or not
//ints: cost, amount of items, etc
public class Computerbot extends Main
{
   // default constructor
   public Computerbot()
   {
      computerResponse = "";
      //myBoolean = false;

      // TODO initialize all properties

      greetings = new String[4];
      greetings[0] = "Hello";
      greetings[1] = "What's up?";
      greetings[2] = "Howdy";
      greetings[3] = "Greetings";
   } 

  // accessors 
   
   // TODO

   // ##################### accessors

   public String getGreeting()
   {
      computerResponse = greetings[(int) (Math.random() * greetings.length)];
      return computerResponse;
   }
   
   // Dipsplays different Graphics Cards
   public void getGraphicsCard()  
   {
     System.out.println("ComputerBot: You can choose from these:");

     for (int i = 0; i < graphicsCards.length; i++)
     {
       System.out.println((i + 1) + ". " + graphicsCards[i]);
     }
     
   }

   public String getDateAndTime()
   {
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/yyy HH:mm:ss"); // Sets The Format For The Date And Time
	  LocalDateTime dateTime = LocalDateTime.now();
    return "The date and time is " + formatDate.format(dateTime) + " GMT";
   }

   public int getShoppingCart()
   {

    //counts amount of items chosen and/or shows the items
    return 5;
   }

   public String getRandomResponse()
  {
    double randomDecimalNum = Math.random();

    int randomInteger = (int) (randomDecimalNum * randomResponses.length);

    return randomResponses[randomInteger];
  }

   public String getComputerResponse(String customerResponse)
   {
     if (findKeyword(customerResponse, "time", 0) >= 0)
     {
       computerResponse = getDateAndTime();
     }

     else if (findKeyword(customerResponse, "hi", 0) >= 0)
     {
       computerResponse = "How are you?";
     }

     else if (findKeyword(customerResponse, moods[0], 0) >= 0 || findKeyword(customerResponse, moods[1], 0) >= 0 || findKeyword(customerResponse, moods[2], 0) >= 0 || findKeyword(customerResponse, moods[4], 0) >= 0)
     {
       computerResponse = "That's great! Would you like to choose some graphics for your computer?";
     }

     else if (findKeyword(customerResponse, moods[3], 0) >= 0)
     {
       computerResponse = "That's too bad. Maybe choosing some graphics for your computer will cheer you up!";
     }

     else if (findKeyword(customerResponse, "Sure!", 0) >= 0)
     {
       getGraphicsCard();

       computerResponse = "The estimated prices will be shown after you have chosen the parts that you want.";
     }
     
      else if (findKeyword(customerResponse, "perfect", 0) >= 0)
     {
        computerResponse = "Thank you for shopping at Krazy Gamers";
     }
    
     else if (findKeyword(customerResponse, "like number", 0) >= 0)
     {
       int graphicsChoice = Integer.parseInt(customerResponse.substring(16, 17));
       computerResponse = "That one will cost about " + graphicsCardPrices[graphicsChoice];
     }

     else
     {
       computerResponse = getRandomResponse();
     }

     return computerResponse;
   }

   // modifiers
   public void chooseGraphicsCard()
   {
     //return "hi";
   }
   
   public String chooseProcessor()
   {
     return "hi";
   }






   // ######################### interesting methods
   private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();
    
		int position = phrase.indexOf(goal, startPos);

		while (position >= 0)
		{
			String before = " ";
      String after = " ";
			
      if (position > 0)
			{
				before = phrase.substring(position - 1, position);
			}
			if (position + goal.length() < phrase.length())
			{
				after = phrase.substring(position + goal.length(), position + goal.length() + 1);
			}

			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
			{
				return position;
			}

			// Finds the next position if there is one
			position = phrase.indexOf(goal, position + 1);

		}// end of while 

    return -1;
  } // end of findKeyword method
   
   public static void clearScreen() 
   {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }  
   
   
   




   // ############################# instance fields (aka properties)

    public String computerResponse;           // The computerBot's response

    private String graphicsCard;

    private boolean weatherPrompt;            // If the computerBot will ask about the weather
    private int amountOfItems;                // The amount of items that have been chosen
    private double estimatedPrice;            // How much the customerBot should be expected to spend on the chosen items

   private String[] greetings;            // The different greetings that the computerbot uses

   private String[] goodbye = 
   {
     "bye", 
     "goodbye", 
     "see you later", 
     "see you soon", 
     "adios",             // Spanish
     "au revoir",         // French
     "ciao"               // Italian 
   };

   public String[] moods =
  {
    "good",
    "okay",
    "fine",
    "bad",
    "wonderful"
  };

   public String[] graphicsCards =
     {
      "Nvidia Titan V",
      "Nvidia Titan RTX",
      "Nvidia GeForce RTX 2080 Ti",
      "Nvidia GeForce RTX 2070",
      "Nvidia GeForce GTX 1080",
      "Nvidia GeForce GTX 1050 Ti"
     };

     public String[] graphicsCardPrices =
     {
      "$2,999.99",
      "$2,499.99",
      "$1,499.99",
      "$1,099.99",
      "$749.99",
      "$499.99"
     };

   public String[] processors =
    {
      "Intel i9",
      "Intel i7",
      "Intel i5"
    };
    
   public String[] ramOptions =
   {
     "16 GB",
     "32 GB",
     "64 GB",
     "128 GB"
   };

   private String[] randomResponses =
   {
    "Good work", 
    "Mhm",
    "How was your day?",
    "Thats good",
    "Oh no! What happened?",
    "Very interesting",
    "Sounds like fun!"
   };
  
    
   private String[] rgbOptions =
   {
    "Red",
    "Orange",
    "Yellow",
    "Green",
    "Blue",
    "Purple",
    "White",
    "Rainbow"
   };
   
}
