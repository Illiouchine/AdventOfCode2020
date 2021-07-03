package day7

const val INPUT = "src/day7/input.txt"
const val TEST_INPUT = "src/day7/testinput.txt"
fun main() {

    val rules = Parser()(INPUT)

    println("Part 1 : How many bag colors can eventually contain at least one shiny gold bag?")

    val ruleList = filterByContainBagOfColorRecursively(rules , "shiny gold")

    println("count : ${
        ruleList
                .map {
                    it.color
                }
                .count()
    }")
    // 216 to low
    // 213 to low
    // 163 to low

}

fun filterByContainBagOfColorRecursively(ruleList:List<Rule> ,color: String): List<Rule> {
    println("color:  $color")
    // Get the rule that contain the given color
    val ruleThatContainGivenColor: MutableList<Rule> = mutableListOf()
    ruleThatContainGivenColor.addAll(ruleList.filterByCanContainBagOfColor(color))
    val totalRules: MutableList<Rule> = ruleThatContainGivenColor.toMutableList()

    do {
        val temp = mutableListOf<Rule>()
        ruleThatContainGivenColor.forEach {
            temp.addAll(
                    ruleList.filterByCanContainBagOfColor(it.color)
            )
        }

        totalRules.addAll(temp)
        ruleThatContainGivenColor.clear()
        ruleThatContainGivenColor.addAll(temp)
    } while (temp.count() > 0)
    return totalRules
}

fun List<Rule>.filterByCanContainBagOfColor(color: String): List<Rule> = this.filter {
    it.colors.any { containerRule ->
        containerRule.color == color
    }
}