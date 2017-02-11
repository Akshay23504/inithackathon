package init.hackathon.com.inithackathon.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import init.hackathon.com.inithackathon.R;
import init.hackathon.com.inithackathon.models.MovieSnap;

public class MovieListViewAdapter extends RecyclerView.Adapter<MovieListViewAdapter.ViewHolder> {

    private List<MovieSnap> movieSnapList;
    private Context context;

    public MovieListViewAdapter(List<MovieSnap> movieSnapList, Context context) {
        this.movieSnapList = movieSnapList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pager, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MovieSnap movieSnap = movieSnapList.get(position);
        Picasso.with(context).load(movieSnap.getResponseMovieData().get(position).getImageUrl()).into(holder.imageView);
        holder.textView.setText(movieSnap.getResponseMovieData().get(position).getName());

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(view.getContext(), movieSnap.getResponseMovieData().get(0).getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.nameTextView);
            itemView.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener clickListener) {
            this.itemClickListener = clickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }
    }
}
