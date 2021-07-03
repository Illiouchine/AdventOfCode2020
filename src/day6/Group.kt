package day6

class Group(
        val result: MutableList<PersonalResult> = mutableListOf()
) {

    fun countDistinctResult(): Int {
        val mutableListOfChar: MutableList<Char> = mutableListOf()
        result.map {
            it.toCharList()
        }.forEach { charList ->
            charList.forEach { char ->
                mutableListOfChar.add(char)
            }
        }
        return mutableListOfChar.distinct().count()
    }

    fun countAllRespondYes(): Int {
        val reference = mutableListOf<Char>()
        reference.addAll(result.first().toCharList())
        val accu = mutableListOf<Char>()
        accu.addAll(result.first().toCharList())

        result.map { it.toCharList() }
                .forEach {
                    reference.clear()
                    reference.addAll(accu.intersect(it))
                    accu.clear()
                    accu.addAll(reference)
                }
        return  reference.count()
    }


}