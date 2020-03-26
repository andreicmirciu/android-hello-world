package ro.andrei.helloworld.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ro.andrei.helloworld.R;
import ro.andrei.helloworld.models.UserModel;

public class UsersViewHolder extends RecyclerView.ViewHolder {
    private TextView mFirstName;
    private TextView mLastName;
    public UsersViewHolder(@NonNull View container) {
        super(container);
        mFirstName = container.findViewById(R.id.user_first_name);
        mLastName = container.findViewById(R.id.user_last_name);
    }

    public void bind(UserModel user) {
        mFirstName.setText(user.getFirstName());
        mLastName.setText(user.getLastName());
    }
}
