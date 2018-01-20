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
import init.hackathon.com.inithackathon.adapters.MusicSnapAdapter;
import init.hackathon.com.inithackathon.models.MusicSnap;
import init.hackathon.com.inithackathon.models.MovieTemp;
import init.hackathon.com.inithackathon.models.RequestFieldData;
import init.hackathon.com.inithackathon.models.RequestMusicData;
import init.hackathon.com.inithackathon.models.ResponseMusicData;
import init.hackathon.com.inithackathon.rest.ApiClient;
import init.hackathon.com.inithackathon.rest.ApiInterface;
import init.hackathon.com.inithackathon.rest.HerokuApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicFragment extends Fragment {

    private RecyclerView recyclerView;

    public MusicFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.movie_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final ApiInterface facebookRequestApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RequestMusicData> requestMusicDataCall = facebookRequestApiInterface.getMusicLiked("music", SplashScreenActivity.getAccessToken());
        requestMusicDataCall.enqueue(new Callback<RequestMusicData>() {

            @Override
            public void onResponse(Call<RequestMusicData> call, Response<RequestMusicData> response) {
                RequestMusicData musicDatas = response.body();
                /*StringBuilder stringBuilder = new StringBuilder("music/");
                // TODO handle null condition and also in Movie section
                for (RequestFieldData requestFieldData : musicDatas.music.fieldDataList) {
                    stringBuilder.append(requestFieldData.getName()).append(",");
                }
                final ApiInterface facebookRequestApiInterface = HerokuApiClient.getClient().create(ApiInterface.class);
                Call<List<ResponseMusicData>> responseMusicDataCall = facebookRequestApiInterface.
                        getSimilarMusic(stringBuilder.replace(stringBuilder.lastIndexOf(","),
                                stringBuilder.lastIndexOf(",") + 1, "").toString());
                responseMusicDataCall.enqueue(new Callback<List<ResponseMusicData>>() {
                    @Override
                    public void onResponse(Call<List<ResponseMusicData>> call, Response<List<ResponseMusicData>> response) {
                        setupAdapter(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<ResponseMusicData>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });*/
            }

            @Override
            public void onFailure(Call<RequestMusicData> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return view;
    }

    private void setupAdapter(List<ResponseMusicData> responseMusicData) {
        List<MovieTemp> movieTemps = getMovie();

        MusicSnapAdapter musicSnapAdapter = new MusicSnapAdapter();

        for (ResponseMusicData musicData : responseMusicData) {
            musicSnapAdapter.addMusicSnap(new MusicSnap(musicData.getName(), musicData.getTopTracksList()));
        }

        /*snapAdapter.addSnap(new Snap("TOP RATED", movieTemps));
        snapAdapter.addSnap(new Snap("OLD MOVIES", movieTemps));*/

        recyclerView.setAdapter(musicSnapAdapter);
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
