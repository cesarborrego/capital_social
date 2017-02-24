package com.neology.pagatodo_test;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Cesar Segura Granados
 */
public class SplashActivity extends AppCompatActivity {
    public static final String TAG = SplashActivity.class.getSimpleName();
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (!isTaskRoot()) {
            final Intent intent = getIntent();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(intent.getAction())) {
                Log.w(TAG, "Splash Activity is not the root.  Finishing Splash Activity instead of launching.");
                finish();
                return;
            }
        }

        mCountDownTimer = new CountDownTimer(1500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.animator.animation, 0);
                finish();
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        mCountDownTimer.cancel();
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        mCountDownTimer.cancel();
        super.onStop();
    }
}
