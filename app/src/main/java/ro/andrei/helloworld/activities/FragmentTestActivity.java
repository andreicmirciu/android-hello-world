package ro.andrei.helloworld.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ro.andrei.helloworld.R;
import ro.andrei.helloworld.fragments.HelloFragmentTest;
import ro.andrei.helloworld.listeners.ActivityListener;

public class FragmentTestActivity extends AppCompatActivity implements ActivityListener {
    HelloFragmentTest mFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test_activity);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Bundle fragmentInitBundle = new Bundle();
        fragmentInitBundle.putString("initString", "SomeData");
        mFragment = new HelloFragmentTest();
        mFragment.setArguments(fragmentInitBundle);
        ft.replace(R.id.test_container, mFragment);
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFragment.logWork("Salut!");
    }

    @Override
    public void onNotification() {
        Log.d("HelloWorld", "Button was clicked in Fragment!");
    }
}
