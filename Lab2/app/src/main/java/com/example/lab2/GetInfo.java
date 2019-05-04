package com.example.lab2;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class GetInfo {
    private static String JJJ;
    private static ArrayList<Info> infos = new ArrayList<>();
    public static ArrayList<Info> getJSONURL(String reqUrl) {
        try {
            String JSON_STRING;
            URL url = new URL(reqUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((JSON_STRING = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(JSON_STRING + "\n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            JJJ = stringBuilder.toString().trim();
            if (JJJ != null) {
                JJJ += "}";
                JJJ = "{\"objects\":" + JJJ;
            }
            JSONObject jsonobject = new JSONObject(JJJ);
            JSONArray techs = jsonobject.getJSONArray("objects");
            int count = 1;
            while (count < techs.length()) {
                JSONObject Jsonchik = techs.getJSONObject(count);
                Info inf = new Info();
                inf.setName(Jsonchik.getString("name"));
                try {
                    inf.setHelptext(Jsonchik.getString("helptext"));
                }
                catch (final JSONException e)
                {
                    inf.setHelptext("");
                }
                inf.setGraphic(Jsonchik.getString("graphic"));
                infos.add(inf);
                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infos;
    }
}
