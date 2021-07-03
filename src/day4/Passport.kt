package day4

import java.lang.Exception

class Passport(
        var byr: String? = null, //(Birth Year)
        var iyr: String? = null, //(Issue Year)
        var eyr: String? = null, //(Expiration Year)
        var hgt: String? = null, //(Height)
        var hcl: String? = null, //(Hair Color)
        var ecl: String? = null, //(Eye Color)
        var pid: String? = null, //(Passport ID)
        var cid: String? = null //(Country ID)
) {
    fun part1IsValid(): Boolean {
        return byr != null &&
                iyr != null &&
                eyr != null &&
                hgt != null &&
                hcl != null &&
                ecl != null &&
                pid != null
    }

    fun part2IsValid(): Boolean {
        return try {
            mandatoryFieldOk() && fieldValidator()
        }catch (e: Exception){
            println("How ... There is an exception cause:${e.message}")
            false
        }
    }

    private fun fieldValidator(): Boolean {
        return byrValid() && iyrValid() && eyrValid() && hgtValid() && hclValid() && eclValid() && pidValid()
    }

    private fun pidValid(): Boolean {
        try {
            pid?.let {
                return it.length == 9
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun eclValid(): Boolean {
        try {
            ecl?.let {
                return (it == "amb" || it == "blu" || it == "brn" || it == "gry" || it ==  "grn" || it == "hzl" || it == "oth")
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun hclValid(): Boolean {
        try {
            hcl?.let {
                return it.matches(Regex("#[a-f0-9]{6}"))
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun hgtValid(): Boolean {
        try {
            hgt?.let {
                if (it.contains("cm")){
                    val height = it.substringBefore("cm").toInt()
                    return height in 150..193
                }
                if (it.contains("in")){
                    val height = it.substringBefore("in").toInt()
                    return height in 59..76
                }
                return false
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun eyrValid(): Boolean {
        try {
            eyr?.let {
                return it.length == 4 && it.toInt() in 2020..2030
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun iyrValid(): Boolean {
        try {
            iyr?.let {
                return it.length == 4 && it.toInt() in 2010..2020
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun byrValid(): Boolean {
        try {
            byr?.let {
                return it.length == 4 && it.toInt() in 1920..2002
            } ?: throw Exception()
        } catch (e: Exception){
            throw Exception()
        }
    }

    private fun mandatoryFieldOk(): Boolean {
        return part1IsValid()
    }




}