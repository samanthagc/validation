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

}