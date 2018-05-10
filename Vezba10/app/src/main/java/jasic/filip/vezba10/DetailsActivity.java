package jasic.filip.vezba10;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

public class DetailsActivity extends AppCompatActivity {

    private HttpHelper httpHelper;
    private String movieId;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        httpHelper = new HttpHelper();
        textView = findViewById(R.id.movie_text);

        Bundle intent = getIntent().getExtras();
        if(intent!=null) {
            movieId = (String) intent.get("movieId");
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    JSONObject jsonObj = httpHelper.getJSONObjectFromURL(MainActivity.MOVIE_URL + movieId);
                    textView.setText(formMovieTextFromJson(jsonObj));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private String formMovieTextFromJson(JSONObject movieJson) throws JSONException {
        Iterator<?> keys = movieJson.keys();
        String str = "Movie: \n";
        while(keys.hasNext()) {
            String key = (String)keys.next();
            if (!(movieJson.get(key) instanceof JSONArray)) {
                str = str.concat(key.toUpperCase());
                str = str.concat(":");
                str = str.concat(movieJson.get(key).toString());
                str = str.concat("\n");
            } else {
                str = str.concat(key.toUpperCase());
                str = str.concat(":");
                JSONArray jsonArray = (JSONArray) movieJson.get(key);
                for (int i = 0, size = jsonArray.length(); i < size; i++) {
                    str = str.concat(jsonArray.getString(i));
                    str = str.concat("\n");
                }
            }
        }
        return str;
    }
}
