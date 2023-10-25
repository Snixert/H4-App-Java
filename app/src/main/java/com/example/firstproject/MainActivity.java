package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,
        AdapterView.OnItemSelectedListener{
    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    EditText txtFirst;
    EditText txtSecond;
    TextView txtResult;
    TextView txtChosen;


    //RadioButton part
    RadioGroup rdgElever;

    //Spinner
    String[] country = { "India", "USA", "China", "Japan", "Denmark", "Other"};

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

        rdgElever = findViewById(R.id.rdgElever);
        rdgElever.setOnCheckedChangeListener(this);
        txtChosen = findViewById(R.id.txtChosen);


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId)
        {
            case R.id.rdbGew:
                txtChosen.setText("You're a gew-head");
                break;
            case R.id.rdbLatino:
                txtChosen.setText("You're Latino Cream King");
                break;
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,country[position] , Toast.LENGTH_LONG).show();
        // Other example below, MainActivity.this is if you make an anonymous class and need 'this' to be a different scope
//        Toast.makeText(MainActivity.this, "Yeehaw", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}