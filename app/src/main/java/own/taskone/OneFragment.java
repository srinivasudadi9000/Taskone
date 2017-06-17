package own.taskone;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class OneFragment extends Fragment{
private ListView myVideos_lv;
    ArrayList<Videos> videoses;
    VideoAdapter videoAdapter;
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_one, container, false);
        myVideos_lv = (ListView) view.findViewById(R.id.myVideos_lv);


        videoses = new ArrayList<Videos>();
        videoses.add(new Videos("R.drawable.imageone","Super Duper Song in Tamil Film sung By Modi.p.k ","20min","Super Duper Song in Tamil Film sung By Modi.p.kAwesome Video"));
        videoses.add(new Videos("R.drawable.imaget","Super Duper Song in Tamil Film sung By Modi.p.k","20min","Super Duper Song in Tamil Film sung By Modi.p.kAwesome Video"));
        videoses.add(new Videos("R.drawable.imageth","Super Duper Song in Tamil Film sung By Modi.p.k ","20min","Super Duper Song in Tamil Film sung By Modi.p.k Awesome Video"));
        videoses.add(new Videos("R.drawable.imageth","Super Duper Song in Tamil Film sung By Modi.p.k ","20min","Super Duper Song in Tamil Film sung By Modi.p.k Awesome Video"));
        videoses.add(new Videos("R.drawable.imageth","Super Duper Song in Tamil Film sung By Modi.p.k ","20min","Awesome Video Super Duper Song in Tamil Film sung By Modi.p.k"));
        videoAdapter =new VideoAdapter(view.getContext(),videoses);

        myVideos_lv.setAdapter(videoAdapter);

       // myVideos_lv.setOnItemClickListener(this);
        myVideos_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    Toast.makeText(getContext(),videoses.get(position).getVideodes(),Toast.LENGTH_SHORT).show();
                    sendBroadcast(sources.imageid[position]);
                }

            }
        });
        return view;
        // Inflate the layout for this fragment
    }
    public void sendBroadcast(int i){
        Intent intent = new Intent("send");
        intent.putExtra("imgsrc",i);
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
    }


}
