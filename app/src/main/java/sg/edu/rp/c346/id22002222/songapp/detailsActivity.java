package sg.edu.rp.c346.id22002222.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class detailsActivity extends AppCompatActivity {


    Button btnFilter;
    ArrayList<Song> al;

//    ArrayAdapter<String> aa;
    CustomAdapter ca;

    ListView lisv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        lisv = findViewById(R.id.lisv);
        btnFilter = findViewById(R.id.btnFilter);


        myDB db = new myDB(detailsActivity.this);

        al = db.getSongs();
//        for(int i =0; i< al.size();i++){
//            int stars = al.get(i).getStars();
//             al.get(i).starRating(stars);
//        }
//        aa = new ArrayAdapter(detailsActivity.this, android.R.layout.simple_list_item_1, al);
        ca = new CustomAdapter(this , R.layout.row, al);
//        aa.notifyDataSetChanged();
        lisv.setAdapter(ca);
        ca.notifyDataSetChanged();

//        lisv.setAdapter(aa);




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

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDB dbh = new myDB (detailsActivity.this);
                al.clear();
                al.addAll(dbh.getAllSongfive("*****"));
                ca.notifyDataSetChanged();
//                aa.notifyDataSetChanged();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDB dbh = new myDB(this);
        al.clear();
        al.addAll(dbh.getSongs());
        ca.notifyDataSetChanged();
//        aa.notifyDataSetChanged();

    }
}