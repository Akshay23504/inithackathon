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

import init.hackathon.com.inithackathon.R;

public class SplashScreenActivity extends AppCompatActivity {

    CallbackManager callbackManager;
    private final int SPLASH_TIMEOUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final TextView appName = (TextView) findViewById(R.id.appNameSplashScreenTextView);
        final TextView anotherAppName = (TextView) findViewById(R.id.anotherAppNameSplashScreenTextView);
        TextView hackathonName = (TextView) findViewById(R.id.hackathonNameSplashScreenTextView);
        TextView teamName = (TextView) findViewById(R.id.teamNameSplashScreenTextView);
        final LoginButton facebookLoginButton = new LoginButton(this);
        facebookLoginButton.setId(R.id.facebook_login);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WinterCalligraphy.ttf");
        appName.setTypeface(typeface);
        anotherAppName.setTypeface(typeface);

        hackathonName.setText(fromHtml("For <b><i>" + getResources().getString(R.string.hackathon_name) + "</i></b>"));
        teamName.setText(fromHtml("By <b><i>" + getResources().getString(R.string.team_name) + "</i></b>"));

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
                    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
                    layoutParams.addRule(RelativeLayout.BELOW, appName.getId());
                    relativeLayout.addView(facebookLoginButton, layoutParams);
                    anotherAppName.setText(getResources().getString(R.string.app_name));
                    appName.setText("");

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
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        String token = "";
        if (accessToken != null) {
            token = accessToken.getToken();
        }
        return !token.equals("");
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
