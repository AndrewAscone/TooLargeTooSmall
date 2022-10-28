import java.util.Scanner;
import java.util.Random;

/**
 * Created by iyasuwatts on 10/17/17.
 */

/*
Things that need to be added to complete game:
- Random number in a certain range (probably 1-10) using a random number function
- Input from user to make their guess
- Conditional based on user input against actual answer
- A loop that will repeat until the correct number is guessed (probably while or do while)
- An iterator in the loop to track the number of guesses
- A conditional to prevent a repeated number from counting as another guess

Possible variables:
- randomNum (randomly chosen number to guess)
- userGuess (User's guess for the number)
- correctGuess (Boolean state for the loop to check if the user has guessed correctly)
- totalGuess (Number of attempts to guess the correct number)
- prevGuess (Store the previous guess to check it against the next guess and determine if totalGuess will be incremented)
 */
public class Main {

    public static void main(String[] args){
        //Make a scanner for the user to input their guesses
        Scanner input = new Scanner(System.in);

        //Create a random number generator and set the upper limit for 10
        Random randomNum = new Random();
        int numHigh = 10;

        //Generate a random integer number from 1 to 10, the '+1' changes the range from 0-9 up to 1-10
        int magicNum = randomNum.nextInt(numHigh) + 1;

        //Testing that random number generator works correctly
        //System.out.println(magicNum);

        //Set a false boolean flag for the while loop to check if the correct number was guessed
        boolean correct = false;

        //A counter that will be incremented as the player makes more guesses
        int guessCount = 0;

        int previousGuess = 0;

        //System.out.println("Random num is: " + magicNum);

        /*
        This while loop does the following: It asks the user for input of a number between 1 and 10. It then checks if the
        previous number guess is the same as the new guess. If they do not match, the guess counter increments.
        The loop then checks if the player's guess matches the random number in the 'magicNum' variable.
        If they match, it congratulates the player and ends the loop. If not, it then checks if the
        number was either lower or higher than the random number. In both of those cases, the player is told their guess
        was either too low or too high. The guess is stored in the previous guess variable for the next loop.
        It then goes back to the start of the loop for the next guess.
         */

        while (correct == false){

            System.out.println("I'm thinking of a number between 1 and 10. Can you guess it?");
            int playerGuess = input.nextInt();


            if(previousGuess != playerGuess){
                guessCount++;
            }

            if (playerGuess == magicNum){
                System.out.println("That's right! I was thinking of " + magicNum + "!");
                System.out.println("It took you " + guessCount + " guesses!");
                correct = true;
            }
            else if (playerGuess < magicNum){
                System.out.println("That's too low. Try again!");
                previousGuess = playerGuess;
            }
            else if (playerGuess > magicNum){
                System.out.println("That's too high. Try again!");
                previousGuess = playerGuess;
            }
        }
    }
}
