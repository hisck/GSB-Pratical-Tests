import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

public class Result {
    //Function that verify if a letter has already appeared before on the string
    public static boolean checkLetterAppearence(int arr[], int letterValue){
        int index = 0;
        boolean returnValue = false;
        //This condition checks the end. Once the letterAppearenceOrder array had been initialized with all the values as -1, that means that
        //if the value at some index is -1, that means that it has reached the end of the array, so it the letter haven't appeared before on the 
        //string.
        while(arr[index] != -1){
            if(arr[index] == letterValue){
                returnValue = true;
            }
            index++;
        }
        return returnValue;
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Original string: ");
        String userInput = input.readLine();
        if(!(userInput == null)){
            int[] countingArray;
            int[] letterAppearenceOrder;
            countingArray = new int[26]; 
            letterAppearenceOrder = new int[26];
            //initialize counting array with zeros and letter appearence order with -1
            for(int i = 0; i < 26; i++){
              countingArray[i] = 0;
              letterAppearenceOrder[i] = -1;
            }
            int cntLetters = 0;
            //counts normal and capital letters as the same
            for(int i = 0; i < userInput.length(); i++){
              int valueCapitalLetter = (int)userInput.charAt(i) - 65;
              int valueLetter = (int)userInput.charAt(i) - 97;
              int value = valueLetter >= 0 ? valueLetter : valueCapitalLetter;
              if(value >= 0 && value <= 25){
                  countingArray[value] += 1;
                  if(!checkLetterAppearence(letterAppearenceOrder, value)){
                      letterAppearenceOrder[cntLetters] = value;
                      cntLetters++;
                  }
              }
            }
            //Print for each letter that appeared (on the order that it appeared on the string) how many times it appeared on the string
            for(int i = 0; i < cntLetters; i++){
              int letterValue = letterAppearenceOrder[i];
              int ascValue = letterValue + 65;
              char character = (char)ascValue;
              System.out.println(character + ": " + countingArray[letterValue]);
            }
        }
    }
}
