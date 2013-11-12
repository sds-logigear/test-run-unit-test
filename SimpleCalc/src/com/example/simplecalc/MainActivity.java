package com.example.simplecalc;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final String LOG_TAG = "MainScreen";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText value1 = (EditText) findViewById(R.id.value1);
        final EditText value2 = (EditText) findViewById(R.id.value2);
        final TextView result = (TextView) findViewById(R.id.result);
        Button addButton = (Button) findViewById(R.id.addValues);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    double val1 = Double.parseDouble(value1.getText().toString());
                    double val2 = Double.parseDouble(value2.getText().toString());
                    Double answer = val1 + val2;
                    result.setText(answer.toString());
                } catch (NumberFormatException e) {
                    Log.e(LOG_TAG, "Failed to add numbers ", e);
                }
            }
        });
        Button multiplyButton = (Button) findViewById(R.id.multiplyValues);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    double val1 = Double.parseDouble(value1.getText().toString());
                    double val2 = Double.parseDouble(value2.getText().toString());
                    Double answer = val1 * val2;
                    result.setText(answer.toString());
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Failed to multiply numbers ", e);
                }
            }
        });
    }
}
