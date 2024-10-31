/**
 * ------------------------------------------------------------------------
 * Old Gold
 * Level 2 programming project
 *
 * By Cooper Holmes
 *
 * This is a two player game where the aim is to be the player who wins by
 * removing the gold coin a number of coins are randomly placed inside a
 * one dimensional game board
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */

import kotlin.random.Random

fun main() {
    // Show title
    println("----------------------------------")
    println("       WELCOME TO OLD GOLD        ")
    println("----------------------------------")

    // Print the description and instructions
    println("Description and instructions")

    // Mask how big they want the game to be
    var gameSize = forceNumber("How big do you want the board to be from 5-20?:")

    // Make sure the game is not too big or small
    while (gameSize !in 5..20) {
        println("Sorry :( The board's size must be between 5 and 20.")
        gameSize = forceNumber("How big do you want the board to be from 5-20?:")
    }

    // Make the list
    val coins = MutableList(gameSize) { " " }

    // ask the player for the total number of coins (including the gold coin)
    var totalCoins = forceNumber("Enter the total number of coins (minimum 2, has to be smaller than the game board): ")

    // make sure there is not too many or too little coins
    while (totalCoins !in 2..<gameSize) {
        println("sorry :( the amount of coins has to be smaller than the game board by at least one, and has to be a minimum of 2")
        totalCoins = forceNumber("Enter the total number of coins (minimum 2, has to be smaller than the game board): ")
    }

    val nonGoldCoins = totalCoins - 1 // One of the coins will be gold

    // Create a list with one gold coin and the number of regular coins
    val coinsToAdd = MutableList(nonGoldCoins) { "C" } + "G"

    for (coin in coinsToAdd) {
        var position: Int
        do {
            position = Random.nextInt(0, gameSize - 1) // pick a random spot for the coin to go
        } while (coins[position] != " ") // Make sure there is not already a coin in the random spot
        coins[position] = coin // Place the coin
    }

    // Get the user's names and welcome them
    val (player1, player2) = getUserNames()

    // Randomly select a player to start
    var currentPlayer = if (Random.nextBoolean()) player1 else player2

    //Start the game
    var game = false
    while (!game) {
        println("\n$currentPlayer's turn!")

        // Generate the board
        generateGameBase(coins)

        // Start the players turns
        game = playerMove(currentPlayer, coins)

        // Check if a player has won
        if (game) {
            println("$currentPlayer wins!!!!")
        }
        else {
            // If no one wins swap the turns
            currentPlayer = if (currentPlayer == player1) player2 else player1
        }
    }
}

fun getUserNames(): Pair<String, String> {
    while (true) {
        print("Enter Player 1's Name: ")
        val player1 = readln().capitalize()

        print("Enter Player 2's Name: ")
        val player2 = readln().capitalize()

        //check if the names are the same
        if (player1 != player2) {
            println("Welcome $player1 and $player2!")
            return Pair(player1, player2) // Names are different, continue
        } else {
            println("Names cannot be the same. Please enter different names or maybe add a 1 to the end of one of your names") // Names are different, re ask
        }
    }
}

fun generateGameBase(coins: MutableList<String>) {
    // Build the top
    var x = 1
    print("+---".repeat(coins.size))
    println("+")

    // Display the coins
    for (i in coins.indices) {
        print("| ${coins[i]} ")
    }

    println("|")
    // Build the middle
    print("+---".repeat(coins.size))
    println("+")

    // Display the numbers below the grid
    for (i in coins.indices) {
        print("|%-2d ".format(x))
        x++
    }
    println("|")

    // Build the bottom
    print("+---".repeat(coins.size))
    println("+")
}

fun playerMove(currentPlayer: String, coins: MutableList<String>): Boolean {
    var move = false
    while (!move) {
        // Ask the player which coin they want to move
        val position = forceNumber("Enter the position of the coin you'd like to move or remove: ") - 1

        // Check if the selected square has a coin in it
        if (position !in coins.indices || coins[position] == " ") {
            println("Nuh uh. Please select a square with a coin.")
            continue
        }

        // Check if the coin has any possible moves
        if (position > 0 && coins[position - 1] != " ") {
            println("Sorry that coin has no possible moves")
            continue
        }

        // Check if it's in position 1 and remove it
        if (position == 0) {
            println("$currentPlayer has removed a coin")
            val removedCoin = coins[0]
            coins[0] = " "
            // Check if the removed coin was the gold coin.
            if (removedCoin == "G") {
                return true
            } else {
                return false
            }
        }
        else {
            // Ask player which square they want to move the coin to
            val newSquare = forceNumber("Enter the square number to move the coin to:") - 1

            // Does the move
            move = moveCoin(coins, position, newSquare)
        }
    }

    return false
}

fun forceNumber(prompt: String): Int {
    while (true) {
        // Display the question to the user
        print(prompt)
        val input = readln()

        // Check if the input is a number or not
        val number = input.toIntOrNull()
        if (number != null) return number

        // If it is not a number, re ask the prompt.
        println("You can't choose a letter here. Please enter a number.")
    }
}


fun moveCoin(coins: MutableList<String>, position: Int, newSquare: Int): Boolean {
    // Check if the square has no coin in it already and to the left of the coin's current position
    if (newSquare < 0 || newSquare >= position || coins[newSquare] != " ") {
        println("Invalid move. You can only move the coin to an empty square on the left.")
        return false
    }

    // Check if there are any coins between current square and new square
    for (i in (newSquare + 1)..<position) {
        if (coins[i] != " ") {
            println("Invalid move. You cannot jump over another coin.")
            return false
        }
    }

    // Move the coin to the new square
    coins[newSquare] = coins[position]
    coins[position] = " "
    return true
}
