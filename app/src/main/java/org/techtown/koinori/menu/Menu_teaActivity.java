package org.techtown.koinori.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.koinori.R;

public class Menu_teaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_tea);

        Listener listener = new Listener();
        findViewById(R.id.citron_tea).setOnClickListener(listener);
        findViewById(R.id.grapefruit_tea).setOnClickListener(listener);
        findViewById(R.id.lamon_tea).setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.citron_tea:
                    Toast.makeText(getApplicationContext(), "유자차 가격: 3500", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.grapefruit_tea:
                    Toast.makeText(getApplicationContext(), "자몽차 가격: 3500", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.lamon_tea:
                    Toast.makeText(getApplicationContext(), "레몬차 가격: 3500", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
