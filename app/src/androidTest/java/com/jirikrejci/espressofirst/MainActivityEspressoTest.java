package com.jirikrejci.espressofirst;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    private static final String TAG = "TESTS";


    String getResourceString (int rID) {
        return mActivityRule.getActivity().getResources().getString(rID);
    }


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testErrorInEditView1 () {
        onView(withId(R.id.btnSetError)).perform(click());
        onView(withId(R.id.inputField)).check(matches(CustomMatchers.withError("Toto je chyba")));
        System.out.println("Konec testu");
    }

    // next test shall not pass
    @Test
    public void testErrorInEditView2 () {
        onView(withId(R.id.btnSetError)).perform(click());
        onView(withId(R.id.inputField)).check(matches(CustomMatchers.withError("Toto je chyba 2")));
        System.out.println("Konec testu");
    }


    @Test
    public void testErrorInEditView3 () {
        onView(withId(R.id.btnSetError)).perform(click());
        onView(withId(R.id.inputField)).check(matches(CustomMatchers.withError(getResourceString(R.string.err_input_value))));
        System.out.println("Konec testu");
        Log.d(TAG, "testErrorInEditView3: konec testu");

    }


    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.inputField))
                .perform(typeText("HELLO"), closeSoftKeyboard());
        onView(withId(R.id.changeText)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.inputField)).perform(typeText("NewText"),
                closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
    }






}
