package own.taskone;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
   RecyclerView myrecyler_view;
    DrawerLayout mydrawerlayout;
    ArrayList<Options> options;
    ImageView mymenu,myswipeimage,myimage;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.videos,
            R.drawable.images,
            R.drawable.milestone
    };
    LinearLayout mylinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydrawerlayout = (DrawerLayout)findViewById(R.id.mydrawerlayout);
        myswipeimage = (ImageView)findViewById(R.id.myswipeimage);
        mymenu  = (ImageView)findViewById(R.id.mymenu);
        mymenu.setOnClickListener(MainActivity.this);
        myimage  = (ImageView)findViewById(R.id.myimage);
        myimage.setOnClickListener(MainActivity.this);

        // Tablayout Setup here...
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.mytabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        // Left Drawable LinearLayout
        mylinear = (LinearLayout)findViewById(R.id.mylinear);
        // Recyclerview Setup here...
         myrecyler_view = (RecyclerView)findViewById(R.id.myrecyler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myrecyler_view.setLayoutManager(layoutManager);

        options = new ArrayList<Options>();
        options.add(new Options("Edit Profile","Edit Profile"));
        options.add(new Options("Uploads ","Uploads "));
        options.add(new Options("MyImages","MyImages"));
        options.add(new Options("Logout","Logout"));

        RecyclerView.Adapter adapter = new CustomAdapter(MainActivity.this,options);
        myrecyler_view.setAdapter(adapter);
        myrecyler_view.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(),e.getY());
                 if (child != null){
                     int position = rv.getChildAdapterPosition(child);
                     if (position>=0){
                         String xx = String.valueOf(position);

                         mydrawerlayout.closeDrawer(mylinear);
                        // mydrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                         //mydrawerlayout.openDrawer(Gravity.START);
                          Toast.makeText(getBaseContext(),"Coming Soon...  "+xx.toString(),Toast.LENGTH_LONG).show();
                     }
                 }
                return false;
            }


            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
      }


    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(message,new IntentFilter("send"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(MainActivity.this).unregisterReceiver(message);
    }
    private BroadcastReceiver message = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onReceive(Context context, Intent intent) {
            int image = intent.getIntExtra("imgsrc",R.id.myswipeimage);
            myswipeimage.setBackground(getResources().getDrawable(image));
        }
    };

    //TABS SETUP HERE ..
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "VIDEOS");
        adapter.addFrag(new OneFragment(), "IMAGES");
        adapter.addFrag(new OneFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mymenu:
                mydrawerlayout.openDrawer(mylinear);
                //mydrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
              //  mydrawerlayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.myimage:
                mydrawerlayout.closeDrawer(mylinear);
        }
    }



 }
