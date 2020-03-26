package ro.andrei.helloworld.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import ro.andrei.helloworld.R;
import ro.andrei.helloworld.models.User;
import ro.andrei.helloworld.viewholders.UsersHolder;

public class UsersAdapter extends RecyclerView.Adapter {
    List<User> userList;

    public UsersAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder, parent, false);
        UsersHolder item = new UsersHolder(v);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((UsersHolder) viewHolder).bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
