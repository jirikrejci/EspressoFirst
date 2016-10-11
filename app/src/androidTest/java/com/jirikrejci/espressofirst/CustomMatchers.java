package com.jirikrejci.espressofirst;

import android.view.View;
import android.widget.EditText;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Jirka on 11.10.2016.
 */

public class CustomMatchers {
    public static Matcher<View> withError(final String expected) {
        return new TypeSafeMatcher<View>() {


            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof EditText)) {
                    return false;
                }
                EditText editText = (EditText) view;
                return editText.getError().toString().equals(expected);
            }

            /**
             * Generates a description of the object.  The description may be part of a
             * a description of a larger object of which this is just a component, so it
             * should be worded appropriately.
             *
             * @param description The description to be built or appended to.
             */
            @Override
            public void describeTo(org.hamcrest.Description description) {

            }

        };
    }
}
