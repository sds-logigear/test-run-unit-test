package com.example.simplecalc.test;

import com.example.simplecalc.MainActivity;
import com.example.simplecalc.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class MathTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private TextView result;

    public MathTest() {
        super("com.example.simplecalc", MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        MainActivity mainActivity = getActivity();
        result = (TextView) mainActivity.findViewById(R.id.result);

    }

    private static final String NUMBER_24 = "2 4 ENTER ";
    private static final String NUMBER_74 = "7 4 ENTER ";
    private static final String NUMBER_NEG_22 = "MINUS 2 2 ENTER ";
    private static final String NUMBER_0 = "0 ENTER ";

    private static final String ADD_RESULT = "98";
    private static final String ADD_NEGATIVE_RESULT = "52";
    private static final String MULTIPLY_RESULT = "1776";
    private static final String MULTIPLY_NEGATIVE_RESULT = "-1628";
    private static final String MULTIPLY_ZERO_RESULT = "0";

    public void testAddValues() {
        // we use sendKeys instead of setText so it goes through entry
        // validation
        sendKeys(NUMBER_24);
        // now on value2 entry
        sendKeys(NUMBER_74);
        // now on Add button
        sendKeys("ENTER");
        // get result
        String mathResult = result.getText().toString();
        assertValue(ADD_RESULT, mathResult);
    }

    public void testAddSubtractValues() {
        sendKeys(NUMBER_NEG_22 + NUMBER_74 + "ENTER");
        String mathResult = result.getText().toString();
        assertValue(ADD_NEGATIVE_RESULT, mathResult);
    }

    public void testMultiplyValues() {
        sendKeys(NUMBER_24 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        assertValue(MULTIPLY_RESULT, mathResult);
    }

    public void testMultiplySubtractValues() {
        sendKeys(NUMBER_NEG_22 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        assertValue(MULTIPLY_NEGATIVE_RESULT, mathResult);
    }

    public void testMultiplyZeroValues() {
        sendKeys(NUMBER_0 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        assertValue(MULTIPLY_ZERO_RESULT, mathResult);
    }

    private void assertValue(String expectedValue, String actualValue) {
        assertTrue("Add result should be " + expectedValue + " but was " + actualValue,
                actualValue.equals(expectedValue));
    }
}