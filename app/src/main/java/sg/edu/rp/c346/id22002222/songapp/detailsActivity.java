package sg.edu.rp.c346.id22002222.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class detailsActivity extends AppCompatActivity {

    ArrayList<Song> al;

    ArrayAdapter<String> aa;

    ListView lisv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        lisv = findViewById(R.id.lisv);


        myDB db = new myDB(detailsActivity.this);
        al = db.getSongs();
        for(int i =0; i< al.size();i++){
            int stars = al.get(i).getStars();
             al.get(i).starRating(stars);
        }
        aa = new ArrayAdapter(detailsActivity.this, android.R.layout.simple_list_item_1, al);
//        aa.notifyDataSetChanged();
        lisv.setAdapter(aa);




        lisv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song songdata = al.get(position);
                Intent i = new Intent(detailsActivity.this,
                        EditSongActivity.class);
                i.putExtra("song", songdata);
                startActivity(i);

            }
        });

    }
}