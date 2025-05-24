// Set colors and text formatting
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val magenta = "\u001B[35m"
val cyan = "\u001B[36m"
val black = "\u001B[30m"
val gray = "\u001B[90m"
val underline = "\u001B[4m"
val fat = "\u001B[1m"
val reset = "\u001B[0m" // resets the current color and formatting
val clear = "\u001B[H\u001B[2J" // needed to clear the screen

// Set the board
val rows = 6
val cols = 5
var board: Array<CharArray> = Array(rows) { CharArray(cols) { ' ' } }
var inputWord: String = ""
var boardIndex: Int = 0
var wantedWord: String = "hello"
var wordList: Array<String> = arrayOf("hello", "test1", "rrrrr")


fun clearScreen() {
    print(clear)
    System.out.flush()
}

fun isSolved(): Boolean {
    return (inputWord == wantedWord)
}

fun wordsLeft(): Boolean {
    return !(boardIndex >= rows)
}

fun main() {
    // board[0] = arrayOf("H", "E", "L", "L", "O")
    // board[1] = arrayOf("W", "O", "R", "L", "D")

    // Clear the screen
    clearScreen()

    val language: Int? = getLanguage()
    
    // Print the board
    printBoard()

    // as long as the board is not solved, let the player make a move and then print the board
    while (!isSolved() && wordsLeft()) {
        // if word was valid
        if (playerMove()) {

            // place word in the board
            board[boardIndex] = inputWord.toCharArray()

            // increase the board index
            boardIndex++

            // clear screen and print board
            clearScreen()
            printBoard()
        }
    }
    if (isSolved()) {
        // when you win
        println("Congratulations, you found the word!")
    } else {
        // when you lose
        println("You lost! The word was: ${wantedWord}")
    }
}