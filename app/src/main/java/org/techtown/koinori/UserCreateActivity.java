package org.techtown.koinori;

import android.app.Activity;
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

public class UserCreateActivity extends Activity {

    private static final String TAG = "SignupActivity";
    private FirebaseAuth mAuth;
    Button create_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_create);

        mAuth = FirebaseAuth.getInstance();
        Listener listener = new Listener();
        findViewById(R.id.user_create).setOnClickListener(listener);

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
                case R.id.user_create:
                    singup();
                    break;
            }
        }
    }


    private void singup() {
        String email = ((EditText)findViewById(R.id.user_id)).getText().toString();
        String passwd = ((EditText)findViewById(R.id.user_pw)).getText().toString();
        String passwd_check = ((EditText)findViewById(R.id.user_pw_ck)).getText().toString();
//        String num = ((EditText)findViewById(R.id.user_phone)).getText().toString();
//        String birth = ((EditText)findViewById(R.id.user_birth)).getText().toString();


        if(email.length() > 0 && passwd.length() > 0 && passwd_check.length() > 0) {
            if (passwd.equals(passwd_check)) {
                mAuth.createUserWithEmailAndPassword(email, passwd)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("회원가입에 성공하였습니다.");
                                    finish();
//                            updateUI(user);
                                } else {
                                    if (task.getException() != null) {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        startToast(task.getException().toString());
//                            updateUI(null);
                                    }
                                }
                            }
                        });
            } else {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            startToast("이메일 또는 비밀번호를 입력해 주세요.");
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
