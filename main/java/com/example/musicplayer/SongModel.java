package com.example.musicplayer;

public class SongModel {
    public String songName, artistName, songURL;

    public SongModel() {
    }

    public SongModel(String songName, String artistName, String songURL) {
        this.songName = songName;
        this.artistName = artistName;
        this.songURL = songURL;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongURL() {
        return songURL;
    }
}
