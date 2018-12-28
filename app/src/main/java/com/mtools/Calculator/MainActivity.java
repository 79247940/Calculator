package com.mtools.Calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private Button btn,clearbtn;
    private TextView tv1,tv2;
    private EditText ed1,ed2;
    public BigDecimal low_value,hi_value,kws_value;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button2);
        clearbtn = findViewById(R.id.button3);
        tv1 = findViewById(R.id.kva_value);
        tv2 = findViewById(R.id.kw_value);
        ed1 = findViewById(R.id.kva_input);
        ed2 = findViewById(R.id.kw_input);
        /*
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SdCardPath") @Override
            public void onClick(View v) {
                cal();
            }
        });
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SdCardPath") @Override
            public void onClick(View v) {
                tv1.setText("");
                tv2.setText("");
                ed1.setText("");
                ed2.setText("");
            }
        });
        */
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void cal(){
        Double kvasum,kwsum;
        String kvastr = ed1.getText().toString();
        String kwstr = ed2.getText().toString();

        if (kvastr.length()==0 )
        {
            kvastr = "0";
        }
        if (kwstr.length()==0 )
        {
            kwstr = "0";
        }
        kvasum = Double.valueOf(kvastr);
        kwsum = Double.valueOf(kwstr);
        low_value = new BigDecimal(kvasum/1.732/0.4);
        hi_value = new BigDecimal(kvasum/1.732/10);
        tv1.setText("低压侧电流:"+low_value .setScale(2, 2).toString()+"A\n高压侧电流:"+hi_value .setScale(2, 2).toString()+"A");

        kws_value = new BigDecimal(kwsum*1000/(1.732*380*0.85));
        tv2.setText("电流:"+kws_value.setScale(2, 2).toString()+"A");
    };
}
