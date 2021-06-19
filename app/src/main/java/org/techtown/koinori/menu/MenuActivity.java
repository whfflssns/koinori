package org.techtown.koinori.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import org.techtown.koinori.LoginActivity;
import org.techtown.koinori.R;
import org.techtown.koinori.ReserveActivity;
import org.techtown.koinori.UserdataActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Listener listener = new Listener();
        findViewById(R.id.coffee).setOnClickListener(listener);
        findViewById(R.id.tea).setOnClickListener(listener);
        findViewById(R.id.smoo_ade).setOnClickListener(listener);
        findViewById(R.id.dessert).setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.coffee:
                    Activity_change(1);
                    break;
                case R.id.tea:
                    Activity_change(2);
                    break;
                case R.id.smoo_ade:
                    Activity_change(3);
                    break;
                case R.id.dessert:
                    Activity_change(4);
                    break;
            }
        }
    }

    private void Activity_change(int a) {
        if(a==1) {
            Intent intent = new Intent(this, Menu_coffeeActivity.class);
            startActivity(intent);
        } else if (a==2) {
            Intent intent = new Intent(this, Menu_teaActivity.class);
            startActivity(intent);
        } else if (a==3) {
            Intent intent = new Intent(this, Menu_smoo_adeActivity.class);
            startActivity(intent);
        } else if (a==4) {
            Intent intent = new Intent(this, Menu_dessertActivity.class);
            startActivity(intent);
        }
    }
}