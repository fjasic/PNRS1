package jasic.filip.chatapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button login = (Button) findViewById(R.id.login_button);
        final Button register = (Button) findViewById(R.id.register_button);
        final TextView username = (TextView) findViewById(R.id.username_text);
        final TextView password = (TextView) findViewById(R.id.password_text);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /**   login.setEnabled(false);
                username.requestFocus();
                if (username.getText().toString().trim().isEmpty() || password.getText().toString().length() <= 6) {
                    login.setEnabled(false);
                    Context context = getApplicationContext();
                    CharSequence text = "fill in username and password";
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();
                } else if (username.getText().toString().length() != 0 & password.getText().toString().length() > 6) {
                    login.setEnabled(true);
                }**/

                 submitForm();

              }
        });
    }


    private boolean validateUsername() {
        final TextView username = (TextView) findViewById(R.id.username_text);
        if (username.getText().toString().trim().isEmpty()) {
            username.setError(getString(R.string.username_error));
            username.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private boolean validatePassword() {
        final TextView password = (TextView) findViewById(R.id.password_text);
        if (password.getText().toString().trim().length() <= 6) {
            password.setError(getString(R.string.password_error));
            password.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    private void submitForm(){
        if(!validateUsername()){
            return;
        }

        if(!validatePassword()){
            return;
        }
    }


}
