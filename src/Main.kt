import java.io.*
import java.io.Serializable

fun main() {
    val Car1 = Car("Toyota", "Carolla", "1966", 0 )
    val Car2 = Car("Ford", "Falcon", "2016", 0 )
    val Car3 = Car("Ford", "GT", "2005", 0 )
    val Car4 = Car("Honda", "Civic", "2022", 0 )

    val Cars = listOf(Car1, Car2, Car3, Car4)

    var isRunning = true
    while (isRunning) {
        println ("please select from the following options:")
        println ("'1' to display the details of each car")
        println ("'2' to sort the cars by make and display the details of each car")
        println ("'3' to Search a car by it's make")
        println ("'4' to save the list of cars as a binary file")
        println ("'5' to display the data from the binary file, containing the list of cars")
        println ("'6' to exit the program")
        val menuSelection = readln()

        when (menuSelection) {
            "1" -> for (Car in Cars) {
                Car.display()
                println("_____________________")
            }

            "2" -> {
                val sortedCars = Cars.sortedBy { it.make }
                println("Cars Sorted by make in alphabetical order:")
                println("_____________________")
                for (Car in sortedCars) {
                    println()
                    Car.display()
                    println("_____________________")
                }
            }

            "3" -> {
                println("please enter the make of the car you wish to search:")
                val searchTarget = readln()
                println("___________________")

                var targetFound = false
                for (Car in Cars) {
                    if (Car.make == searchTarget) {
                        Car.display()
                        println("___________________")
                        targetFound = true
                    }
                }
                if (!targetFound) {
                    println(
                        "No cars found with the make name '$searchTarget' " +
                                "please enter a new search to try again:"
                    )
                }
            }
            "4" -> {
                println("Writing to file...")
                try {
                    val fileOut = FileOutputStream("Cars.bin")
                    val objectOut = ObjectOutputStream(fileOut)
                    objectOut.writeObject(Cars)
                    fileOut.close()
                    println("Completed - Cars.bin")
                } catch (e: IOException) {
                    println(e)
                }
            }

            "5" -> {

            }

            "6" -> {
                println ("Exiting...")
                isRunning = false
            }
        }
    }
}