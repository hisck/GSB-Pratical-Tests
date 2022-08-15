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
    public static void main(String args[]) throws IOException{
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Original string: ");
      String userInput = input.readLine();
      int stringSize = userInput.length();
      int[] countingArray;
      countingArray = new int[26]; 
      //initialize array with zeros
      for(int i = 0; i < 26; i++){
          countingArray[i] = 0;
      }
      //counts normal and capital letters as the same
      for(int i = 0; i < stringSize; i++){
          int valueCapitalLetter = (int)userInput.charAt(i) - 65;
          int valueLetter = (int)userInput.charAt(i) - 97;
          int value = valueLetter >= 0 ? valueLetter : valueCapitalLetter;
          if(value >= 0 && value <= 25){
              countingArray[value] += 1; 
          }
      }
      for(int i = 0; i < 26; i++){
          int ascValue = i + 65;
          char character = (char)ascValue;
          if(countingArray[i] > 0 ){
              System.out.println(character + ": " + countingArray[i]);
          }
       }
    }
}
