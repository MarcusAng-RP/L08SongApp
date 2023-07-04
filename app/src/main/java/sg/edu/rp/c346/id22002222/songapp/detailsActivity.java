package sg.edu.rp.c346.id22002222.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        aa = new ArrayAdapter(detailsActivity.this, android.R.layout.simple_list_item_1, al);

        lisv.setAdapter(aa);

    }
}