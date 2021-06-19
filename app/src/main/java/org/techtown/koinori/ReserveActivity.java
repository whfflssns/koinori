package org.techtown.koinori;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.techtown.koinori.reserve_room.*;

public class ReserveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        Listener listener = new Listener();
        findViewById(R.id.room1).setOnClickListener(listener);
        findViewById(R.id.room2).setOnClickListener(listener);
        findViewById(R.id.room3).setOnClickListener(listener);
        findViewById(R.id.room4).setOnClickListener(listener);
        findViewById(R.id.room5).setOnClickListener(listener);
        findViewById(R.id.room6).setOnClickListener(listener);
        findViewById(R.id.room7).setOnClickListener(listener);
        findViewById(R.id.room8).setOnClickListener(listener);
        findViewById(R.id.room9).setOnClickListener(listener);

    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.room1:
                    Activity_change(1);
                    break;
                case R.id.room2:
                    Activity_change(2);
                    break;
                case R.id.room3:
                    Activity_change(3);
                    break;
                case R.id.room4:
                    Activity_change(4);
                    break;
                case R.id.room5:
                    Activity_change(5);
                    break;
                case R.id.room6:
                    Activity_change(6);
                    break;
                case R.id.room7:
                    Activity_change(7);
                    break;
                case R.id.room8:
                    Activity_change(8);
                    break;
                case R.id.room9:
                    Activity_change(9);
                    break;

            }
        }
    }

    private void Activity_change(int c) {
        if (c == 1) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 2) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 3) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 4) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 5) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 6) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 7) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 8) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
        else if (c == 9) {
            Intent intent = new Intent(this, reserve_room1.class);
            startActivity(intent);
        }
    }
}