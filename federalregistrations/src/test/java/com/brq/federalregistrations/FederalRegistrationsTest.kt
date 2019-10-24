package com.brq.federalregistrations

import org.junit.Assert
import org.junit.Test

class FederalRegistrationsTest {

    /**
     * CPF tests
     */
    @Test
    fun validCPF(){
        val cpf = "529.982.247-25"
        Assert.assertEquals(true, FederalRegistrations.valid(cpf))
    }

    @Test
    fun repetitiveCPF(){
        val cpf = "111.111.111-11"
        Assert.assertEquals(false, FederalRegistrations.valid(cpf))
    }

    @Test
    fun invalidCPFFirstDigit(){
        val cpf = "52998224775"
        Assert.assertEquals(false, FederalRegistrations.valid(cpf))
    }

    @Test
    fun invalidCPFSecondDigit(){
        val cpf = "529.982.247-27"
        Assert.assertEquals(false, FederalRegistrations.valid(cpf))
    }

    /**
     * CNPJ tests
     */
    @Test
    fun validCNPJ(){
        val cnpj = "14.572.457/0001-85"
        Assert.assertEquals(true, FederalRegistrations.valid(cnpj))
    }

    @Test
    fun repetitiveCNPJ(){
        val cnpj = "77.777.777/7777-77"
        Assert.assertEquals(false, FederalRegistrations.valid(cnpj))
    }

    @Test
    fun invalidCNPJFirstDigit(){
        val cnpj = "14572457000175"
        Assert.assertEquals(false, FederalRegistrations.valid(cnpj))
    }

    @Test
    fun invalidCNPJSecondDigit(){
        val cnpj = "14.572.457/0001-87"
        Assert.assertEquals(false, FederalRegistrations.valid(cnpj))
    }

    /**
     * Shared tests
     */
    @Test
    fun blankFederalRegistration(){
        val federalRegistration = ""
        Assert.assertEquals(false, FederalRegistrations.valid(federalRegistration))
    }

    @Test
    fun onlyCharacterFederalRegistration(){
        val federalRegistration = "Test"
        Assert.assertEquals(false, FederalRegistrations.valid(federalRegistration))
    }

    @Test
    fun invalidFederalRegistrationSize(){
        val federalRegistration = "14572457000178"
        Assert.assertEquals(false, FederalRegistrations.valid(federalRegistration))
    }

    @Test
    fun unexpectedFederalRegistratioCharacters(){
        val cnpj = "CNPJ: 14.572.457/0001-87"
        Assert.assertEquals(false, FederalRegistrations.valid(cnpj))
    }

}