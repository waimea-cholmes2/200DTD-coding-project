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
    println("-------------------")
    println("WELCOME TO OLD GOLD")
    println("-------------------")

    // Make the coin list
    val coins = MutableList(20) { " " }

    // Add 4 "C"s and 1 "G"
    val coinsToAdd = listOf("C", "C", "C", "C", "G")

    for (coin in coinsToAdd) {
        var position: Int
        do {
            position = Random.nextInt(0, coins.size) // pick a random spot for the coin to go
        } while (coins[position] != " ") // Make sure there is not already a coin there
        coins[position] = coin // Place the coin
    }

    getUserNames()

    generateGameBase(coins)
}

fun getUserNames() {
    print("Enter Player 1's Name: ")
    val player1 = readln()

    print("Enter Player 2's Name: ")
    val player2 = readln()
}

fun generateGameBase(coins: MutableList<String>) {
    // Build the top
    var x=1
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

    // Display the numbers
    for (i in coins.indices) {
        print("|%-2d ".format(x))
        x++
    }
    println("|")

    //Build the bottom
    print("+---".repeat(coins.size))
    println("+")
}
