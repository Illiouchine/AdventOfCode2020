package day3

import java.io.File

fun main(){

    val map : MutableList<String> = mutableListOf()
    File("src/day3/input.txt.txt").forEachLine {
        map.add(it)
    }

    // pattern : right 3, down 1
    // Line length = 31
    var hPos = 0
    val trees = map.mapIndexed { index, s ->
        if (hPos >= s.length) {
            hPos-= s.length
        }
        s[hPos].also {
            hPos += 3
        }
    }.filter {
        it == '#'
    }.count()
    println("trees = $trees")

    // Wrong result 64
}