package com.example.animationslide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {


    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = getIntent().getIntExtra("NUM", 1);

        LinearLayout l1 = new LinearLayout(this);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(num) + "回目");

        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("NUM", num);
                startActivity(intent);
                overridePendingTransition(R.animator.activity_open_enter, R.animator.activity_open_exit);
            }
        });


    }

    //バックボタンのときの処理
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.animator.activity_close_enter, R.animator.activity_close_exit);
    }
}
