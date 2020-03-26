package ro.andrei.helloworld.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ro.andrei.helloworld.R;
import ro.andrei.helloworld.models.User;

public class UsersHolder extends RecyclerView.ViewHolder {
    TextView firstName;
    TextView lastName;
    public UsersHolder(@NonNull LinearLayout viewContainer) {
        super(viewContainer);
        firstName = viewContainer.findViewById(R.id.first_name);
        lastName = viewContainer.findViewById(R.id.last_name);
    }

    public void bind(User user) {
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
    }
}
