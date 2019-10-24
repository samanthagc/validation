package com.brq.telephone

import org.junit.Assert
import org.junit.Test

class TelephoneTest {

    @Test
    fun invalidCellPhoneDDD(){
        val phone = "10998761234"
        Assert.assertEquals(false, Telephone.cellPhone(phone))
    }

    @Test
    fun invalidCellPhoneSize(){
        val phone = "1199345672"
        Assert.assertEquals(false, Telephone.cellPhone(phone))
    }

    @Test
    fun invalidCellPhoneFormat(){
        val phone = "numero 11966782435"
        Assert.assertEquals(false, Telephone.cellPhone(phone))
    }

    @Test
    fun onlyCharacterCellPhone(){
        val phone = "Test"
        Assert.assertEquals(false, Telephone.cellPhone(phone))
    }

    @Test
    fun invalidBeginOfCellPhone(){
        val phone = "11786543214"
        Assert.assertEquals(false, Telephone.cellPhone(phone))
    }

    @Test
    fun blankCellPhone(){
        val phone = ""
        Assert.assertEquals(false, Telephone.cellPhone(phone))
    }

    @Test
    fun validCellPhone(){
        val phone = "(021) 97678-8872"
        Assert.assertEquals(true, Telephone.cellPhone(phone))
    }

    @Test
    fun validCommercialPhone(){
        val phone = "(055) 4563-6676"
        Assert.assertEquals(true, Telephone.commercialPhone(phone))
    }

    @Test
    fun blankCommercialPhone(){
        val phone = ""
        Assert.assertEquals(false, Telephone.commercialPhone(phone))
    }

    @Test
    fun onlyCharacterCommercialPhone(){
        val phone = "Test"
        Assert.assertEquals(false, Telephone.commercialPhone(phone))
    }

    @Test
    fun invalidBeginOfCommercialPhone(){
        val phone = "116789904"
        Assert.assertEquals(false, Telephone.commercialPhone(phone))
    }

    @Test
    fun invalidCommercialPhone(){
        val phone = "numero 1135678256"
        Assert.assertEquals(false, Telephone.commercialPhone(phone))
    }

    @Test
    fun invalidCommercialPhoneSize(){
        val phone = "113452167"
        Assert.assertEquals(false, Telephone.commercialPhone(phone))
    }

    @Test
    fun invalidCommercialPhoneDDD(){
        val phone = "1038761234"
        Assert.assertEquals(false, Telephone.commercialPhone(phone))
    }

}