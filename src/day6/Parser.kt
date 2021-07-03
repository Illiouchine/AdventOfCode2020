package day6

import java.io.File

internal class Parser{

    operator fun invoke(filePath: String) : List<Group> {
        println("---- Parsing -----")
        val map: MutableList<String> = mutableListOf()
        File(filePath).forEachLine {
            map.add(it)
        }

        val groupList: MutableList<Group> = mutableListOf()

        var currentGroup: Group = Group()
        map.forEach {
            if (it.isNotEmpty()) {
                currentGroup.result.add(PersonalResult(it))
            }else{
                groupList.add(currentGroup)
                currentGroup = Group()
            }
        }
        println("---- End Of Parsing -----")
        return groupList.toList()
    }

}