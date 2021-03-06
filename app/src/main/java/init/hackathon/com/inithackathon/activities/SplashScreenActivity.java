package init.hackathon.com.inithackathon.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import init.hackathon.com.inithackathon.R;

public class SplashScreenActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    private final int SPLASH_TIMEOUT = 300;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final LoginButton facebookLoginButton = new LoginButton(this);
        facebookLoginButton.setId(R.id.facebook_login);

/*        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WinterCalligraphy.ttf");
        appName.setTypeface(typeface);
        anotherAppName.setTypeface(typeface);

        hackathonName.setText(fromHtml("For <b><i>" + getResources().getString(R.string.hackathon_name) + "</i></b>"));
        teamName.setText(fromHtml("By <b><i>" + getResources().getString(R.string.team_name) + "</i></b>")); */

        callbackManager = CallbackManager.Factory.create();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (checkAccessToken()) {
                    redirectToMainActivity();
                } else {
                    RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayoutSplashScreen);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    layoutParams.addRule(Gravity.CENTER_HORIZONTAL);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    layoutParams.setMargins(0, 0, 0, 80);
                    relativeLayout.addView(facebookLoginButton, layoutParams);

                    facebookLoginButton.setReadPermissions(Arrays.asList("user_likes"));
                    facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                        @Override
                        public void onSuccess(LoginResult loginResult) {
                            Snackbar.make(findViewById(R.id.facebook_login), "Authentication successful", Snackbar.LENGTH_LONG).show();
                            if (checkAccessToken()) {
                                redirectToMainActivity();
                            }
                        }

                        @Override
                        public void onCancel() {
                            Snackbar.make(findViewById(R.id.facebook_login), "Authentication failed", Snackbar.LENGTH_LONG).show();
                        }

                        @Override
                        public void onError(FacebookException error) {
                            Snackbar.make(findViewById(R.id.facebook_login), "Authentication failed", Snackbar.LENGTH_LONG).show();
                        }
                    });
                }
            }
        }, SPLASH_TIMEOUT);
    }

    public static boolean checkAccessToken() {
        return !getAccessToken().equals("");
    }

    public static String getAccessToken() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null) {
            return accessToken.getToken();
        }
        return "";
    }

    private void redirectToMainActivity() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private Spanned fromHtml(String string) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(string, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(string);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
