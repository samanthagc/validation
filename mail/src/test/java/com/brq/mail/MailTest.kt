package com.brq.mail

import org.junit.Assert
import org.junit.Test

class MailTest {

    @Test
    fun validMail(){
        val test = "validate@sample.com"
        Assert.assertEquals(true, Mail.validate(test))
    }

    @Test
    fun missingDotOnMail() {
        val test = "validate@samplecom"
        Assert.assertEquals(false, Mail.validate(test))
    }

    @Test
    fun missingAtOnMail() {
        val test = "mailsample.com"
        Assert.assertEquals(false, Mail.validate(test))
    }

    @Test
    fun spaceOnMail() {
        val test = "m ail@sample.com"
        Assert.assertEquals(false, Mail.validate(test))
    }

    @Test
    fun missingTextAfterAtOnMail() {
        val test = "mail@.com"
        Assert.assertEquals(false, Mail.validate(test))
    }

    @Test
    fun missingTextAfterDotOnMail() {
        val test = "mail@sample."
        Assert.assertEquals(false, Mail.validate(test))
    }

    @Test
    fun missingTextBeforeAtOnMail(){
        val test = "@sample.com"
        Assert.assertEquals(false, Mail.validate(test))
    }

    @Test
    fun blankMail(){
        val test = ""
        Assert.assertEquals(false, Mail.validate(test))
    }

}