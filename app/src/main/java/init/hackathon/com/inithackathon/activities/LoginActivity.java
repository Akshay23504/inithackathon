package init.hackathon.com.inithackathon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import init.hackathon.com.inithackathon.R;

public class LoginActivity extends AppCompatActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();
        LoginButton facebookLoginButton = (LoginButton) findViewById(R.id.facebook_login);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        String token = "";
        if (accessToken != null) {
            token = accessToken.getToken();
        }
        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Snackbar.make(findViewById(R.id.facebook_login), "Authentication successful", Snackbar.LENGTH_LONG).show();
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

        // Generate Developer environment hash key through code
        /*try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo("init.hackathon.com.inithackathon", PackageManager.GET_SIGNATURES);
            for (Signature signature : packageInfo.signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.d("KEY", Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
