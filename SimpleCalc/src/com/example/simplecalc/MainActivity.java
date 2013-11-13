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
                Integer answer = getResultOperation(Operation.ADD);
                result.setText(answer.toString());
        }
    };

    private OnClickListener buttonMultiplyClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
                Integer answer = getResultOperation(Operation.MULTIPLY);
                result.setText(answer.toString());
        }
    };

    /**
     * Gets the result operation.
     * 
     * @param operation the operation such as: add, multiply
     * @return the result operation as {@link Integer}
     */
    private Integer getResultOperation(Operation operation) {
        Integer answer = 0;
        try {
            int val1 = Integer.parseInt(value1.getText().toString());
            int val2 = Integer.parseInt(value2.getText().toString());
            switch (operation) {
            case ADD:
                answer = val1 + val2;
                break;
            case MULTIPLY:
                answer = val1 * val2;
                break;
            default:
                break;
            }
        } catch (NumberFormatException e) {
            Log.e(LOG_TAG, "Failed to add numbers ", e);
        }
        return answer;
    }

}
