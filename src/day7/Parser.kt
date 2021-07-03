package day7

import java.io.File

internal class Parser{

    operator fun invoke(filePath: String) : List<Rule> {
        println("---- Parsing -----")
        val map: MutableList<String> = mutableListOf()
        val file = File(filePath)
        file.forEachLine {
            map.add(it)
        }

        val rules: MutableList<Rule> = mutableListOf()
        map.forEach {
            if (it.isNotEmpty()){
                val regex = Regex("(?:([a-z]+ [a-z]+) bags contain )(?:(?:no other bags.)|(?:([1-9]*) ([a-z]+ [a-z]+) bag[s]*[,.](?: ([0-9]) ([a-z]+ [a-z]+))*))")
                val match = regex.find(it)!!

                val containerColor = match.groupValues[1]
                val number = if (match.groupValues[2].isNotEmpty())  match.groupValues[2] else null
                val numberColor = match.groupValues[3]
                val number2 = if (match.groupValues[4].isNotEmpty())  match.groupValues[4] else null
                val numberColor2 = match.groupValues[5]

                val containerRule = mutableListOf<ContainerRule>()
                if (number != null){
                    containerRule.add(ContainerRule(number.toInt(), numberColor))
                }
                if (number2 != null){
                    containerRule.add(ContainerRule(number2.toInt(), numberColor2))
                }

                val rule = Rule(
                        color = containerColor,
                        colors = containerRule
                )

                rules.add(rule)
            }
        }
        println("---- End Of Parsing -----")
        return rules.toList()
    }

}