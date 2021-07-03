package day5

// 0...127 line
// 0..7 columns

// First letter F -> 0..63, B 64-> 127
const val INPUT = "src/day5/input.txt"
fun main(){

    val places = parseInput(INPUT)

    val seatIdList = places.map { it.seatId() }

    //What is the highest seat ID on a boarding pass?
    val highestSeatId = seatIdList.max()
    println("max seatId : $highestSeatId")

    val allSeatList = IntRange(
            seatIdList.min()!!,
            seatIdList.max()!!
    )
    val emptySeat = mutableListOf<Int>()
    allSeatList.forEach{ theoricSeat ->
        val seatAround = seatIdList.find {
            it == theoricSeat
        }
        if (seatAround == null) {emptySeat.add(theoricSeat)}
    }
    println("emptySeat : $emptySeat")

}