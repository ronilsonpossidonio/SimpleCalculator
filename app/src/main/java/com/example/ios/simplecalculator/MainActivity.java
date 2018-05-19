package com.example.ios.simplecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtResult;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnSum, btnReduc, btnMultiply, btnDivider, btnEquals, btnPoint;
    Button btnC, btnStorie;
    TextView txvOperation;


    String Operation = "";
    String FirstValue = "";
    String SecondValue = "";
    ArrayList<String> Storie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvOperation = findViewById(R.id.txvOperation);
        edtResult = findViewById(R.id.edtResult);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnSum = findViewById(R.id.btnSum);
        btnReduc = findViewById(R.id.btnReduc);
        btnMultiply = findViewById(R.id.btnMult);
        btnDivider = findViewById(R.id.btnDivider);
        btnEquals = findViewById(R.id.btnEquals);
        btnPoint = findViewById(R.id.btnPoint);

        btnC = findViewById(R.id.btnC);
        btnStorie = findViewById(R.id.btnStorie);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnReduc.setOnClickListener(this);
        btnDivider.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnStorie.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
    }

    public String Calculator() {
        Double First = Double.parseDouble(FirstValue);
        Double Second = Double.parseDouble(SecondValue);

        if (Operation.equals("+"))
            return String.valueOf((First + Second));

        if (Operation.equals("-"))
            return String.valueOf((First - Second));

        if (Operation.equals("*"))
            return String.valueOf((First * Second));

        if (Operation.equals("/"))
            return String.valueOf((First / Second));

        return "Erro Fatal";
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn0:
                edtResult.setText(edtResult.getText().toString() + "0");
                break;
            case R.id.btn1:
                edtResult.setText(edtResult.getText().toString() + "1");
                break;
            case R.id.btn2:
                edtResult.setText(edtResult.getText().toString() + "2");
                break;
            case R.id.btn3:
                edtResult.setText(edtResult.getText().toString() + "3");
                break;
            case R.id.btn4:
                edtResult.setText(edtResult.getText().toString() + "4");
                break;
            case R.id.btn5:
                edtResult.setText(edtResult.getText().toString() + "5");
                break;
            case R.id.btn6:
                edtResult.setText(edtResult.getText().toString() + "6");
                break;
            case R.id.btn7:
                edtResult.setText(edtResult.getText().toString() + "7");
                break;
            case R.id.btn8:
                edtResult.setText(edtResult.getText().toString() + "8");
                break;
            case R.id.btn9:
                edtResult.setText(edtResult.getText().toString() + "9");
                break;
            case R.id.btnSum:
                Operation = "+";
                break;
            case R.id.btnReduc:
                Operation = "-";
                break;
            case R.id.btnMult:
                Operation = "*";
                break;
            case R.id.btnDivider:
                Operation = "/";
                break;
            case R.id.btnC:
                Operation = "";
                FirstValue = "";
                SecondValue = "";
                edtResult.setText("");
                break;
            case R.id.btnPoint:
                edtResult.setText(edtResult.getText().toString() + ".");
                break;
            case R.id.btnStorie:
                Intent intent = new Intent(MainActivity.this, Storie.class);
                intent.putExtra("Storie", Storie);
                startActivity(intent);
                break;
        }
        if (view.getId() == R.id.btnSum || view.getId() == R.id.btnReduc || view.getId() == R.id.btnMult || view.getId() == R.id.btnDivider){
            FirstValue = edtResult.getText().toString();
            edtResult.setText("");
            txvOperation.setText(FirstValue + " " + Operation);
        }

        if(view.getId() == R.id.btnEquals){
            SecondValue = edtResult.getText().toString();
            Storie.add(FirstValue + " " + Operation + " " + SecondValue + " = " + Calculator());
            txvOperation.setText(FirstValue + " " + Operation + " " + SecondValue + " = ");

            _SharedPreferences.saveText(this,"AppCalculator","");

            edtResult.setText(Calculator());
        }

    }
}
