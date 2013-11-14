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
    private static final String NUMBER_MAX = "9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 ENTER ";
    private static final String NUMBER_MAX_INTEGER = "2 1 4 7 4 8 3 6 4 7 ENTER ";
    private static final String NUMBER_MIN_INTEGER = "MINUS 2 1 4 7 4 8 3 6 4 8 ENTER ";

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
        pressAddButton();
        // get result
        String mathResult = result.getText().toString();
        assertValue(ADD_RESULT, mathResult);
    }

    public void testAddSubtractValues() {
        sendKeys(NUMBER_NEG_22);
        sendKeys(NUMBER_74);
        pressAddButton();
        String mathResult = result.getText().toString();
        assertValue(ADD_NEGATIVE_RESULT, mathResult);
    }

    public void testAddMaxNumbers() {
        sendKeys(NUMBER_MAX);
        sendKeys(NUMBER_MAX);
        pressAddButton();
        String mathResult = result.getText().toString();
        String expectedMessage = String
                .format("The input numbers must to greater than %s and less than %s. Please check your input number",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertValue(expectedMessage, mathResult);
    }

    public void testAddResultMaxLength() {
        sendKeys(NUMBER_MAX_INTEGER);
        sendKeys(NUMBER_24);
        pressAddButton();
        String mathResult = result.getText().toString();
        String expectedMessage = String
                .format("The result must to greater than %s and less than %s. Please check your input number",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertValue(expectedMessage, mathResult);
    }

    public void testAddResulMinLength() {
        sendKeys(NUMBER_MIN_INTEGER);
        sendKeys(NUMBER_NEG_22);
        pressAddButton();
        String mathResult = result.getText().toString();
        String expectedMessage = String
                .format("The result must to greater than %s and less than %s. Please check your input number",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertValue(expectedMessage, mathResult);
    }

    public void testMultiplyValues() {
        sendKeys(NUMBER_24);
        sendKeys(NUMBER_74);
        pressMultiplyButton();
        String mathResult = result.getText().toString();
        assertValue(MULTIPLY_RESULT, mathResult);
    }

    public void testMultiplySubtractValues() {
        sendKeys(NUMBER_NEG_22);
        sendKeys(NUMBER_74);
        pressMultiplyButton();
        String mathResult = result.getText().toString();
        assertValue(MULTIPLY_NEGATIVE_RESULT, mathResult);
    }

    public void testMultiplyZeroValues() {
        sendKeys(NUMBER_0);
        sendKeys(NUMBER_74);
        pressMultiplyButton();
        String mathResult = result.getText().toString();
        assertValue(MULTIPLY_ZERO_RESULT, mathResult);
    }

    public void testMultiplyMaxNumbers() {
        sendKeys(NUMBER_MAX);
        sendKeys(NUMBER_MAX);
        pressMultiplyButton();
        String mathResult = result.getText().toString();
        String expectedMessage = String
                .format("The input numbers must to greater than %s and less than %s. Please check your input number",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertValue(expectedMessage, mathResult);
    }

    private void assertValue(String expectedValue, String actualValue) {
        assertTrue("Add result should be " + expectedValue + " but was " + actualValue,
                actualValue.equals(expectedValue));
    }

    private void pressAddButton() {
        sendKeys("DPAD_LEFT ENTER");
    }

    private void pressMultiplyButton() {
        sendKeys("DPAD_RIGHT ENTER");
    }
}