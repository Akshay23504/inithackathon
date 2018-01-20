package init.hackathon.com.inithackathon.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.login.LoginManager;

import java.util.List;

import init.hackathon.com.inithackathon.R;
import init.hackathon.com.inithackathon.adapters.ViewPagerAdapter;
import init.hackathon.com.inithackathon.fragment.BookFragment;
import init.hackathon.com.inithackathon.fragment.MovieFragment;
import init.hackathon.com.inithackathon.fragment.MusicFragment;
import init.hackathon.com.inithackathon.fragment.TVSeriesFragment;
import init.hackathon.com.inithackathon.models.Movie;
import init.hackathon.com.inithackathon.models.MovieResponse;
import init.hackathon.com.inithackathon.rest.ApiClient;
import init.hackathon.com.inithackathon.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "dfd845c3dbdecf375fabed3d9faa0ce0";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final int LOGOUT = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // For the back button to appear
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //TextView jsonResponse = (TextView) findViewById(R.id.json_response_main);

/*
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> movieCall = apiInterface.getTopRatedMovies(API_KEY);
        movieCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
//                Snackbar.make(findViewById(R.id.json_response_main), "operation failed", Snackbar.LENGTH_LONG).show();
            }
        });
*/

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new MovieFragment(), "MOVIES");
        viewPagerAdapter.addFragment(new MusicFragment(), "MUSIC");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(0, LOGOUT, Menu.NONE, getResources().getString(R.string.logout));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case LOGOUT:
                LoginManager.getInstance().logOut();
                onBackPressed();
            break;
        }
        return false;
    }
}
