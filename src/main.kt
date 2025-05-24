import java.io.File

// set colors and text formatting
val red = "\u001B[31m"
val green = "\u001B[32m"
val yellow = "\u001B[33m"
val blue = "\u001B[34m"
val magenta = "\u001B[35m"
val cyan = "\u001B[36m"
val black = "\u001B[30m"
val gray = "\u001B[90m"
val underline = "\u001B[4m"
val bold = "\u001B[1m"
val reset = "\u001B[0m" // resets the current color and formatting
val clear = "\u001B[H\u001B[2J" // needed to clear the screen

// set the board and initialize variables
val rows = 6
val cols = 5
var board: Array<CharArray> = Array(rows) { CharArray(cols) { ' ' } }
var inputWord: String = ""
var boardIndex: Int = 0
var languages: Map<Int, String> = mapOf(1 to "English", 2 to "German")


fun clearScreen() {
    print(clear)
    System.out.flush()
}

fun introduction() {
    println("Welcome to Wordle!")
    println("How to play:")
    println("${underline}Guess the Wordle in 6 tries${reset}.")
    println("Each guess must be a valid 5 letter word.")
    println("The color of the letters will change to show how close you are to the word.")
    println("${green}Green${reset} means, the letter is ${underline}in the word and in the correct spot${reset}.")
    println("${yellow}Orange${reset} means, the letter is ${underline}in the word but in the wrong spot${reset}.")
    println("${gray}Gray${reset} means, the letter is ${underline}not in the word${reset}.")
    println("Goodluck!")
    println("\nPress any key to continue...")
}

fun setWordFile(language: Int?): Pair<Array<String>, String> {
    // set the path to the word list:
    val wordListFile: String = when(language) {
            1 -> "words/english_words.txt"
            2 -> "words/german_words.txt"
            else -> "words/english_words.txt" // fallback
        }

    // read the word list from the file
    var wordList: Array<String> = File(wordListFile)
            .readLines()
            .map { it.trim().removeSurrounding("\"") }  // strip "
            .toTypedArray()

    // select random word from word list
    var wantedWord: String = wordList.random()

    // // TESTING: set wanted word to hello for testing
    // var wantedWord: String = "hello"

    return Pair(wordList, wantedWord)
}

fun isSolved(wantedWord: String): Boolean {
    return (inputWord == wantedWord)
}

fun wordsLeft(): Boolean {
    return !(boardIndex >= rows)
}

fun main() {

    // lear the screen
    clearScreen()

    val language: Int? = getLanguage()
    clearScreen()

    // introduction
    introduction()
    
    // get word list and wanted word depending on the selected language
    val (wordList, wantedWord) = setWordFile(language)

    // so you have to press something for the game to start
    readLine()
    clearScreen()
    
    // Print the board
    printBoard(language, wantedWord)

    // as long as the board is not solved, let the player make a move and then print the board
    while (!isSolved(wantedWord) && wordsLeft()) {
        // if word was valid
        if (playerMove(wordList)) {

            // place word in the board
            board[boardIndex] = inputWord.uppercase().toCharArray()

            // increase the board index
            boardIndex++

            // clear screen and print board
            clearScreen()
            printBoard(language, wantedWord)
        }
    }
    if (isSolved(wantedWord)) {
        // when you win
        println("Congratulations, you found the word!")
    } else {
        // when you lose
        println("You lost! The word was: ${wantedWord}")
    }
}