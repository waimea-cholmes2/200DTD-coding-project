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
    val coins = MutableList(20) { " " }

    // Add the coins
    val coinsToAdd = listOf("C", "C", "C", "C", "G")

    for (coin in coinsToAdd) {
        var position: Int
        do {
            position = Random.nextInt(0, coins.size) // pick a random spot for the coin to go
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
        print("Enter the position of the coin you'd like to move or remove: ")
        val position = readln().toInt() - 1

        if (position !in coins.indices || coins[position] == " ") {
            println("Nuh uh. Please select a square with a coin.")
            continue
        }

        if (position == 0) {
            // Check if it's in position 1 and remove it
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
            print("Enter the square number to move the coin to: ")
            val newSquare = readln().toInt() - 1

            // Does the move
            move = moveCoin(coins, position, newSquare)
        }
    }

    return false
}


fun moveCoin(coins: MutableList<String>, position: Int, newSquare: Int): Boolean {
    // Check if the square has no coin in it already and to the left of the coin's current position
    if (newSquare < 0 || newSquare >= position || coins[newSquare] != " ") {
        println("Invalid move. You can only move the coin to an empty square on the left.")
        return false
    }

    // Check if there are any coins between current square and target square
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
