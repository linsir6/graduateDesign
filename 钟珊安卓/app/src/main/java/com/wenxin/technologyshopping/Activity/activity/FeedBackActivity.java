package com.wenxin.technologyshopping.Activity.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wenxin.technologyshopping.R;

/**
 * Created by linSir
 * date at 2017/4/14.
 * describe:
 */

public class FeedBackActivity extends AppCompatActivity {

    private Button submit;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(FeedBackActivity.this, "您的反馈，我们已经收到，非常感谢", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
