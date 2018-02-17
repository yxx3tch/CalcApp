package jp.techacademy.yxx3tch.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        float value1 = intent.getFloatExtra("VALUE1", 0);
        float value2 = intent.getFloatExtra("VALUE2", 0);
        String calcType = intent.getStringExtra("CALC_TYPE");

        float result = 0;

        switch (calcType) {
            case "plus":
                result = value1 + value2;
                break;
            case "minus":
                result = value1 - value2;
                break;
            case "times":
                result = value1 * value2;
                break;
            case "divide":
                result = value1 / value2;
                break;
            default:
                break;
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(result));
    }
}
