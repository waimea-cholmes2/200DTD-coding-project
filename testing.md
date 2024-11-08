# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.

Two players are to compete to remove the Gold Coin from the number 1 square and win the game. One gold coin and the other regular coins are randomly placed on the board. The goal is for you to remove the Gold Coin from the number 1 square. Each turn, you’ll either move a coin left to an open square (without jumping over others) or remove a coin(removing a coin takes a whole turn)

### Game Features and Rules

The game has the following features and/or rules:

- The players names cannot be the same or empty
- The two players have the first turn chosen randomly, then it alternates until one player wins
- The coins are placed randomly after the players decide the game's size and amount of coins
- The players cannot move the coin to the right, over another coin or off the game board.
- Once a player wins the game, they are congratulated

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- Making sure the game board is the correct size
- Making sure that there is the correct amount of coins
- Making sure that the players names are not the same or empty
- Checking that the selected square has a coin in it
- Checking if a letter is input where a number is needed
- Checking if the coin selected to move has any valid moves
- Making sure the selected coin is moved to a valid square
- A player can remove a coin from the first square
- A player can win the game when they remove the gold coin

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Making sure the game board is the correct size

checking if the size of the game board the players selected if within the allowed limits(5-40) 

#### Test Data / Actions to Use

I will first input numbers higher and lower than the limits, then I will input an allowed number

#### Expected Outcome

If the selected size of the game board is within the limits the game will continue, and if not it will ask then to re-enter the size of the game board


### Making sure that there is the correct amount of coins

Checking if the amount of coins is an allowed size(more than 2 but less than the size of the game board)

#### Test Data / Actions to Use

I will input a number less than 2 and a number more than the size of the game board and a number the size of the game board, then I will input a number inside the limits.

#### Expected Outcome

When the input is less than 2 or more than the size of the game board, and when the input is within the limit the game will continue


### Making sure that the players names are not the same or empty

Checking if the names the players have entered are identical or are empty

#### Test Data / Actions to Use

I will input two identical names, two empty names, one empty name, then two different names

#### Expected Outcome

When the names are identical or empty it will ask them to re-enter their names, when the names are different it will continue


### Checking that the selected square has a coin in it

Checking that the square the player selects is not empty

#### Test Data / Actions to Use

I will select an empty square, then one with a coin

#### Expected Outcome

When I select an empty square, the game will ask me to select again, when I select a square with a coin, the game will continue


### Checking if a letter is input where a number is needed

Checking if an input is a letter when a number was requested

#### Test Data / Actions to Use

I will input a letter where a number is requested

#### Expected Outcome

When a letter is input the game will ask for the input again


### Checking if the coin selected to move has any valid moves

Checking if the selected coin is able to move

#### Test Data / Actions to Use

I will request to move a coin that has no valid moves, then a coin with valid moves

#### Expected Outcome

When a coin with no valid moves is selected the player will be asked to pick a new coin, when a coin with valid moves is selected, the game will continue


### Making sure the selected coin is moved to a valid square

Checking if the selected coin is moved to an empty square on the left, that does not require it to hop other coins

#### Test Data / Actions to Use

I will try to move a coin to the right, then try to move another coin off the board to the left, then try to make a coin hop another coin, then I will move a coin to an empty square on the left which does not require it to hop another coin

#### Expected Outcome

When the square I try to move the coin to is not an empty square on the left that does not require the coin to hop another coin it will ask the player to move a coin again, when it is, the game will continue


### A player can remove a coin from the first square

Checking that a coin can be removed from the first square

#### Test Data / Actions to Use

I will select a coin in the first square

#### Expected Outcome

When I select a coin in the first square The game should say the player removed a coin and remove the coin from the game


### A player can win the game when they remove the gold coin

Checking that the game can be won when the gold coin is removed

#### Test Data / Actions to Use

I will select the gold coin in the first square

#### Expected Outcome

when I select the gold coin the game should say whatever players turn it was has won the game and end the game

---


## Evidence / Results of Testing

https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/cholmes2_waimea_school_nz/EZPC-mc1hA9MviJ_WwNP7KMBdulWoPWrBXE_A6BW5-RLEw?e=SoZOS9&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

All the expected outcomes for all the tests happened. (all tests are relatively in the order above)