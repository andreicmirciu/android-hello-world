package ro.andrei.helloworld.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ro.andrei.helloworld.R;
import ro.andrei.helloworld.fragments.HelloWorldFragment;

public class HelloFragmentsActivity extends AppCompatActivity {
    HelloWorldFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_fragments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragment = new HelloWorldFragment();

        Bundle fragmentData = new Bundle();
        fragmentData.putString("foo", "bar");

        mFragment.setArguments(fragmentData);

        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction();
        ft.add(R.id.fragment_placeholder, mFragment);
        ft.commit();

    }

}
