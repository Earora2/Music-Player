package com.example.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    ArrayList<SongModel> _songs;
    Context context;

    OnItemClickListener onitemClickListener;

    SongAdapter(Context context, ArrayList<SongModel> _songs){
        this.context = context;
        this._songs = _songs;

    }

    public interface OnItemClickListener{
        void onItemClick(Button b, View v, SongModel obj, int position);

        }

        public void setOnItemClickListener(OnItemClickListener onitemClickListener){
        this.onitemClickListener = onitemClickListener;

    }


    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View myview = LayoutInflater.from(context).inflate(R.layout.song_row,viewGroup, false);
        return new SongHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull final SongHolder songHolder, final int i) {
        final SongModel c = _songs.get(i);
        songHolder.songName.setText( c.songName);
        songHolder.artistName.setText(c.artistName);
        songHolder.action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onitemClickListener != null){
                    onitemClickListener.onItemClick(songHolder.action,v,c,i );
                };
            }
        });
    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView songName, artistName;
        Button action;
        public SongHolder(@NonNull View itemView) {
            super(itemView);
            songName = (TextView) itemView.findViewById(R.id.song_name);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
        }
    }
}
