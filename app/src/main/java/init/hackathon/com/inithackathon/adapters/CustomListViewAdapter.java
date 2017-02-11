package init.hackathon.com.inithackathon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import init.hackathon.com.inithackathon.R;
import init.hackathon.com.inithackathon.models.MovieTemp;

public class CustomListViewAdapter extends RecyclerView.Adapter<CustomListViewAdapter.ViewHolder> {

    private List<MovieTemp> movieTemps;

    public CustomListViewAdapter(List<MovieTemp> movieTemps) {
        super();
        this.movieTemps = movieTemps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pager, parent, false));

        /*View view;
        switch (viewType) {
            case 0:
                view = ;
                return new TitleViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
                return new ViewHolder(view);
        }
        return null;*/
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MovieTemp movieTemp = movieTemps.get(position);
        holder.imageView.setImageResource(movieTemp.getImageName());
        holder.textView.setText(movieTemp.getName());

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Toast.makeText(view.getContext(), "#" + position + "-" + movieTemp.getName(), Toast.LENGTH_LONG).show();
            }
        });

        /*switch (movieTemp.getMovieType()) {
            case TITLE:
                ((TitleViewHolder) holder).textView.setText(movieTemp.getName());
                ((TitleViewHolder) holder).setClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(context, "#" + position + "-" + movieTemp.getName(), Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case LIST:
                ((ViewHolder) holder).imageView.setImageResource(movieTemp.getImageName());
                ((ViewHolder) holder).textView.setText(movieTemp.getName());
                ((ViewHolder) holder).setClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(context, "#" + position + "-" + movieTemp.getName(), Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }*/
    }

    @Override
    public int getItemCount() {
        return movieTemps.size();
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
