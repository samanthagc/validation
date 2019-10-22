package com.brq.telephone

import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.EditText

class MaskPhone {
    companion object {

        /**
         * link mask and unmask functions
         *
         *  https://pt.stackoverflow.com/questions/204788/setando-mascara-campo-telefone-android#comment419350_204792
         *
         */

        private fun unmask(s: String): String {
            return s.replace("[-]".toRegex(), "")
                .replace("[(]".toRegex(), "")
                .replace("[)]".toRegex(), "")
                .replace("[ ]".toRegex(), "")
        }

        private fun mask(mask: String, ediTxt: EditText): TextWatcher {

            ediTxt.inputType = InputType.TYPE_CLASS_NUMBER

            return object : TextWatcher {

                var isUpdating: Boolean = false
                var old = ""

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    val str = unmask(s.toString())
                    var mascara = ""

                    if (isUpdating) {
                        old = str
                        isUpdating = false
                        return
                    }

                    var i = 0

                    for (m in mask.toCharArray()) {
                        if (m != '#' && str.length > old.length) {
                            mascara += m
                            continue
                        }
                        try {
                            mascara += str[i]
                        } catch (e: Exception) {
                            break
                        }

                        i++
                    }

                    isUpdating = true
                    ediTxt.setText(mascara)
                    ediTxt.setSelection(mascara.length)
                }

                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                override fun afterTextChanged(s: Editable) {}
            }
        }


        fun cellPhone(ediTxt: EditText): TextWatcher {

            return mask("(##) #####-####", ediTxt)
        }


        fun commercialPhone(ediTxt: EditText): TextWatcher {

            return mask("(##) ####-####", ediTxt)
        }
    }
}