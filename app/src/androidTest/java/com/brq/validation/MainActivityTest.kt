package com.brq.validation

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.brq.validation.robot.MainActivityRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {


    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    fun mask(func: MainActivityRobot.() -> Unit) = MainActivityRobot()
        .apply { func() }

    @Test
    fun validCellPhoneTest(){
        mask {
            setCellPhoneValid()
            showCellPhoneMask()
        }
    }

    @Test
    fun invalidCellPhoneSizeTest(){
        mask {
            setOverCellPhoneSize()
            showCellPhoneMask()
        }
    }

    @Test
    fun wrongTypeInsertOnCellPhoneFieldTest(){
        mask {
            setTextOnCellPhoneField()
            showBlankCellPhoneField()
        }
    }

    @Test
    fun validCommercialPhoneTest(){
        mask {
            setCommercialPhoneValid()
            showCommercialPhoneMask()
        }
    }

    @Test
    fun invalidCommercialPhoneSizeTest(){
        mask{
            setOverCommercialPhoneSize()
            showCommercialPhoneMask()
        }
    }

    @Test
    fun wrongTypeInsertOnCommercialPhoneFieldTest(){
        mask {
            setTextOnCommercialPhoneField()
            showBlankCommercialPhoneField()
        }
    }
}