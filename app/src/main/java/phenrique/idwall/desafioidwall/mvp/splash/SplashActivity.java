package phenrique.idwall.desafioidwall.mvp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import phenrique.idwall.desafioidwall.R;
import phenrique.idwall.desafioidwall.mvp.feed.FeedActivity;
import phenrique.idwall.desafioidwall.mvp.signup.SignupActivity;
import phenrique.idwall.desafioidwall.utils.AppPreference;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(splashTask, 2000);
    }

    Runnable splashTask = new Runnable() {
        @Override
        public void run() {
            navigate();
        }
    };

    private void navigate() {

        if (AppPreference.getLoggedStatus(this)) {
            startActivity(new Intent(SplashActivity.this, FeedActivity.class));
            finish();
        } else {
            AppPreference.logout(this);
            startActivity(new Intent(SplashActivity.this, SignupActivity.class));
            finish();
        }
    }

}
