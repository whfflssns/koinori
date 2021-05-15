package org.techtown.koinori;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UserdataActivity extends Activity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.userdata_check);

        Listener listener = new Listener();
        findViewById(R.id.logout).setOnClickListener(listener);
    }

    public class Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.logout:
                    make_dialog(1);
                    break;
                case R.id.delete_user:
                    make_dialog(2);
                    break;
            }
        }
    }

    private void make_dialog(int x) {
        if (x == 1){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("로그아웃"); //제목
            dlg.setMessage("로그아웃 하시겠습니까?"); // 메시지
            dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    //토스트 메시지
                    Toast.makeText(getApplicationContext(), "로그아웃 되었습니다.",Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    finish();
                }
            });
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if (x == 2) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("회원 탈퇴"); //제목
            dlg.setMessage("회원탈퇴 하시겠습니까?"); // 메시지
            dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which) {
                    //토스트 메시지
                    Toast.makeText(getApplicationContext(), "회원이 탈퇴 되었습니다.",Toast.LENGTH_SHORT).show();
                    mAuth.getCurrentUser().delete();
                    finishAffinity();
                }
            });
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
