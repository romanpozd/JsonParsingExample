package com.roman.jsonparsing.jsonparsingexample;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by roman on 01/11/2015.
 */
public class JSONParser {

    HttpURLConnection urlConnection;
    BufferedReader bufferedReader;
    static JSONObject jsonObject = null;
    static String json = "";


    // Constructor
    public JSONParser(){}


    public JSONObject getJSONfromURL(String myurl) throws IOException {
        try {
            // create new url
            URL url = new URL(myurl);
            // set request method to GET and connect to url
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();

            if (inputStream == null)
                return null;

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + "\n");
            }
            if (stringBuffer.length() == 0)
                return null;

            json = stringBuffer.toString();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null){
                urlConnection.disconnect();
            } if (bufferedReader != null)
                bufferedReader.close();
            try {
                jsonObject = new JSONObject(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
    }
}
