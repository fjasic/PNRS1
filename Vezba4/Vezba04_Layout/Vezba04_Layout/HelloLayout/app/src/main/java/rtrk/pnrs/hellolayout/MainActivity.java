package rtrk.pnrs.hellolayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.button1);
        view.setEnabled(false);

        view = findViewById(R.id.button1);
        view.setOnClickListener(this);
        view = findViewById(R.id.button2);
        view.setOnClickListener(this);
        view = findViewById(R.id.button3);
        view.setOnClickListener(this);
        view = findViewById(R.id.button4);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        Log.d("onClick", "click on " + button.getText());
    }
}
