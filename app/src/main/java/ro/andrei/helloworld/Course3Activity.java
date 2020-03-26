package ro.andrei.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Course3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner mSpinner;
    private ArrayAdapter<String> mSpinnerAdapter;
    private List<String> mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText email = findViewById(R.id.email_input);
        final EditText phone = findViewById(R.id.phone_input);
        final CheckBox tc = findViewById(R.id.tc_box);
        final Button submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = email.getText().toString();
                String phoneNumber = phone.getText().toString();
                boolean isAccepted = tc.isChecked();
                boolean isValid = true;
                if(emailAddress.equals("")) {
                    email.setError("email is required");
                    isValid = false;
                }
                if(phoneNumber.equals("")) {
                    phone.setError("phone is required");
                    isValid = false;
                }
                if(!isAccepted) isValid=false;

                if(isValid) {
                    Toast.makeText(
                            Course3Activity.this,
                            emailAddress + " " + phoneNumber,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
//
        mDataSource = getDataSource();
        mSpinner = findViewById(R.id.versionSpinner);
        mSpinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                mDataSource);
        mSpinner.setAdapter(mSpinnerAdapter);
        mSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<String> getDataSource() {
        List<String> androidVers = new ArrayList<>();
        androidVers.add("cupcake");
        androidVers.add("donut");
        androidVers.add("pie");
        return androidVers;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(
                this,
                getDataSource().get(i),
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
