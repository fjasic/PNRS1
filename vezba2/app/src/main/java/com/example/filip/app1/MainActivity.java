package com.example.filip.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String tag="MAIN_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(tag,"ONStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(tag,"onSTOP");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d(tag,"ONPAUSE");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(tag,"OnRESUME");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(tag,"OnRESTART");
        super.onRestart();
    }
}
