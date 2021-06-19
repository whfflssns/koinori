package org.techtown.koinori.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.koinori.R;

public class Menu_dessertActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_dessert);

        Listener listener = new Listener();
        findViewById(R.id.kaya_toast).setOnClickListener(listener);
        findViewById(R.id.icecream_brownie).setOnClickListener(listener);
        findViewById(R.id.cream_castella).setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.kaya_toast:
                    Toast.makeText(getApplicationContext(), "카야토스트 가격: 3000", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.icecream_brownie:
                    Toast.makeText(getApplicationContext(), "아이스크림브라우니 가격: 3500", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.cream_castella:
                    Toast.makeText(getApplicationContext(), "크림카스테라 가격: 4000", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
