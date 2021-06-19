package org.techtown.koinori.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.koinori.R;

public class Menu_smoo_adeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_smoo_ade);

        Listener listener = new Listener();
        findViewById(R.id.yogurt_smoothie).setOnClickListener(listener);
        findViewById(R.id.strawberry_smoothie).setOnClickListener(listener);
        findViewById(R.id.lamonade).setOnClickListener(listener);
        findViewById(R.id.green_grape_ade).setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.yogurt_smoothie:
                    Toast.makeText(getApplicationContext(), "요거트스무디 가격: 4800", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.strawberry_smoothie:
                    Toast.makeText(getApplicationContext(), "딸기스무디 가격: 4800", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.lamonade:
                    Toast.makeText(getApplicationContext(), "레몬에이드 가격: 4500", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.green_grape_ade:
                    Toast.makeText(getApplicationContext(), "청포도에이드 가격: 4500", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
