package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    EditText txtFirst;
    EditText txtSecond;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.add);
        btnSubtract = findViewById(R.id.subtract);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.divide);
        txtFirst = findViewById(R.id.txtFirst);
        txtSecond = findViewById(R.id.txtSecond);
        txtResult = findViewById(R.id.result);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        //Below is an anonymous class being made that implements OnClickListener to make use of onClick method
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                firstNumber = Integer.parseInt(txtFirst.getText().toString());
//                secondNumber = Integer.parseInt(txtSecond.getText().toString());
//                result = firstNumber + secondNumber;
//                txtResult.setText(String.valueOf(result));
//            }
//        });


    }

    @Override
    public void onClick(View v) {
        double test1 = Double.parseDouble(txtFirst.getText().toString());
        double test2 = Double.parseDouble(txtSecond.getText().toString());

        if (v.getId() == R.id.add){
            txtResult.setText(String.valueOf(test1 + test2));
        } else if (v.getId() == R.id.subtract){
            txtResult.setText(String.valueOf(test1 - test2));
        }else if (v.getId() == R.id.multiply){
            txtResult.setText(String.valueOf(test1 * test2));
        } else if (v.getId() == R.id.divide){
            txtResult.setText(String.valueOf(test1 / test2));
        }
    }
}