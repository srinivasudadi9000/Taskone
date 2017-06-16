package own.taskone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 12-06-2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context mainActivity;
    ArrayList<Options> options;

    public CustomAdapter(MainActivity mainActivity, ArrayList<Options> options) {
        this.mainActivity = mainActivity;
        this.options = options;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textone.setText(options.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return options.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textone;

        public ViewHolder(View itemView) {
            super(itemView);
            textone = (TextView) itemView.findViewById(R.id.textone);
        }
    }
}
