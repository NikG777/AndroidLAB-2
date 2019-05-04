package com.example.lab2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Info> infosss = new ArrayList<>();
    private String URL_JSON = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json";
    private JsonArrayRequest ArrayRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncJson().execute();

    }

    class AsyncJson extends AsyncTask<Void,Void,ArrayList<Info>>
    {
        @Override
        protected ArrayList<Info> doInBackground(Void... params)
        {
            GetInfo information = new GetInfo();
            return GetInfo.getJSONURL("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/techs.ruleset.json");
        }
        @Override
        protected void onPostExecute(ArrayList<Info> informat)
        {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            intent.putExtra("info",informat);
            startActivity(intent);
            finish();
        }
    }
}


