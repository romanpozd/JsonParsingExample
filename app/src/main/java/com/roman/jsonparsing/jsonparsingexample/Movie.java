package com.roman.jsonparsing.jsonparsingexample;

/**
 * Created by roman on 01/11/2015.
 */
public class Movie {
    private String title, release, poster, overview;


    // Constructor
    public Movie (){};
    public String getTitle() {
        return title;
    }

    public String getRelease() {
        return release;
    }

    public String getPoster() {
        return poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
