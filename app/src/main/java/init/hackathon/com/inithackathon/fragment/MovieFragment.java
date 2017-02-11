package init.hackathon.com.inithackathon.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import init.hackathon.com.inithackathon.R;
import init.hackathon.com.inithackathon.activities.SplashScreenActivity;
import init.hackathon.com.inithackathon.adapters.MovieSnapAdapter;
import init.hackathon.com.inithackathon.adapters.SnapAdapter;
import init.hackathon.com.inithackathon.models.MovieSnap;
import init.hackathon.com.inithackathon.models.MovieTemp;
import init.hackathon.com.inithackathon.models.MusicSnap;
import init.hackathon.com.inithackathon.models.RequestFieldData;
import init.hackathon.com.inithackathon.models.RequestMovieData;
import init.hackathon.com.inithackathon.models.RequestMusicData;
import init.hackathon.com.inithackathon.models.ResponseMovieData;
import init.hackathon.com.inithackathon.models.ResponseMusicData;
import init.hackathon.com.inithackathon.models.Snap;
import init.hackathon.com.inithackathon.rest.ApiClient;
import init.hackathon.com.inithackathon.rest.ApiInterface;
import init.hackathon.com.inithackathon.rest.HerokuApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Akshay on 10-02-2017.
 */

public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;

    List<String> names;
    List<Integer> imageNames;

    public MovieFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment, container, false);
        /*recyclerView = (RecyclerView) view.findViewById(R.id.movie_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);*/

       /* final ApiInterface facebookRequestApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RequestMovieData> requestMovieDataCall = facebookRequestApiInterface.getMovieLiked("movies", SplashScreenActivity.getAccessToken());
        requestMovieDataCall.enqueue(new Callback<RequestMovieData>() {

            @Override
            public void onResponse(Call<RequestMovieData> call, Response<RequestMovieData> response) {
                RequestMovieData movieDatas = response.body();
                StringBuilder stringBuilder = new StringBuilder("movies/");
                for (RequestFieldData requestFieldData : movieDatas.getMovie().fieldDataList) {
                    stringBuilder.append(requestFieldData.getName()).append(",");
                }
                final ApiInterface facebookRequestApiInterface = HerokuApiClient.getClient().create(ApiInterface.class);
                Call<List<ResponseMovieData>> responseMovieDataCall = facebookRequestApiInterface.
                        getSimilarMovie(stringBuilder.replace(stringBuilder.lastIndexOf(","),
                                stringBuilder.lastIndexOf(",") + 1, "").toString());
                responseMovieDataCall.enqueue(new Callback<List<ResponseMovieData>>() {
                    @Override
                    public void onResponse(Call<List<ResponseMovieData>> call, Response<List<ResponseMovieData>> response) {
                        setupAdapter(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<ResponseMovieData>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }

            @Override
            public void onFailure(Call<RequestMovieData> call, Throwable t) {
                t.printStackTrace();
            }
        });*/

        return view;
    }

    private void setupAdapter(List<ResponseMovieData> responseMovieDatas) {
        List<MovieTemp> movieTemps = getMovie();

        MovieSnapAdapter movieSnapAdapter = new MovieSnapAdapter();

        for (ResponseMovieData movieData : responseMovieDatas) {
            movieSnapAdapter.addMovieSnap(new MovieSnap("Recommended for you", responseMovieDatas));
        }

        recyclerView.setAdapter(movieSnapAdapter);
    }

    private List<MovieTemp> getMovie() {
        List<MovieTemp> movieTemps = new ArrayList<>();
        movieTemps.add(new MovieTemp("MOVIE1", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE2", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE3", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE4", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE5", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE6", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE7", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE8", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE9", "DESCRIPTION1", R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE10", "DESCRIPTION1", R.drawable.activity_splash_init));
        return movieTemps;
    }
}
