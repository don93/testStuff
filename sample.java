import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Mauve3 on 6/28/16.
 */
public class main {

  static ArrayList<String> inventory = new ArrayList<>();

  //This is the function that starts up when the program starts
  public static void main(String[] args) {
    //This is calling the function below
    askUser();
  }

  //This is the loop that asks the user for input
  public static void askUser() {
    //The loop keeps repeating forever
    while(true){

      /*
        This calls the print title function to print the title screen for our program.
        It should print every time a user presses enter
       */
      printTitle();

      //This takes in the user input from the command line
      Scanner input = new Scanner(System.in);
      String userInput = input.nextLine();

      //This splits up that user input by spaces
      String[] options = userInput.split(" ");

      //This if statement makes sure that the length is greater than one (something was written)
      if (options.length > 0) {
        //If the first word that the user typed was "add", do this
        if (options[0].toLowerCase().equals("add")) {
          add(options);
          //else if it was delete, do this
        } else if (options[0].equals("delete")) {
          delete(options);
          //and so on...
        } else if (options[0].equals("list")) {
          list();
        } else if (options[0].equals("help")) {
          help();
        } else if (options[0].equals("quit")) {
          System.exit(0);
          //if the command isn't valid, warn the user and ask again
        } else {
          badInput();
        }
        //If nothing was put into the console, print an error
      } else {
        badInput();
      }
    }
  }

  /*
  TODO: BUG! => The add function doesn't keep the spaces when items with multiple words are added to the inventory
   */
  //This function takes in all the words the user inputted (separated by spaces) and adds them to the inventory
  public static void add(String[] options){
    //We need to make sure there is more than just add in the string
    if(options.length > 1) {
      String item = "";
      //If there is, we want to make a blank string, and add all the different parts of the array to it (besides the add keyword)
      for (int i = 1; i < options.length; i++) {
        if (options[i].length() > 0){
          item += options[i];
        }
      }
      //Add the string to the inventory
      inventory.add(item);
      goodInput();
    } else {
      badInput();
    }
  }

  /*
  TODO: BUG! => The delete function deletes the wrong index in the inventory (delete 1 removes the second item instead of the first)
  */

  public static void delete(String[] options){
    if(options.length > 1){
      if (isInt(options[1])) {
        int selection = Integer.parseInt(options[1]);
        if (selection < inventory.size() && selection >= 0) {
          inventory.remove(selection);
          goodInput();
        } else {
          System.out.println("Index is not in the array!");
        }
      } else {
        System.out.println("Index is not an integer!");
      }
    } else {
      badInput();
    }
  }

  /*
  TODO: BUG! => The items aren't capitalized when they are listed!
  */

  public static void list(){
    Collections.sort(inventory);
    for (String item : inventory) {
      System.out.println(item);
    }
  }

  public static void printTitle(){
    System.out.println("\nDianna's Dinosaur & Donut Emporium\n Add, Delete, List, Help\n");
  }

  public static void help(){
    System.out.println("Add: Type in 'add' with item to add an item to the list");
    System.out.println("Delete: Type in 'delete' with the item number to remove an item from the list");
    System.out.println("List: Type in 'list' to list the inventory");
    System.out.println("Help: Type in 'help' top list all the possible commands");
    System.out.println("Quit: Type in quit to exit the program");
  }

  public static void goodInput(){
    System.out.println("Success!");
  }

  public static void badInput(){
    System.out.println("Bad input, try again");
  }

  static boolean isInt(String s)
  {
    try {
      Integer.parseInt(s);
      return true;
    } catch(NumberFormatException er) {
      return false;
    }
  }
}
