// 5 columns X 6 rows


fun printBoard() {
    val horizontalLine = " "+"-".repeat(19)

    println(horizontalLine)
    for (i in 0 until rows) {
        print("|")
        for (j in 0 until cols) {
            print(" ${board[i][j]} |")
        }
    println()
    println(horizontalLine)
    }
}