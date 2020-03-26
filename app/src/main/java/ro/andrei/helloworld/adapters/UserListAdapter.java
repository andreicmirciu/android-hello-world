package ro.andrei.helloworld.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import ro.andrei.helloworld.R;
import ro.andrei.helloworld.models.UserModel;
import ro.andrei.helloworld.viewholders.UsersViewHolder;

public class UserListAdapter extends RecyclerView.Adapter {
    private List<UserModel> userList;

    public UserListAdapter(List<UserModel> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_view_holder, parent, false);
        UsersViewHolder item = new UsersViewHolder(v);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((UsersViewHolder) viewHolder).bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
