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
import init.hackathon.com.inithackathon.adapters.SnapAdapter;
import init.hackathon.com.inithackathon.models.MovieTemp;
import init.hackathon.com.inithackathon.models.Snap;

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
        /*View view = inflater.inflate(R.layout.movie_fragment, container, false);
        names = new ArrayList<>(Arrays.asList("MOVIE1", "MOVIE2", "MOVIE3", "MOVIE4", "MOVIE5", "MOVIES6", "MOVIES7"));
        imageNames = new ArrayList<>(Arrays.asList(R.drawable.activity_splash_init,
                R.drawable.activity_splash_init, R.drawable.activity_splash_init,
                R.drawable.activity_splash_init, R.drawable.activity_splash_init,
                R.drawable.activity_splash_init, R.drawable.activity_splash_init));
        recyclerView = (RecyclerView) view.findViewById(R.id.movie_recycler_view);

        List<MovieTemp> movieTemps = new ArrayList<>();
        movieTemps.add(new MovieTemp("MOVIE1", null, MovieTemp.TITLE, 0));
        movieTemps.add(new MovieTemp("MOVIE2", null, MovieTemp.TITLE, 0));
        movieTemps.add(new MovieTemp("MOVIE3", "DESCRIPTION3", MovieTemp.LIST, R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE4", null, MovieTemp.TITLE, 0));
        movieTemps.add(new MovieTemp("MOVIE5", null, MovieTemp.TITLE, 0));
        movieTemps.add(new MovieTemp("MOVIE6", "DESCRIPTION6", MovieTemp.LIST, R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE7", null, MovieTemp.TITLE, 0));
        movieTemps.add(new MovieTemp("MOVIE8", "DESCRIPTION8", MovieTemp.LIST, R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE9", "DESCRIPTION9", MovieTemp.LIST, R.drawable.activity_splash_init));
        movieTemps.add(new MovieTemp("MOVIE10", null, MovieTemp.TITLE, 0));

        //recyclerView.setHasFixedSize(true);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        adapter = new CustomListViewAdapter(movieTemps, getActivity());

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return view;*/

        View view = inflater.inflate(R.layout.movie_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.movie_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        List<MovieTemp> movieTemps = getMovie();

        SnapAdapter snapAdapter = new SnapAdapter();
        snapAdapter.addSnap(new Snap("RECOMMENDED FOR YOU", movieTemps));
        snapAdapter.addSnap(new Snap("TOP RATED", movieTemps));
        snapAdapter.addSnap(new Snap("OLD MOVIES", movieTemps));

        recyclerView.setAdapter(snapAdapter);
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
