package day6

// First letter F -> 0..63, B 64-> 127
const val INPUT = "src/day6/input.txt"
const val TEST_INPUT = "src/day6/testinput.txt"
fun main(){

    val groupList = Parser()(INPUT)

    println(" Part 1 ")
    println(" For each group, count the number of questions to which anyone answered \"yes\". What is the sum of those counts? ")
    // CountDistinctResult
    var countResult : Int = 0
    groupList.forEach {
        countResult += it.countDistinctResult()
    }
    println(" Count: $countResult ")
    // Wrong result 11976 : too high

    println("Part 2")
    println("For each group, count the number of questions to which everyone answered \"yes\". What is the sum of those counts?")
    var countEveryone : Int = 0
    groupList.forEach {
        countEveryone += it.countAllRespondYes()
    }
    println(" Count: $countEveryone ")
    // 3681 to hight
    // 3585

}