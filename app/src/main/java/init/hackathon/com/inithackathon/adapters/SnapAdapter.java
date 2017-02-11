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
import init.hackathon.com.inithackathon.models.Snap;

public class SnapAdapter extends RecyclerView.Adapter<SnapAdapter.ViewHolder> {

    private List<Snap> snapList;
    public static final int HORIZONTAL = 1;

    public SnapAdapter() {
        snapList = new ArrayList<>();
    }

    public void addSnap(Snap snap) {
        snapList.add(snap);
    }

    @Override
    public int getItemViewType(int position) {
        return HORIZONTAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_snap, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Snap snap = snapList.get(position);
        holder.textView.setText(snap.getText());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(new CustomListViewAdapter(snap.getMovieTempList()));
    }

    @Override
    public int getItemCount() {
        return snapList.size();
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
