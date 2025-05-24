// 5 columns X 6 rows


fun printBoard(language: Int?, wantedWord: String) {
    println("The word were are looking for is in ${languages[language]}!")
    println("Wanted word is $wantedWord")
    val horizontalLine = " "+"-".repeat(19)

    println(horizontalLine)
    for (i in 0 until rows) {
        print("|")
        for (j in 0 until cols) {
            when {
                board[i][j].lowercase() == wantedWord[j].lowercase() -> print(" $green${board[i][j]}$reset |")
                board[i][j].lowercase() in wantedWord.lowercase() -> print(" $yellow${board[i][j]}$reset |")
                else -> print(" $gray${board[i][j]}$reset |")
            }
        }
    println()
    println(horizontalLine)
    }
}