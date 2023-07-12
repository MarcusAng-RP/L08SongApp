package sg.edu.rp.c346.id22002222.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSinger, etYear;

    RadioButton rb1, rb2, rb3, rb4, rb5;

    Button btnInsert, btnShowList;

    ArrayList<Song> al;
    ArrayAdapter<String> aa;
    ListView lv;

    int stars = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnDelete);
        lv = findViewById(R.id.lisv);




        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB db = new myDB(MainActivity.this);

                String title = etTitle.getText().toString();
                String singer = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());


                if(rb1.isChecked()) {
                    stars = 1;

                }
                else if(rb2.isChecked()){
                    stars = 2;


                }

                else if(rb3.isChecked()){
                    stars = 3;

                }else if(rb4.isChecked()){
                    stars = 4;

//
                }
                else if(rb5.isChecked()){
                    stars = 5;


                }

                db.insertSong(title,singer, year, stars);


                Toast.makeText(MainActivity.this, "Song successfully added", Toast.LENGTH_SHORT).show();




            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, detailsActivity.class);
                startActivity(intent);


//                myDB db = new myDB(MainActivity.this);
//                al = db.getSongs();
//
//                aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, al);
//
//
//                lv.setAdapter(aa);


            }
        });


    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        btnShowList.performClick();
//    }
}