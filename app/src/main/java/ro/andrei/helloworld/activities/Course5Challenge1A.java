package ro.andrei.helloworld.activities;

import android.content.Intent;
import android.net.Uri;
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

public class Course5Challenge1A extends AppCompatActivity implements View.OnClickListener {
    Button mRedirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course5_challenge1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRedirect = findViewById(R.id.redirect);
        mRedirect.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("GAF", "Activity starting");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("GAF", "Activity pausing");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("GAF", "Activity resuming");
    }

    @Override
    protected void onStop() {
        Log.d("GAF", "Activity stopping");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("GAF", "Activity destroyed");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("GAF", "Activity save instance state");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        Intent redirectIntent = new Intent(this, Course5Challange1B.class);
        redirectIntent.setData(Uri.parse("https://google.com"));
        redirectIntent.putExtra("name", "Andrei");
        if (redirectIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(redirectIntent, 200);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("GAF", "Got result "+resultCode+" for "+requestCode);
    }
}
