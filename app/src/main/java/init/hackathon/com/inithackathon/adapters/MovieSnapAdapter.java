package init.hackathon.com.inithackathon.adapters;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import init.hackathon.com.inithackathon.R;
import init.hackathon.com.inithackathon.models.MovieSnap;
import init.hackathon.com.inithackathon.models.MusicSnap;

public class MovieSnapAdapter extends RecyclerView.Adapter<SnapAdapter.ViewHolder> {

    private MovieSnap movieSnap;
    public static final int HORIZONTAL = 1;

    public void addMovieSnap(MovieSnap movieSnap) {
        this.movieSnap = movieSnap;
    }

    @Override
    public int getItemViewType(int position) {
        return HORIZONTAL;
    }

    @Override
    public SnapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SnapAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_snap, parent, false));
    }

    @Override
    public void onBindViewHolder(SnapAdapter.ViewHolder holder, int position) {
        holder.textView.setText(movieSnap.getText());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(new MovieListViewAdapter(movieSnap.getResponseMovieData(), holder.recyclerView.getContext()));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.snapTextView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
