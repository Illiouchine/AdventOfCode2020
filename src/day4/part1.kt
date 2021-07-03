package day4

import java.io.File

const val TEST_INPUT = "src/day4/test_input.txt"
const val INPUT = "src/day4/input.txt"

fun main() {

    val passportList = parseInput(INPUT)

    val validPassPortCount = passportList.filter {
        it.part1IsValid()
    }.count()

    println("Valid passport count: $validPassPortCount")
}

internal fun parseInput(filePath: String): List<Passport> {

    println("---- Parsing -----")
    val map: MutableList<String> = mutableListOf()
    File(filePath).forEachLine {
        map.add(it)
    }

    val passportList: MutableList<Passport> = mutableListOf()
    var currentPassport: Passport = Passport()
    map.forEach {
        if (it.isEmpty()) {
            // End of password
            println("New Passport")
            passportList.add(currentPassport)
            currentPassport = Passport()
        } else {
            val keyValues = it.split(" ")
            keyValues.forEach { keyvalue ->
                // Parse line
                val key = keyvalue.substringBefore(":")
                val value = keyvalue.substringAfter(":")
                println("key: $key, value: $value")
                when (key) {
                    "byr" -> {
                        currentPassport.byr = value
                    }
                    "iyr" -> {
                        currentPassport.iyr = value
                    }
                    "eyr" -> {
                        currentPassport.eyr = value
                    }
                    "hgt" -> {
                        currentPassport.hgt = value
                    }
                    "hcl" -> {
                        currentPassport.hcl = value
                    }
                    "ecl" -> {
                        currentPassport.ecl = value
                    }
                    "pid" -> {
                        currentPassport.pid = value
                    }
                    "cid" -> {
                        currentPassport.cid = value
                    }
                }

            }
        }
    }
    println("---- End Of -----")
    return passportList.toList()
}

