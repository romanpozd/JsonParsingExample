package com.roman.jsonparsing.jsonparsingexample;

import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myList;
    private myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    new JsonTask().execute();
    }


    private class JsonTask extends AsyncTask<Void, Void, ArrayList<Movie>>{

        @Override
        protected ArrayList<Movie> doInBackground(Void... params) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = null;
            try {
               jsonObject = jsonParser.getJSONfromURL(Constants.URL);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return getDataFromJSONArray(jsonObject);
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            super.onPostExecute(movies);

            ArrayList<Movie> myMovies = movies;
            // set RecyclerView
            myList = (RecyclerView)findViewById(R.id.recycler);
            myList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            adapter = new myAdapter(myMovies);
            myList.setAdapter(adapter);
            //TODO send data to adapter!!
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


    }

    private ArrayList<Movie> getDataFromJSONArray(JSONObject object){
        ArrayList<Movie> moviesList = new ArrayList<>();
        try {
            JSONArray jsonArray = object.getJSONArray("results");
            JSONObject singleObj;
            for (int i = 0; i < jsonArray.length(); ++i){
                Movie movie = new Movie();
                singleObj = jsonArray.getJSONObject(i);
                movie.setTitle(singleObj.getString(Constants.TITLE));
                movie.setOverview(singleObj.getString(Constants.OVERVIEW));
                movie.setRelease(singleObj.getString(Constants.RELEASE));
                movie.setPoster(singleObj.getString(Constants.POSTER));
                moviesList.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return moviesList;
    }

}
