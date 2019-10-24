package com.brq.federalregistrations

class FederalRegistrations {
    companion object {

        private val onlyNumbers = "\\d+".toRegex()
        private val butNumbers = "\\D+".toRegex()
        private lateinit var registration: String

        fun valid(registration: String): Boolean {

            if (registration == "") return false

            this.registration = cleanRegistration(registration)

            if (this.registration.matches(butNumbers)) return false

            return when {
                !this.registration.matches(onlyNumbers) -> false
                this.registration.length == 11 -> cpf(this.registration)
                this.registration.length == 14 -> cnpj(this.registration)
                else -> false
            }

        }

        private fun cleanRegistration(registration: String): String {
            return registration.replace(".", "")
                .replace("/", "")
                .replace("-", "")
        }

        private fun cpf(cpf: String): Boolean {

            var soma = 0
            var resto = 0

            if (cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" ||
                cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" ||
                cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" ||
                cpf == "99999999999") return false

            cpf.forEachIndexed { i, it ->
                if (i <= 8) {
                    soma += it.toString().toInt() * (10 - i)
                    resto = (soma * 10) % 11
                }
            }

            if (resto == 10 || resto == 11) resto = 0

            if (resto != cpf[9].toString().toInt()) return false

            soma = 0
            resto = 0

            cpf.forEachIndexed { i, it ->
                if (i <= 9) {
                    soma += it.toString().toInt() * (11 - i)
                    resto = (soma * 10) % 11
                }
            }
            if (resto == 10 || resto == 11) resto = 0

            if (resto != cpf[10].toString().toInt()) return false

            return true
        }

        private fun cnpj(cnpj: String): Boolean {

            if (cnpj == "00000000000000" || cnpj == "11111111111111" || cnpj == "22222222222222" ||
                cnpj == "33333333333333" || cnpj == "44444444444444" || cnpj == "55555555555555" ||
                cnpj == "66666666666666" || cnpj == "77777777777777" || cnpj == "88888888888888" ||
                cnpj == "99999999999999"
            ) return false

            val digits = charArrayOf(cnpj[12], cnpj[13])
            var sum = 0
            var rest: Int
            var pos = 2

            var inverted = StringBuilder(cnpj.substring(0, 12)).reverse()

            inverted.forEachIndexed { i, _ ->
                if (i < 12) {
                    if (pos > 9) pos = 2
                    sum += inverted[i].toString().toInt() * pos
                    pos++
                }
            }

            rest = sum % 11

            if (rest == 0 || rest == 1 && digits[0].toString().toInt() != 0) return false
            else if (digits[0].toString().toInt() != (11 - rest)) return false

            inverted = StringBuilder(cnpj.substring(0, 13)).reverse()
            sum = 0
            pos = 2

            inverted.forEachIndexed { i, _ ->
                if (i < 13) {
                    if (pos > 9) pos = 2
                    sum += inverted[i].toString().toInt() * pos
                    pos++
                }
            }

            rest = sum % 11

            if (rest == 0 || rest == 1 && digits[0].toString().toInt() != 0) return false
            else if (digits[1].toString().toInt() != (11 - rest)) return false

            return true
        }

    }
}