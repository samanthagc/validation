package com.brq.telephone

import android.text.TextWatcher
import android.widget.EditText
import com.brq.mask.NumericalMask.Companion.mask

class MaskPhone {
    companion object {

        fun cellPhone(ediTxt: EditText): TextWatcher {
            return mask("(##) #####-####", ediTxt)
        }


        fun commercialPhone(ediTxt: EditText): TextWatcher {
            return mask("(##) ####-####", ediTxt)
        }
    }
}