package ro.andrei.helloworld.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ro.andrei.helloworld.fragments.HelloFragmentTest;

public class TestFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    public static final int mNumTabs = 3;
    public TestFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HelloFragmentTest();
            case 1:
                return new HelloFragmentTest();
            default:
                return new HelloFragmentTest();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
