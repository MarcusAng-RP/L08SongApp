package sg.edu.rp.c346.id22002222.songapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class EditSongActivity extends AppCompatActivity {


    EditText etTitle, etSinger,etYear;

    RadioButton rb1,rb2,rb3,rb4,rb5;

    Button btnUpdate, btnDelete, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_song);

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
       Song song = (Song) i.getSerializableExtra("song");

        etTitle.setText(song.getTitle());
        etSinger.setText(song.getSingers());

        int year = song.getYear();
//        etYear.setText(Integer.toString(year));
        etYear.setText(Integer.toString(year));

        Intent intentReceived = getIntent();
        int stars = intentReceived.getIntExtra("stars", 1);

        if (stars == 1){
            rb1.setChecked(true);
        }
        else if (stars == 2) {
            rb2.setChecked(true);
        }
        else if(stars == 3){
            rb3.setChecked(true);
        }
        else if(stars == 4){
            rb4.setChecked(true);
        }
        else if(stars == 5){
            rb5.setChecked(true);
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB dbh = new myDB(EditSongActivity.this);
                song.setTitle(etTitle.getText().toString());
                song.setSingers(etSinger.getText().toString());
                song.setYear(Integer.parseInt(etYear.getText().toString()));

//                dbh.updateTitle(song);
//                dbh.updateSinger(song);
                dbh.updateSong(song);
                dbh.close();
//
                Intent intent = new Intent(EditSongActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB dbh = new myDB(EditSongActivity.this);
                dbh.deleteSong(song.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}