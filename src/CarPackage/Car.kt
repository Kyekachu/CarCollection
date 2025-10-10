package CarPackage

import java.io.Serializable

class Car : Serializable {
    var make: String
    var model: String? = null
    var year: String? = null
    var odometer = 0
    constructor(make: String) {
        this.make = make
    }
    constructor(make: String, model: String?, year: String?, odometer: Int) {
        this.make = make
        this.model = model
        this.year = year
        this.odometer = odometer
    }
    fun display() {
        println("$make $model")
        println("Year: $year")
        println("km travelled: $odometer")
    }
}