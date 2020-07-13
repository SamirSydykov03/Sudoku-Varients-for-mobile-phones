package com.example.sudokuvarients;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;
import android.widget.Toast;
import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import com.example.sudokuvarients.normalsudoku9x9.NormalSudoku;
import com.example.sudokuvarients.sudokuColour.ColourDoku;
import com.example.sudokuvarients.sudokux16.sudokux16;
import com.example.sudokuvarients.sudokux4.Sudokux4;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;

    Instrumentation.ActivityMonitor monitor1 =
            getInstrumentation().
            addMonitor(Sudokux4.class.getName(),
                    null,false);
    Instrumentation.ActivityMonitor monitor2 =
            getInstrumentation().
            addMonitor(NormalSudoku.class.getName(),
                    null,false);
    Instrumentation.ActivityMonitor monitor3 =
            getInstrumentation().
            addMonitor(sudokux16.class.getName(),
                    null,false);
    Instrumentation.ActivityMonitor monitor4 =
            getInstrumentation().
            addMonitor(ColourDoku.class.getName(),
                    null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){
        View view = mActivity.findViewById(R.id.Greeting_message);
        assertNotNull(view);

    }
    @Test
    public void testLaunchOfActionButtonx4Click(){
        assertNotNull(mActivity.findViewById(R.id.sudokux4));
        onView(withId(R.id.sudokux4)).perform(click());
        Activity Sudokux4 = getInstrumentation().
                waitForMonitorWithTimeout(monitor1,5000);
        assertNotNull(Sudokux4);
        Sudokux4.finish();
    }
    @Test
    public void testLaunchOfActionButtonx9ClickEasy(){
        assertNotNull(mActivity.findViewById(R.id.normalsudoku));
        onView(withId(R.id.normalsudoku)).perform(click());

        onView(withText(R.string.easy_label)).check(matches(isDisplayed()));
        onView(withText(R.string.easy_label)).perform(click());


        Activity NormalSudoku = getInstrumentation().
                waitForMonitorWithTimeout(monitor2,5000);
        assertNotNull(NormalSudoku);
        NormalSudoku.finish();
    }
    @Test
    public void testLaunchOfActionButtonx9ClickMed(){
        assertNotNull(mActivity.findViewById(R.id.normalsudoku));
        onView(withId(R.id.normalsudoku)).perform(click());

        onView(withText(R.string.Med_label)).check(matches(isDisplayed()));
        onView(withText(R.string.Med_label)).perform(click());


        Activity NormalSudoku = getInstrumentation().
                waitForMonitorWithTimeout(monitor2,5000);
        assertNotNull(NormalSudoku);
        NormalSudoku.finish();
    }
    @Test
    public void testLaunchOfActionButtonx9ClickHard(){
        assertNotNull(mActivity.findViewById(R.id.normalsudoku));
        onView(withId(R.id.normalsudoku)).perform(click());

        onView(withText(R.string.Hard_label)).check(matches(isDisplayed()));
        onView(withText(R.string.Hard_label)).perform(click());


        Activity NormalSudoku = getInstrumentation().
                waitForMonitorWithTimeout(monitor2,5000);
        assertNotNull(NormalSudoku);
        NormalSudoku.finish();
    }



    @Test
    public void testLaunchOfColorActionButtonx16Click(){
        assertNotNull(mActivity.findViewById(R.id.sudokux16));
        onView(withId(R.id.sudokux16)).perform(click());

        onView(withText(R.string.Med_label)).check(matches(isDisplayed()));
        onView(withText(R.string.Med_label)).perform(click());

        Activity sudokux16 = getInstrumentation().
                waitForMonitorWithTimeout(monitor3,5000);
        assertNotNull(sudokux16);
        sudokux16.finish();
    }
    @Test
    public void testLaunchOfColorActionButtonx16ClickEasy(){
        assertNotNull(mActivity.findViewById(R.id.sudokux16));
        onView(withId(R.id.sudokux16)).perform(click());

        onView(withText(R.string.easy_label)).check(matches(isDisplayed()));
        onView(withText(R.string.easy_label)).perform(click());

        Activity sudokux16 = getInstrumentation().
                waitForMonitorWithTimeout(monitor3,5000);
        assertNotNull(sudokux16);
        sudokux16.finish();
    }
    @Test
    public void testLaunchOfColorActionButtonx16ClickHard(){
        assertNotNull(mActivity.findViewById(R.id.sudokux16));
        onView(withId(R.id.sudokux16)).perform(click());

        onView(withText(R.string.Hard_label)).check(matches(isDisplayed()));
        onView(withText(R.string.Hard_label)).perform(click());

        Activity sudokux16 = getInstrumentation().
                waitForMonitorWithTimeout(monitor3,5000);
        assertNotNull(sudokux16);
        sudokux16.finish();
    }







    @Test
    public void testLaunchOfColorButtonxColClickhard(){
        assertNotNull(mActivity.findViewById(R.id.sudokuColour));
        onView(withId(R.id.sudokuColour)).perform(click());

        onView(withText(R.string.Hard_label)).check(matches(isDisplayed()));
        onView(withText(R.string.Hard_label)).perform(click());

        Activity ColourDoku = getInstrumentation().
                waitForMonitorWithTimeout(monitor4,5000);


        assertNotNull(ColourDoku);
        ColourDoku.finish();
    }
    @Test
    public void testLaunchOfColorButtonxColClickMed(){
        assertNotNull(mActivity.findViewById(R.id.sudokuColour));
        onView(withId(R.id.sudokuColour)).perform(click());

        onView(withText(R.string.Med_label)).check(matches(isDisplayed()));
        onView(withText(R.string.Med_label)).perform(click());

        Activity ColourDoku = getInstrumentation().
                waitForMonitorWithTimeout(monitor4,5000);

        assertNotNull(ColourDoku);
        ColourDoku.finish();
    }
    @Test
    public void testLaunchOfColorButtonxColClickEasy(){
        assertNotNull(mActivity.findViewById(R.id.sudokuColour));
        onView(withId(R.id.sudokuColour)).perform(click());

        onView(withText(R.string.easy_label)).check(matches(isDisplayed()));
        onView(withText(R.string.easy_label)).perform(click());

        Activity ColourDoku = getInstrumentation().
                waitForMonitorWithTimeout(monitor4,5000);

        assertNotNull(ColourDoku);
        ColourDoku.finish();
    }



    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}