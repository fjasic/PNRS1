package jasic.filip.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spinner= findViewById(R.id.gender_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button register_back=  findViewById(R.id.register_page_register_btn);
        register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
                if(submitForm()){
                    Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(intent);
                }
            }
        });

    }


    private boolean validateUsername() {
        EditText username =  findViewById(R.id.register_username);
        if (username.getText().toString().trim().isEmpty()) {
            username.setError(getString(R.string.username_error));
            username.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private boolean validatePassword() {
        EditText password = findViewById(R.id.register_password);
        if (password.getText().toString().trim().isEmpty()) {
            password.setError(getString(R.string.password_6_error));
            password.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private boolean validateEmail() {
        EditText email=findViewById(R.id.johndoe);
        if (email.getText().toString().trim().isEmpty()) {
            email.setError(getString(R.string.email_error));
            email.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private boolean submitForm(){
        if(!validateUsername()){
            return false;
        }

        if(!validatePassword()){
            return false;
        }
        return validateEmail();
    }
}
