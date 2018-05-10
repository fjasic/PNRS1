package jasic.filip.vezba10;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AddMovieActivity extends AppCompatActivity implements View.OnClickListener{

    private HttpHelper httpHelper;
    public EditText nameEdit, genreEdit, yearEdit, durationEdit, directorEdit;
    public Button addMovie;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        httpHelper = new HttpHelper();
        handler = new Handler();
        nameEdit = findViewById(R.id.form_name);
        genreEdit = findViewById(R.id.form_genre);
        yearEdit = findViewById(R.id.form_year);
        durationEdit = findViewById(R.id.form_duration);
        directorEdit = findViewById(R.id.form_director);
        addMovie = findViewById(R.id.add_movie);
        addMovie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_movie) {
            new Thread(new Runnable() {
                public void run() {
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name", nameEdit.getText().toString());
                        jsonObject.put("genre", genreEdit.getText().toString());
                        jsonObject.put("year", yearEdit.getText().toString());
                        jsonObject.put("duration", durationEdit.getText().toString());
                        jsonObject.put("director", directorEdit.getText().toString());
                        final boolean success = httpHelper.postJSONObjectFromURL(MainActivity.MOVIE_URL, jsonObject);
                        handler.post(new Runnable(){
                            public void run() {
                                Toast.makeText(AddMovieActivity.this, "Adding new movie: " + success, Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
