/************************************************************************
* Name: Derrick Rogers                                            CSC 156
* Date: 4/1/23                                                    Lab 4   
*************************************************************************
* Statement: This program takes a user input message as a string and
            reduces the number of characters in two different ways while
            maintaining the important information of the message. The first
            way the message is compressed is by removing every vowel that is
            not at the start of a word or the first character of the message
            and removing every repeated non-vowel character. The program
            then outputs the shortened message, the number of vowels removed,
            the number of repeated non-vowel characters removed and how much
            shorter the shortened message is than the original. The second
            way the message is compressed is by taking each unique character
            in the order they appear and putting that letter and the number
            of times it appears in the message into a shorted message. The
            program will then output the shortened message, the number of
            times each unique character appears and how much shorter the
            shortend message is than the original.
* 
* Specifications:
*
* Input: User message of type String
*  
* Output: Algorithm 1: number of vowels removed (type int)
                        number of repeating non-vowel characters removed (type int)
                        shortened version of original string (type String)
                        number of characters saved compared to original string (type int)
          Algorithm 2: number of unique characters (type int)
                        shortened version of original message (type String)
                        number of characters saved compared to original string (type int)
* 
************************************************************************/

import java.util.Scanner;

class StringShortener 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);

    String userMessage;
    String shortMessage1 = "";
    String shortMessage2 = "";
    int numOfVowels = 0;
    int numOfDoubles = 0;
    //int numOfRepeats = 0;
    String uniqueOnly = "";
    int numOfUnique = 0;
    int numOfEach = 0;
    

    System.out.println("Type the message to be shortened >>");
    userMessage = input.nextLine();

    userMessage = userMessage.toLowerCase();

    for(int i = 0; i<userMessage.length(); i++)
    {
      if(i != 0 && (userMessage.charAt(i) == 'a'|| userMessage.charAt(i) == 'e'|| 
          userMessage.charAt(i) == 'i' || userMessage.charAt(i) == 'o' || 
          userMessage.charAt(i) == 'u') && !Character.isWhitespace(userMessage.charAt(i - 1)))
          {
            numOfVowels++;
          }
      else if(i != 0 && userMessage.charAt(i) == userMessage.charAt(i - 1))
          {
            numOfDoubles++;
          }
      else
      {
        shortMessage1 += userMessage.charAt(i);
      }
    }
    int numShorter1 = userMessage.length() - shortMessage1.length();

    System.out.println();
    System.out.println("Algorithm 1");
    System.out.println("Vowels removed: " + numOfVowels);
    System.out.println("Repeats removed: " + numOfDoubles);
    System.out.println("Algorithm 1 message: " + shortMessage1);
    System.out.println("Algorithm 1 characters saved: " + numShorter1);
    System.out.println();


    for (int i = 0; i < userMessage.length(); i++)
    {
      if (userMessage.charAt(i) != ' ' && uniqueOnly.indexOf(userMessage.charAt(i))==-1)
        {
          uniqueOnly += userMessage.charAt(i);
          numOfUnique = uniqueOnly.length();
        }
    }
    for (int i = 0; i < uniqueOnly.length(); i++)
    {
      numOfEach = 0;
      for (int j = 0; j < userMessage.length(); j++)
      {
          if (uniqueOnly.charAt(i) == userMessage.charAt(j))
          {
            numOfEach++;
          }
      }
      shortMessage2 += numOfEach + "" + uniqueOnly.charAt(i);
    }

    int numShorter2 = userMessage.length() - shortMessage2.length();

    System.out.println("Algorithm 2");
    System.out.println("Unique characters found: " + numOfUnique);
    System.out.println("Alogrithm 2 message: " + shortMessage2);
    System.out.println("Algorithm 2 characters saved: " + numShorter2);
  }

} //end of class