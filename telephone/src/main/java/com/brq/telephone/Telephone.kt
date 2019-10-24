package com.brq.telephone

class Telephone {
    companion object {

        private val onlyNumbers = "\\d+".toRegex()
        private val butNumbers = "\\D+".toRegex()
        private lateinit var phone: String

        fun cellPhone(phone: String): Boolean {

            if(phone == "") return false

            this.phone = cleanPhone(phone)

            if (this.phone.matches(butNumbers)) return false

            val triple = validPhone(this.phone)
            val number = triple.first
            val arrayDDD = triple.second
            val ddd = triple.third

            return when {
                !this.phone.matches(onlyNumbers) -> false
                number.length != 11 -> false
                !arrayDDD.contains(ddd.toInt()) -> false
                number[2] != '9' -> false
                else -> true
            }
        }

        fun commercialPhone(phone: String): Boolean {

            if(phone == "") return false

            this.phone = cleanPhone(phone)

            if (this.phone.matches(butNumbers)) return false

            val triple = validPhone(this.phone)
            val number = triple.first
            val arrayDDD = triple.second
            val ddd = triple.third

            return when {
                !this.phone.matches(onlyNumbers) -> false
                number.length != 10 -> false
                !arrayDDD.contains(ddd.toInt()) -> false
                number[2] != '2' && number[2] != '3' && number[2] != '4' && number[2] != '5' -> false
                else -> true
            }
        }

        private fun cleanPhone(phone: String): String {
            return phone.replace("(", "")
                .replace(")", "")
                .replace("-", "")
                .replace(" ", "")

        }

        private fun validPhone(phone: String): Triple<String, ArrayList<Int>, String> {

            val foundNumbers = onlyNumbers.findAll(phone).iterator()
            var number = String()
            val arrayDDD = arrayListOf(
                11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 31, 32, 33, 34, 35, 37, 38, 41, 42, 43,
                44, 45, 46, 47, 48, 49, 51, 53, 54, 55, 61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 71, 73, 74, 75,
                77, 79, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 92, 93, 94, 95, 96, 97, 98, 99
            )

            foundNumbers.forEach {
                number += it.value
            }

            if (number[0] == '0') number = number.subSequence(1, number.length).toString()

            val ddd = number[0].toString() + number[1].toString()

            return Triple(number, arrayDDD, ddd)
        }
    }
}