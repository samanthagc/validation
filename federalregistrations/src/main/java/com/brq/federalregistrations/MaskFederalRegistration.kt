package com.brq.federalregistrations

import android.text.TextWatcher
import android.widget.EditText
import com.brq.mask.NumericalMask.Companion.mask

class MaskFederalRegistration {
    companion object {

        fun cnpj(ediTxt: EditText): TextWatcher {
            return mask("##.###.###/####-##", ediTxt)
        }

        fun cpf(ediTxt: EditText): TextWatcher {
            return mask("###.###.###-##", ediTxt)
        }

    }
}