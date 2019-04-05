public class Customerbot extends Main
{
  public Customerbot()
  {
    customerResponse = "";
  }
  
  /**public String chooseItem()
    {
      return items[(int) (Math.random() * items.length)];
    }
  */
  public String chooseMood()
  {
    return moods[(int) (Math.random() * moods.length)];
  }

  public String getRandomResponse()
  {
    double randomDecimalNum = Math.random();

    int randomInteger = (int) (randomDecimalNum * randomResponses.length);

    return randomResponses[randomInteger];
  }

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

  public String getCustomerResponse(String computerResponse)
  {
    if (findKeyword(computerResponse, "Hello", 0) >= 0 || findKeyword(computerResponse, "What's up", 0) >= 0 || findKeyword(computerResponse, "Howdy", 0) >= 0 || findKeyword(computerResponse, "Greetings", 0) >= 0)
    {
      customerResponse = "Hi!";
    }

    else if (findKeyword(computerResponse, "How are you", 0) >= 0)
    {
      customerResponse = chooseMood();
    }
    else if (findKeyword(computerResponse, "That's great! Would you like to choose some graphics for your computer?", 0) >= 0)
    {
      customerResponse = "Sure!";
    }
    else if (findKeyword(computerResponse, "", 0) >= 0)
    {
      customerResponse = "Goodbye!";
    }

    else
    {
      customerResponse = getRandomResponse();
    }

    return customerResponse;
  }
  
  //instances (aka properties)

  public String customerResponse;

  public String[] moods =
  {
    "good",
    "okay",
    "fine",
    "bad",
    "wonderful"
  };

  private String[] randomColors =
  {
    "Red",
    "Orange",
    "Yellow",
    "Green",
    "Blue",
    "Purple",
    "White",
    "Rainbow",
    "Azure mist",
    "Crimson",
    "Cobalt"
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
}  
