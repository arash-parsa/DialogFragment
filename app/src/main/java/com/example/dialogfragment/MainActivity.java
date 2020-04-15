package com.example.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.MyDialogEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShow = findViewById(R.id.btn_show_dialog);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialog = new MyDialog();
                myDialog.show(getSupportFragmentManager(),null);
                myDialog.setCancelable(false);
            }
        });


    }

    @Override
    public void onOkButtonClicked(String data) {
        TextView tvMain = findViewById(R.id.tv_main_showDialogMessage);
        tvMain.setText(data);
    }

    @Override
    public void onCancelButtonClicked() {
        Toast.makeText(this, "Cancel Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
