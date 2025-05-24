fun getLanguage(): Int? {
    var language: Int? = null 
    while (language !in listOf(1,2)) {
        println("Please enter language:\nEnglish: 1\nGerman: 2")
        val input = readLine()
        if (input.isNullOrEmpty()) {
            return 0
        }
        try {
            val number = input?.toInt()
            if (number in listOf(1,2)) {
                return number
            } else {
                clearScreen()
                println("Invalid language! Please enter 1 or 2.")
            }
        } catch (e: Exception) {
            clearScreen()
            println("Invalid language! Please enter 1 or 2.")
        }
    }
    return 0
}