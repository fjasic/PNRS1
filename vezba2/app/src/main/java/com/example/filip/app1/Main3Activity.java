package com.example.filip.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button start =(Button) findViewById(R.id.start);
         Button lose1=(Button) findViewById(R.id.lose1);
         Button lose2=(Button) findViewById(R.id.lose2);
         TextView text1=(TextView) findViewById(R.id.textView);
         TextView text2 =(TextView) findViewById(R.id.textView2);

    start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button lose1=(Button) findViewById(R.id.lose1);
            Button lose2=(Button) findViewById(R.id.lose2);
            TextView text1=(TextView) findViewById(R.id.textView);
            TextView text2 =(TextView) findViewById(R.id.textView2);
            lose1.setEnabled(true);
            lose2.setEnabled(true);
            text1.setText("");
            text2.setText("");
        }
    });

    lose1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Button lose1=(Button) findViewById(R.id.lose1);
            Button lose2=(Button) findViewById(R.id.lose2);
            TextView text2 =(TextView) findViewById(R.id.textView2);
            TextView text1=(TextView) findViewById(R.id.textView);
            lose2.setEnabled(false);
            text2.setText("LOSE");
            lose1.setEnabled(false);
            text1.setText("");
        }


    });

        lose2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button lose1=(Button) findViewById(R.id.lose1);
                Button lose2=(Button) findViewById(R.id.lose2);
                TextView text1=(TextView) findViewById(R.id.textView);
                TextView text2 =(TextView) findViewById(R.id.textView2);
                lose1.setEnabled(false);
                text1.setText("LOSE");
                lose2.setEnabled(false);
                text2.setText("");
            }


        });

    }
}
