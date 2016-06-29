---
title: Writing Functions that use Iteration and Collections
type: Lab
duration: "1:30"
creator:
    name: Bradley Zimmerman
    city: SEA
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Writing Functions that use Iteration and Collections

> ***Note:*** _This should be done independently._

## Exercise

#### Dilemma
Dianna's Dinosaur and Donut Emporium needs your help! We have just received a new shipment of our specialty products and the inventory system is on the fritz. The owner (Dianna) has heard from your manager that the new summer intern knows something about computers and storing things in them. Just follow the steps outlined below to fix this mess and hopefully advance up the corporate ladder!

#### Requirements
Follow the 5 steps outlined below. Make sure that each step is part of it's `OWN` function! The program should ask again for input in cases in which values are incorrectly added (i.e. typing in a letter when a price is asked for). 

#### Reminder

To take user input:

```java
public static void askAQuestion() {
    while(true){
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        if (userInput.equals("who")) {
            System.out.println("We're the ADI class.");
        } else if (userInput.equals("exit")) {
            System.exit(0);
        }
    }
}
```

#### Functions
1. Write a function that will allow a user to add Dinosaur or Donut products to the inventory when they type in "Add". For example: "Add Creme Filled Dino Donut" should add the string "Creme Filled Dino Donut" to the inventory.

2. Write a function that will allow a user to see the list of contents of the inventory of the Emporium when they type in "List". Make sure the list is sorted so they can find what they want! Make sure that the first letter of each word is capitalized and every other letter is lowercase. We want to make sure everything looks great for Dianna!

3. Write a function that removes a product from the inventory when they type in "Delete". For example: "Delete 3" should remove the third item in the collection (not the fourth!).

4. Dianna has trouble remembering things after her tragic Brontosaurus accident. Write a function for a "Help" command so that she can see all the different actions she can perform in the program. This should print out explanations for the commands in steps 1-3. 

5. Write a function for a home screen to welcome users to Diannas every time they insert a command. The screen should contain the name "Dianna's Dinosaur & Donut Emporium" and the list of possible commands (Help gives a more detailed explanation).

#### Deliverable

You are expected to create a Java file with 5 functions and run them testing all cases.

#### Resources

- []()
- [Collections](https://developer.android.com/reference/java/util/Collections.html)
