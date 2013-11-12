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
    private static final String NUMBER_5_DOT_5 = "5 PERIOD 8 ENTER ";
    private static final String NUMBER_NEG_22 = "MINUS 2 2 ENTER ";
    private static final String NUMBER_0 = "0 ENTER ";

    private static final String ADD_RESULT = "98.0";
    private static final String ADD_NEGATIVE_RESULT = "52.0";
    private static final String ADD_DECIMAL_RESULT = "79.8";
    private static final String MULTIPLY_RESULT = "1776.0";
    private static final String MULTIPLY_DECIMAL_RESULT = "429.2";
    private static final String MULTIPLY_NEGATIVE_RESULT = "-1628.0";
    private static final String MULTIPLY_ZERO_RESULT = "0.0";

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
        compareValue(ADD_RESULT, mathResult);
    }

    public void testAddDecimalValues() {
        sendKeys(NUMBER_5_DOT_5 + NUMBER_74 + "ENTER");
        String mathResult = result.getText().toString();
        compareValue(ADD_DECIMAL_RESULT, mathResult);
    }

    public void testAddSubtractValues() {
        sendKeys(NUMBER_NEG_22 + NUMBER_74 + "ENTER");
        String mathResult = result.getText().toString();
        compareValue(ADD_NEGATIVE_RESULT, mathResult);
    }

    public void testMultiplyValues() {
        sendKeys(NUMBER_24 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        compareValue(MULTIPLY_RESULT, mathResult);
    }

    public void testMultiplyDecimalValues() {
        sendKeys(NUMBER_5_DOT_5 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        compareValue(MULTIPLY_DECIMAL_RESULT, mathResult);
    }

    public void testMultiplySubtractValues() {
        sendKeys(NUMBER_NEG_22 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        compareValue(MULTIPLY_NEGATIVE_RESULT, mathResult);
    }

    public void testMultiptyZeroValues() {
        sendKeys(NUMBER_0 + NUMBER_74 + " DPAD_RIGHT ENTER");
        String mathResult = result.getText().toString();
        compareValue(MULTIPLY_ZERO_RESULT, mathResult);
    }

    private void compareValue(String expectedValue, String actualValue) {
        assertTrue("Add result should be " + expectedValue + " but was " + actualValue,
                actualValue.equals(expectedValue));
    }
}