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

import ro.andrei.helloworld.adapters.UsersAdapter;
import ro.andrei.helloworld.models.User;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userList = findViewById(R.id.user_list);
        RecyclerView.LayoutManager userListLayoutManager = new LinearLayoutManager(this);
        userList.setLayoutManager(userListLayoutManager);

        List<User> users = new ArrayList<User>();
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));
        users.add(new User("Andrei", "Marinescu"));
        users.add(new User("George", "Popescu"));

        UsersAdapter usersAdapter = new UsersAdapter(users);
        userList.setAdapter(usersAdapter);
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
