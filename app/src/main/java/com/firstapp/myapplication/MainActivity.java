package com.firstapp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.FragmentBListener {

    private static final int NUM_PAGES = 3;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

//    private Fragment Fragment = getFragmentManager().findFragmentByTag("FragmentB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            fragment1 = new Fragment1();

            fragment2 = new Fragment2();

            fragment3 = new Fragment3();

        } else {
            fragment1 = new Fragment1();

            fragment2 = new Fragment2();

            fragment3 = new Fragment3();
        }

        viewPager2 = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

    }

    @Override
    public void onInputBSent(CharSequence input) {

        fragment2.updateEditText(input);

        fragment3.updateEditText2((String) input);
    }

    private class ScreenSlidePageAdapter extends FragmentStateAdapter {
        public ScreenSlidePageAdapter(MainActivity mainActivity) {
            super(mainActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return fragment1;
                case 1:
                    return fragment2;
                case 2:
                    return fragment3;
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

}