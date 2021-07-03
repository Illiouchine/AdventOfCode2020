package day3

import java.io.File

fun main(){

    val map : MutableList<String> = mutableListOf()
    File("src/day3/input.txt.txt").forEachLine {
        map.add(it)
    }

    // pattern : right 3, down 1 = result 167
    //Right 1, down 1.
    val r1d1 = Toboggan(map).run(1, 1)
    println("r1d1 = $r1d1")
    //Right 3, down 1. (This is the slope you already checked.)
    val r3d1 = Toboggan(map).run(3, 1)
    println("r3d1 = $r3d1")
    //Right 5, down 1.
    val r5d1 = Toboggan(map).run(5, 1)
    println("r5d1 = $r5d1")
    //Right 7, down 1.
    val r7d1 = Toboggan(map).run(7, 1)
    println("r7d1 = $r7d1")
    //Right 1, down 2.
    val r1d2 = Toboggan(map).run(1, 2)
    println("r1d2 = $r1d2")

    println("Total = ${r1d1*r3d1*r5d1*r7d1*r1d2}")
}

class Toboggan(
        private val map:List<String>
){
    var hPos = 0
    fun run(right:Int, down: Int): Int{
        return map.filterIndexed { index, _ ->
            index%down == 0
        }.map { s ->
            if (hPos >= s.length) {
                hPos-= s.length
            }
            s[hPos].also {
                hPos += right
            }
        }.filter {
            it == '#'
        }.count()
    }
}