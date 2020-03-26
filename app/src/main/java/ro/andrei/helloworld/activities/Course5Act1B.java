package ro.andrei.helloworld.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ro.andrei.helloworld.R;

public class Course5Act1B extends AppCompatActivity {
    Button mWebBtn;
    Button mLocationBtn;
    Button mShareBtn;
    Button mCallBtn;
    Button mCloseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course5_act1_b);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mWebBtn = findViewById(R.id.web_intent);
        mLocationBtn = findViewById(R.id.location_intent);
        mShareBtn = findViewById(R.id.share_intent);
        mCallBtn = findViewById(R.id.call_intent);
        mCloseBtn = findViewById(R.id.close_intent);

        mWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("https://google.com"));
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        mLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW);
                locationIntent.setData(Uri.parse("geo:0,0?q=Bucharest"));
                if(locationIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(locationIntent);
                }
            }
        });

        mShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Salut Lume");
                if(shareIntent.resolveActivity(getPackageManager())!=null) {
                    startActivity(shareIntent);
                }
            }
        });

        mCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0742896394"));
                if(callIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(callIntent);
                }
            }
        });

        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(205);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("GAF","Activity 2 onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("GAF","Activity 2 onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("GAF","Activity 2 onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("GAF","Activity 2 onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("GAF","Activity 2 onDestroy()");
    }

}
