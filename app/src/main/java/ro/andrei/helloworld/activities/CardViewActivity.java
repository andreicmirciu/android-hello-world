package ro.andrei.helloworld.activities;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

import ro.andrei.helloworld.R;

public class CardViewActivity extends AppCompatActivity {
    Button mBtnMinus;
    Button mBtnPlus;
    Button mClickMe;
    ImageView mBattery;
    int currentLevel = 0;

    public static final int REQUEST_CAMERA_PERMISSION = 101;
    public static final int REQUEST_IMAGE_CAPTURE = 102;

    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE
                && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mBattery.setImageBitmap(imageBitmap);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    captureImage();
                } else {
                    Toast.makeText(
                            this,
                            "Camera permission needed",
                            Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtnMinus = findViewById(R.id.battery_minus);
        mBtnPlus = findViewById(R.id.battery_plus);
        mBattery = findViewById(R.id.cardview_battery);
        mClickMe = findViewById(R.id.cardview_btn);

        mClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final Calendar calendar = Calendar.getInstance();
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH);
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                DatePickerDialog mDatePicker =
//                        new DatePickerDialog(
//                                CardViewActivity.this,
//                                new DatePickerDialog.OnDateSetListener() {
//                                    @Override
//                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                                    }
//                                },
//                                year,
//                                month,
//                                day);
//                mDatePicker.show();
                if(ContextCompat.checkSelfPermission(
                        CardViewActivity.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(
                            CardViewActivity.this,
                            new String[] {Manifest.permission.CAMERA},
                            REQUEST_CAMERA_PERMISSION
                    );
                } else {
                    captureImage();
                }

            }
        });

        mBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentLevel>=1) {
                    currentLevel--;
                    mBattery.getDrawable().setLevel(currentLevel);
                }
            }
        });

        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentLevel <= 5) {
                    currentLevel++;
                    mBattery.getDrawable().setLevel(currentLevel);
                }
            }
        });
    }

}
