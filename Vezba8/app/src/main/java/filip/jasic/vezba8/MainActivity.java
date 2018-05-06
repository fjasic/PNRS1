package filip.jasic.vezba8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable(){
        //time consuming task
            public void run(){
                try{
                    JSONObject jsonObject=getJSONObjectFromURL("https://swapi.co/api/planets/3/");

                /*caution,can break if object is null or doesn't have key*/
                if(jsonObject ==null) return;
                if(jsonObject.has("name")){
                    String name =String.valueOf(jsonObject.get("name"));
                    Log.d("From main",name);
                }

                }catch (IOException e){
                    e.printStackTrace();
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static JSONObject getJSONObjectFromURL(String urlString)throws IOException,JSONException{
        HttpURLConnection urlConnection=null;
        java.net.URL url=new URL(urlString);
        urlConnection=(HttpURLConnection) url.openConnection();
        /*header fields*/
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Accept","application/json");
        urlConnection.setReadTimeout(10000);/*in milliseconds*/
        urlConnection.setConnectTimeout(15000);/*in milliseconds*/

        try {
            urlConnection.connect();
        }catch (IOException e){
            return null;
        }

        BufferedReader mBufferedReader=new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder mStringBuilder=new StringBuilder();
        String line;

        while ((line = mBufferedReader.readLine())!=null){
            mStringBuilder.append(line+ "\n");
        }
        mBufferedReader.close();

        String jsonString= mStringBuilder.toString();
        Log.d("From main","JSON:" +jsonString);

        return new JSONObject(jsonString);

    }
}
