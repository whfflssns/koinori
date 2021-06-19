package org.techtown.koinori.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.koinori.R;

import java.util.List;

public class Menu_coffeeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_coffee);

        Listener listener = new Listener();
        findViewById(R.id.americano).setOnClickListener(listener);
        findViewById(R.id.cafe_latte).setOnClickListener(listener);
        findViewById(R.id.vanilla_latte).setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.americano:
                    Toast.makeText(getApplicationContext(), "아메리카노 가격: 3500", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.cafe_latte:
                    Toast.makeText(getApplicationContext(), "카페라떼 가격: 4000", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.vanilla_latte:
                    Toast.makeText(getApplicationContext(), "바닐라라떼 가격: 4500", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
