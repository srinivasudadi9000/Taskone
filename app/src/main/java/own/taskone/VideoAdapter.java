package own.taskone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 12-06-2017.
 */

public class VideoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Videos> videoses;

    public VideoAdapter(Context context, ArrayList<Videos> videoses) {
        this.videoses = videoses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return videoses.size();
    }

    @Override
    public Object getItem(int position) {
        return videoses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.video_single, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.myimage);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView time = (TextView) rowView.findViewById(R.id.time);
        TextView descripton = (TextView) rowView.findViewById(R.id.description);

        imageView.setImageDrawable(context.getResources().getDrawable(sources.imageid[position]));
        title.setText(videoses.get(position).getVideotitle());
        time.setText(videoses.get(position).getVideoduration());
        descripton.setText(videoses.get(position).getVideodes());
        return rowView;
    }
}
