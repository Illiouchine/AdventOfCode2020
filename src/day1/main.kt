package day1

import java.io.File

fun main(){

    val expenseReport : MutableList<Int> = mutableListOf()
    File("src/day1/expenseReport.txt").forEachLine {
        expenseReport.add(it.toInt())
    }

    println("------- Day 1, Part 1 ------")
    var out = false
    expenseReport.forEach { i ->
        if (out) {return@forEach}
        expenseReport.forEach { a ->
            if(i + a == 2020){
                println("i : $i , a : $a ------- i+a : ${(i+a)} ----- i*a : ${(i*a)}")
                out = true
                return@forEach
            }
        }
    }

    println("------- Day 1, Part 2 ------")
    var out2 = false
    expenseReport.forEach { a ->
        if (out2) {return@forEach}
        expenseReport.forEach { b ->
            if (out2) {return@forEach}
            expenseReport.forEach { c ->
                if(a+b+c == 2020){
                    println("a: $a , b: $b, c: $c  ------- a+b+c : ${(a+b+c)} ----- a*b*c : ${(a*b*c)}")
                    out2 = true
                    return@forEach
                }
            }
        }
    }
    if (!out2) { println("No result") }
}