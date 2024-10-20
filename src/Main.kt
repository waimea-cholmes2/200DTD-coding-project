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
fun main() {
    // show Title
    println("-------------------")
    println("WELCOME TO OLD GOLD")
    println("-------------------")

    val coins = mutableListOf <String>()
    coins.add("C")
    coins.add("C")
    coins.add("C")
    coins.add("C")
    coins.add("G")

    getUserNames()

    generateCoins()

    generateGameBase()
}

fun getUserNames() {
    print("Enter Player 1's Name:")
    val player1 = readln()

    print("Enter Player 2's Name:")
    val player2 = readln()
}

fun generateCoins() {
println()
}

fun generateGameBase() {
    println("-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --")
    println("1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20")
}