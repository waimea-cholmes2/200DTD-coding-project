/**
 * ------------------------------------------------------------------------
 * Old Gold
 * Level 2 programming project
 *
 * By Cooper Holmes
 *
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */

import kotlin.random.Random

fun main() {
    // show Title
    println("----------------------------------")
    println("       WELCOME TO OLD GOLD        ")
    println("----------------------------------")

    // Make the list
    var gameSize = forceNumber("How big do you want the board to be from 5-20?:")
    //ensure the game is not too big or small
    while (gameSize !in 5..20) {
        println("Sorry :( Grid size must be between 5 and 20.")
        gameSize = forceNumber("How big do you want the board to be from 5-20?:")
    }
    val coins = MutableList(gameSize) { " " }

    // ask the player for the total number of coins (including one gold coin)
    var totalCoins = forceNumber("Enter the total number of coins (minimum 2, has to be smaller than the game board): ")
    while (totalCoins !in 2..<gameSize - 1) {
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
    print("Enter Player 1's Name: ")
    val player1 = readln().capitalize()

    print("Enter Player 2's Name: ")
    val player2 = readln().capitalize()

    println("Welcome $player1 and $player2")
    return Pair(player1, player2)
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
