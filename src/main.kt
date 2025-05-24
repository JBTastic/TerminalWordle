// Set Colors and text formatting
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

fun clearScreen() {
    print(clear)
    System.out.flush()
}

fun main() {
    // Clear the screen
    clearScreen()
    
    // Test
    println("Test")
}