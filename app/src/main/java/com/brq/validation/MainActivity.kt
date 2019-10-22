package com.brq.validation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.brq.telephone.MaskPhone
import com.brq.telephone.Telephone
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("LOKOKOKOKOKO", "${Telephone.cellPhone("11 991261817")}")
        Log.e("GRAUAUAUAUAU", "${Telephone.commercialPhone("01031261817")}")
        Log.e("testeRafael", "${Telephone.commercialPhone("112235fthrfyuuyedyu1111")}")

        edCellPhone.addTextChangedListener(MaskPhone.cellPhone(edCellPhone))
        edCommercialPhone.addTextChangedListener(MaskPhone.commercialPhone(edCommercialPhone))
    }
}
