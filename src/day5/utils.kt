package day5

import java.io.File

internal fun parseInput(filePath: String): List<Place> {

    println("---- Parsing -----")
    val map: MutableList<String> = mutableListOf()
    File(filePath).forEachLine {
        map.add(it)
    }

    val placeList: MutableList<Place> = mutableListOf()
    map.forEach {
        if (it.isNotEmpty()) {
            placeList.add(
                    Place(it)
            )
        }
    }
    println("---- End Of Parsing -----")
    return placeList.toList()
}
