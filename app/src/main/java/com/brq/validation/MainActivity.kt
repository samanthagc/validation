package com.brq.validation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.brq.mail.Mail
import com.brq.telephone.MaskPhone
import com.brq.telephone.Telephone
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("LOKOKOKOKOKO", "${Mail.validate("lala")}")
        Log.e("GRAUAUAUAUAU", "${Mail.validate("l@h.j")}")
        Log.e("testeRafael", "${Telephone.commercialPhone("11111")}")


        edCellPhone.addTextChangedListener(MaskPhone.cellPhone(edCellPhone))
        edCommercialPhone.addTextChangedListener(MaskPhone.commercialPhone(edCommercialPhone))
    }
}
