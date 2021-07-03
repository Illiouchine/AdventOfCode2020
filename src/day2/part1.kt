package day2

import java.io.File

fun main() {

    val passwordReport : MutableList<String> = mutableListOf()
    File("src/day2/input.txt.txt").forEachLine {
        passwordReport.add(it)
    }

    class Policy(val range: IntRange, val character: Char)
    class Password(val password: String, val policy: Policy)
    val passwordAndPolicyList : MutableList<Password> = mutableListOf()

    passwordReport.forEach {
        val stringPolicy = it.substringBefore(":")
        val stringRange = stringPolicy.substringBefore(" ")
        val stringChar = stringPolicy.substringAfter(" ")
        val range = IntRange(
                stringRange.substringBefore("-").toInt(),
                stringRange.substringAfter("-").toInt()
        )
        val policy = Policy(range, stringChar[0])
        val stringPassword = it.substringAfter(": ")

        passwordAndPolicyList.add(Password(stringPassword, policy))
    }

    var numberOfValidPassword : Int = 0
    passwordAndPolicyList.forEach { passwordWithPolicy ->
        val numberOfChar = passwordWithPolicy.password.count {
            passwordWithPolicy.policy.character == it
        }
        if (numberOfChar in passwordWithPolicy.policy.range){
            numberOfValidPassword++
        }
    }

    println("There is $numberOfValidPassword valid password")

}