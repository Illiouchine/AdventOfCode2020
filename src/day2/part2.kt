package day2

import java.io.File

fun main() {

    val passwordReport: MutableList<String> = mutableListOf()
    File("src/day2/input.txt.txt").forEachLine {
        passwordReport.add(it)
    }

    class Policy(val charPos: List<Int>, val character: Char)
    class Password(val password: String, val policy: Policy)

    val passwordAndPolicyList: MutableList<Password> = mutableListOf()

    passwordReport.forEach {
        val stringPolicy = it.substringBefore(":")
        val stringCharPos = stringPolicy.substringBefore(" ")
        val stringChar = stringPolicy.substringAfter(" ")
        val charPos: MutableList<Int> = mutableListOf(
                stringCharPos.substringBefore("-").toInt(),
                stringCharPos.substringAfter("-").toInt()
        )
        val policy = Policy(charPos, stringChar[0])
        val stringPassword = it.substringAfter(": ")

        passwordAndPolicyList.add(Password(stringPassword, policy))
    }

    var numberOfValidPassword: Int = 0
    passwordAndPolicyList.forEach { passwordWithPolicy ->
        val password = passwordWithPolicy.password
        val firstPos = passwordWithPolicy.policy.charPos[0]
        val secondPos = passwordWithPolicy.policy.charPos[1]
        val char = passwordWithPolicy.policy.character

        //First pos check
        val firstPosCheck: Boolean = password[firstPos - 1] == char
        // Second pos check
        val secondPosCheck: Boolean = password[secondPos - 1] == char

        // Check if only one pos
        if ((firstPosCheck || secondPosCheck) && (firstPosCheck != secondPosCheck)) {
            numberOfValidPassword++
        }
    }

    println("There is $numberOfValidPassword valid password")

}