// returns true if move was valid, otherwise returns false
fun playerMove(): Boolean {
    println("Enter your guess!")

    val input = readLine()

    if (input.isNullOrEmpty() || input.length != 5) {
        println("Enter a 5 letter word!")
        return false
    } else if (input !in wordList) {
        println ("Enter a valid word!")
        return false
    } else {
        inputWord = input
        return true
    }
}