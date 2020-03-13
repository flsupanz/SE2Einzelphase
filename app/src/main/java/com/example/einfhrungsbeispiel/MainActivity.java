package com.example.einfhrungsbeispiel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private EditText EditTextMtrnmr;
    private TextView textView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =(Button) findViewById(R.id.button);
        EditTextMtrnmr = (EditText) findViewById(R.id.editText2);

        btn.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v){

        if(v == btn){
            int matrikelnummer;
            matrikelnummer= Integer.valueOf(EditTextMtrnmr.getText().toString());
             String temp = Integer.toString(matrikelnummer);
            int[] a = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++)
            {
                a[i] = temp.charAt(i) - '0';
            }

            Arrays.sort(a);
            int countOdd=0;
            int countEven=0;
            for (int i = 0; i < a.length; ++i) {
                if(a[i]%2==0){
                    ++countEven;
                }
                else{
                    countOdd++;

                }
            }
            int[] evenArray= new int[countEven];
            int[] oddArray= new int [countOdd];
            int j=0;
            int y=0;



            for (int i = 0; i < a.length; ++i) {

                if(a[i]%2==0){
                    evenArray[j]=a[i];
                    j++;

                }
                else{
                    oddArray[y]=a[i];
                    y++;
                }
            }

            a= IntStream.concat(IntStream.of(evenArray),IntStream.of(oddArray)).toArray();

            StringBuilder sb = new StringBuilder();
            for(int i : a) {
                sb.append(i);
            }
            int ergebnis = Integer.parseInt(sb.toString());

            textView.setText("Ergebnis: " + ergebnis);


    }

}}