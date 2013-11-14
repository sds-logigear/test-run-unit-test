package com.example.simplecalc.test;

import com.example.simplecalc.MainActivity;
import com.example.simplecalc.R;

import android.graphics.Rect;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LayoutTests extends ActivityInstrumentationTestCase2<MainActivity> {

    private Button addValues;
    private Button multiplyValues;
    private View mainLayout;
    private EditText value1;
    private EditText value2;

    public LayoutTests() {
        super("com.example.simplecalc", MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();

        MainActivity mainActivity = getActivity();
        addValues = (Button) mainActivity.findViewById(R.id.addValues);
        multiplyValues = (Button) mainActivity.findViewById(R.id.multiplyValues);
        mainLayout = (View) mainActivity.findViewById(R.id.mainLayout);
        value1 = (EditText) mainActivity.findViewById(R.id.value1);
        value2 = (EditText) mainActivity.findViewById(R.id.value2);

    }

    public void testAddButtonOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);

        int[] viewLocation = new int[2];
        addValues.getLocationOnScreen(viewLocation);

        Rect outRect = new Rect();
        addValues.getDrawingRect(outRect);

        assertTrue("Add button off the right of the screen",
                fullWidth + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);
        assertTrue("Add button off the bottom of the screen",
                fullHeight + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);
    }

    public void testMultiplyButtonOnScreen() {
        int fullWidth = mainLayout.getWidth();
        int fullHeight = mainLayout.getHeight();
        int[] mainLayoutLocation = new int[2];
        mainLayout.getLocationOnScreen(mainLayoutLocation);

        int[] viewLocation = new int[2];
        multiplyValues.getLocationOnScreen(viewLocation);

        Rect outRect = new Rect();
        multiplyValues.getDrawingRect(outRect);

        assertTrue("Multiply button off the right of the screen",
                fullWidth + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);
        assertTrue("Multiply button off the bottom of the screen", fullHeight
                + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);
    }

    public void testTextHintOnEditText() {
        String hint1 = value1.getHint().toString();
        String hint2 = value2.getHint().toString();
        assertEquals("input number integer", hint1);
        assertEquals("input number integer", hint2);
    }

}
