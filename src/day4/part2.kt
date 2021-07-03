package day4

fun main() {

    val passportList = parseInput(INPUT)

    println("--- Password check ---")
    val validPassPortCount = passportList.filter {
        it.part2IsValid()
    }.count()

    // Wrong 160 - 161

    println("Valid passport count: $validPassPortCount")
}