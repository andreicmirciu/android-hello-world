package ro.andrei.helloworld.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ro.andrei.helloworld.fragments.HelloWorldFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_ELEMENTS = 3;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HelloWorldFragment();
            case 1:
                return new HelloWorldFragment();
            case 2:
                return new HelloWorldFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ELEMENTS;
    }
}
