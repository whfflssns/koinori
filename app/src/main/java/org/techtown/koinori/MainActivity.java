package org.techtown.koinori;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button userdata, roomreserve, menu, coupon, giftcard, news;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userdata = findViewById(R.id.user_data);
        roomreserve = findViewById(R.id.room_reserve);
        menu = findViewById(R.id.menu);
        coupon = findViewById(R.id.coupon);
        giftcard = findViewById(R.id.gift_card);
        news = findViewById(R.id.news);

        Listener listener = new Listener();
        userdata.setOnClickListener(listener);
        roomreserve.setOnClickListener(listener);
        menu.setOnClickListener(listener);
        coupon.setOnClickListener(listener);
        giftcard.setOnClickListener(listener);
        news.setOnClickListener(listener);

    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.user_data:
                    if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                        Activity_change('1');
                    }
                    else {
                        Activity_change('2');
                    }
                    break;
                case R.id.room_reserve:
                    if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                        Activity_change('1');
                    }
                    else {
                        Activity_change('3');
                    }
                    break;
                case R.id.menu:

                case R.id.coupon:

                case R.id.gift_card:

                case R.id.news:

            }
        }
    }

    private void Activity_change(int a) {
        if(a ==1) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        else if (a == 2) {
            Intent intent = new Intent(this, UserdataActivity.class);
            startActivity(intent);
        }
        else if (a == 3) {
            Intent intent = new Intent(this, ReserveActivity.class);
            startActivity(intent);
        }
    }
}