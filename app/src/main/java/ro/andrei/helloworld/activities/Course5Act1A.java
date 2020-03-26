package ro.andrei.helloworld.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ro.andrei.helloworld.R;

public class Course5Act1A
        extends AppCompatActivity
        implements View.OnClickListener {
    Button mRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course5_act1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRedirect = findViewById(R.id.redirect_btn);
        mRedirect.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("GAF","Activity 1 onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("GAF","Activity 1 onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("GAF","Activity 1 onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("GAF","Activity 1 onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("GAF","Activity 1 onDestroy()");
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int code = resultCode;
        Log.d("GAF","Activity 1 result received "+resultCode);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("GAF","Activity 1 onSaveInstanceState()");
    }

    @Override
    public void onClick(View v) {
        Intent redirectIntent = new Intent(
                this,
                Course5Act1B.class
        );
        redirectIntent.putExtra("username", "Andrei");
        if (redirectIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(redirectIntent, 200);
        }

    }
}
