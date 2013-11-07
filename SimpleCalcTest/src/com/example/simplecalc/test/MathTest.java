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
    private static final String NUMBER_5_DOT_5 = "5 PERIOD 5 ENTER ";
    private static final String NUMBER_NEG_22 = "MINUS 2 2 ENTER ";

    private static final String ADD_RESULT = "98";
    private static final String ADD_DECIMAL_RESULT = "79.5";
    private static final String ADD_NEGATIVE_RESULT = "52";
    private static final String MULTIPLY_RESULT = "1776";

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
        assertTrue("Add result should be 98 " + ADD_RESULT + " but was " + mathResult,
                mathResult.equals(ADD_RESULT));
    }

    public void testAddDecimalValues() {
        sendKeys(NUMBER_5_DOT_5 + NUMBER_74 + "ENTER");

        String mathResult = result.getText().toString();
        assertTrue("Add result should be " + ADD_DECIMAL_RESULT + " but was " + mathResult,
                mathResult.equals(ADD_DECIMAL_RESULT));
    }

    public void testSubtractValues() {
        sendKeys(NUMBER_NEG_22 + NUMBER_74 + "ENTER");

        String mathResult = result.getText().toString();
        assertTrue("Add result should be " + ADD_NEGATIVE_RESULT + " but was " + mathResult,
                mathResult.equals(ADD_NEGATIVE_RESULT));
    }

    public void testMultiplyValues() {
        sendKeys(NUMBER_24 + NUMBER_74 + " DPAD_RIGHT ENTER");

        String mathResult = result.getText().toString();
        assertTrue("Multiply result should be " + MULTIPLY_RESULT + " but was " + mathResult,
                mathResult.equals(MULTIPLY_RESULT));
    }

}
