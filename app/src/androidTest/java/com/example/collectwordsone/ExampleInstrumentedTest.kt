package com.example.collectwordsone

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.collectwordsone", appContext.packageName)

        onView(withText("Type a word")).check(matches(isDisplayed()))

        onView(withId(R.id.editText_word)).perform(typeText("Anders"))
        closeSoftKeyboard()
        onView(withId(R.id.button_save)).perform(click())
        onView(withId(R.id.button_show)).perform(click())
        onView(withId(R.id.textView_message)).check(matches(withText(("[Anders]"))))

        onView(withId(R.id.editText_word)).perform(clearText())
        onView(withId(R.id.editText_word)).perform(typeText("Peter"))
        closeSoftKeyboard()
        onView(withId(R.id.button_save)).perform(click())
        onView(withId(R.id.button_show)).perform(click())
        onView(withId(R.id.textView_message)).check(matches(withText(("[Anders, Peter]"))))

        onView(withId(R.id.button_clear)).perform(click())
        onView(withId(R.id.button_show)).perform(click())
        onView(withId(R.id.textView_message)).check(matches(withText("empty")))
    }
}