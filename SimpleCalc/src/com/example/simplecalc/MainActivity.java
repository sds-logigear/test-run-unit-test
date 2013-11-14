package com.example.simplecalc;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static String LOG_TAG = "MainScreen";
    private EditText value1;
    private EditText value2;
    private TextView result;

    public static enum Operation {
        ADD, MULTIPLY
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value1 = (EditText) findViewById(R.id.value1);
        value2 = (EditText) findViewById(R.id.value2);
        result = (TextView) findViewById(R.id.result);
        Button addButton = (Button) findViewById(R.id.addValues);
        addButton.setOnClickListener(buttonAddClick);
        Button multiplyButton = (Button) findViewById(R.id.multiplyValues);
        multiplyButton.setOnClickListener(buttonMultiplyClick);
    }

    private OnClickListener buttonAddClick = new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            String answer = getResultOperation(Operation.ADD);
            result.setText(answer.toString());
        }
    };

    private OnClickListener buttonMultiplyClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String answer = getResultOperation(Operation.MULTIPLY);
            result.setText(answer);
        }
    };

    /**
     * Gets the result operation.
     * 
     * @param operation the operation such as: add, multiply
     * @return the result operation as {@link Integer}
     */
    private String getResultOperation(Operation operation) {
        String result = null;
        float answer = 0;
        try {
            int val1 = Integer.parseInt(value1.getText().toString());
            int val2 = Integer.parseInt(value2.getText().toString());
            switch (operation) {
            case ADD:
                answer = (float) val1 + (float) val2;
                break;
            case MULTIPLY:
                answer = (float) val1 * (float) val2;
                break;
            default:
                break;
            }
            if (Integer.MIN_VALUE < answer && answer < (float) Integer.MAX_VALUE) {
                result = String.valueOf((int) answer);
            } else {
                result = String
                        .format("The result must to greater than %s and less than %s. Please check your input number",
                                Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } catch (NumberFormatException e) {
            result = String
                    .format("The input numbers must to greater than %s and less than %s. Please check your input number",
                            Integer.MIN_VALUE, Integer.MAX_VALUE);
            Log.e(LOG_TAG, "Failed to add numbers ", e);
        }
        return result;
    }

}
