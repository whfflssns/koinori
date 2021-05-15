package org.techtown.koinori;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity {

    private static final String TAG = "loginActivity";
    private FirebaseAuth mAuth;
    Button create_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        Listener listener = new Listener();
        findViewById(R.id.login).setOnClickListener(listener);
        findViewById(R.id.signup).setOnClickListener(listener);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            reload();
//        }
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login:
                    singin();
                    break;
                case R.id.signup:
                    Activity_change(1);
                    break;
            }
        }
    }


    private void singin() {
        String email = ((EditText)findViewById(R.id.user_id)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.user_pw)).getText().toString();

        if(email.length() > 0 && passwd.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, passwd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인에 성공했습니다.");
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                startToast(task.getException().toString());
                            }
                        }
                    });
        }
        else {
            startToast("이메일 또는 비밀번호를 입력해 주세요.");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void Activity_change(int c) {
        if (c == 1) {
            Intent intent = new Intent(this, UserCreateActivity.class);
            startActivity(intent);
        }
    }
}
