package com.ritesh.coin;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView coinImage;
    private Button tossButton;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinImage = findViewById(R.id.coin_image);
        tossButton = findViewById(R.id.toss_button);

        tossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tossCoin();
            }
        });
    }

    private void tossCoin() {
        Animation flip = AnimationUtils.loadAnimation(this, R.anim.flip);
        coinImage.startAnimation(flip);

        new Handler().postDelayed(() -> {
            int result = random.nextInt(2); // 0 or 1
            int drawableRes = (result == 0) ? R.drawable.heads : R.drawable.tails;
            coinImage.setImageResource(drawableRes);
        }, 300);
    }
}
