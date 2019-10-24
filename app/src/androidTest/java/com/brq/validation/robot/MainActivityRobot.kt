package com.brq.validation.robot

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.brq.validation.R

class MainActivityRobot {

    /**
     * cell phone methods
     */
    fun setCellPhoneValid(){
        onView(ViewMatchers.withId(R.id.edCellPhone))
            .perform(ViewActions.typeText("11999999999"))
    }

    fun setTextOnCellPhoneField(){
        onView(ViewMatchers.withId(R.id.edCellPhone))
            .perform(ViewActions.typeText("Test"))
    }

    fun setOverCellPhoneSize(){
        onView(ViewMatchers.withId(R.id.edCellPhone))
            .perform(ViewActions.typeText("119999999998"))
    }

    fun showCellPhoneMask(){
        onView(ViewMatchers.withId(R.id.edCellPhone))
            .check(ViewAssertions.matches(withText("(11) 99999-9999")))
    }
    fun showBlankCellPhoneField(){
        onView(ViewMatchers.withId(R.id.edCellPhone))
            .check(ViewAssertions.matches(withText("")))
    }

    /**
     * commercial phone methods
     */
    fun setCommercialPhoneValid(){
        onView(ViewMatchers.withId(R.id.edCommercialPhone))
            .perform(ViewActions.typeText("1133333333"))
    }

    fun setTextOnCommercialPhoneField(){
        onView(ViewMatchers.withId(R.id.edCommercialPhone))
            .perform(ViewActions.typeText("Test"))
    }

    fun setOverCommercialPhoneSize(){
        onView(ViewMatchers.withId(R.id.edCommercialPhone))
            .perform(ViewActions.typeText("11333333334"))
    }

    fun showCommercialPhoneMask(){
        onView(ViewMatchers.withId(R.id.edCommercialPhone))
            .check(ViewAssertions.matches(withText("(11) 3333-3333")))
    }

    fun showBlankCommercialPhoneField(){
        onView(ViewMatchers.withId(R.id.edCommercialPhone))
            .check(ViewAssertions.matches(withText("")))
    }


    /**
     * cpf methods
     */
    fun setCPFValid(){
        onView(ViewMatchers.withId(R.id.edCPF))
            .perform(ViewActions.typeText("52998224725"))
    }

    fun setTextOnCPFField(){
        onView(ViewMatchers.withId(R.id.edCPF))
            .perform(ViewActions.typeText("Test"))
    }

    fun setOverCPFSize(){
        onView(ViewMatchers.withId(R.id.edCPF))
            .perform(ViewActions.typeText("529982247255"))
    }

    fun showCPFMask(){
        onView(ViewMatchers.withId(R.id.edCPF))
            .check(ViewAssertions.matches(withText("529.982.247-25")))
    }

    fun showBlankCPFField(){
        onView(ViewMatchers.withId(R.id.edCPF))
            .check(ViewAssertions.matches(withText("")))
    }


    /**
     * cnpj methods
     */
    fun setCNPJValid(){
        onView(ViewMatchers.withId(R.id.edCNPJ))
            .perform(ViewActions.typeText("14572457000185"))
    }

    fun setTextOnCNPJField(){
        onView(ViewMatchers.withId(R.id.edCNPJ))
            .perform(ViewActions.typeText("Test"))
    }

    fun setOverCNPJSize(){
        onView(ViewMatchers.withId(R.id.edCNPJ))
            .perform(ViewActions.typeText("145724570001855"))
    }

    fun showCNPJMask(){
        onView(ViewMatchers.withId(R.id.edCNPJ))
            .check(ViewAssertions.matches(withText("14.572.457/0001-85")))
    }

    fun showBlankCNPJField(){
        onView(ViewMatchers.withId(R.id.edCNPJ))
            .check(ViewAssertions.matches(withText("")))
    }

}