package sg.edu.rp.c346.id22002222.songapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> SongList;
    public CustomAdapter(Context context, int resource, ArrayList<Song>objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        SongList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvStar = rowView.findViewById(R.id.tvStar);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);


        Song currentSong = SongList.get(position);


        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(String.valueOf(currentSong.getYear()));
        String message = "";
        for(int i = 0 ; i < currentSong.getStars(); i++){
            message += "* ";


        }
        tvStar.setText(message);
//        tvStar.setText(String.valueOf(currentSong.getStars()));
        tvSinger.setText(currentSong.getSingers());

        return rowView;
    }


}
