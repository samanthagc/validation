package com.brq.mail

class Mail {
    companion object {
        fun mail(mail: String): Boolean {

            val pattern =
                """[a-zA-Z0-9+._%\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\-]{0,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{0,25})+"""
                    .toRegex()

            return when {
                !mail.matches(pattern) -> false
                else -> true
            }
        }
    }
}