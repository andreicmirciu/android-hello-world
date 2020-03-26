package ro.andrei.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import ro.andrei.helloworld.adapters.UserListAdapter;
import ro.andrei.helloworld.models.UserModel;

public class MainActivity extends AppCompatActivity {
    RecyclerView mUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       mUsersList = findViewById(R.id.users_recycler_view);
        RecyclerView.LayoutManager userListLayoutManager = new LinearLayoutManager(this);
        mUsersList.setLayoutManager(userListLayoutManager);

        List<UserModel> userList = new ArrayList<>();
        userList.add(new UserModel("Andrei", "Marinescu"));
        userList.add(new UserModel("Gica", "Popescu"));
        userList.add(new UserModel("John", "Snow"));
        userList.add(new UserModel("Harry", "Potter"));
        userList.add(new UserModel("George", "Martin"));
        userList.add(new UserModel("Andrei", "Marinescu"));
        userList.add(new UserModel("Gica", "Popescu"));
        userList.add(new UserModel("John", "Snow"));
        userList.add(new UserModel("Harry", "Potter"));
        userList.add(new UserModel("George", "Martin"));
        userList.add(new UserModel("Andrei", "Marinescu"));
        userList.add(new UserModel("Gica", "Popescu"));
        userList.add(new UserModel("John", "Snow"));
        userList.add(new UserModel("Harry", "Potter"));
        userList.add(new UserModel("George", "Martin"));

        UserListAdapter listAdapter = new UserListAdapter(userList);
        mUsersList.setAdapter(listAdapter);
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
}
