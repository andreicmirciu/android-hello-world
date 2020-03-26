package ro.andrei.helloworld.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ro.andrei.helloworld.R;

public class Course5Challange1B extends AppCompatActivity {
    Button mWebsite;
    Button mLocation;
    Button mShare;
    Button mCall;
    Button mClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course5_challange1_b);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mWebsite = findViewById(R.id.website);
        mLocation = findViewById(R.id.location);
        mShare = findViewById(R.id.share);
        mClose = findViewById(R.id.close);
        mCall = findViewById(R.id.call);

        Intent i = getIntent();
        if(i != null) {
            Uri intentData = i.getData();
            String name = "default";
            if(i.hasExtra("name")) {
                name = i.getStringExtra("name");
            }

            String toastText = "We got: "+intentData.toString()+" "+name;
            Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
        }

        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(205);
                finish();
            }
        });

        mWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        mLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent = new Intent(Intent.ACTION_VIEW);
                locationIntent.setData(Uri.parse("geo:0,0?q=Bucharest"));
                if (locationIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(locationIntent);
                }
            }
        });

        mCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:0742896394"));
                if (phoneIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(phoneIntent);
                }
            }
        });

        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello Android!");
                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(shareIntent);
                }
            }
        });

    }

}
