package ro.andrei.helloworld.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.andrei.helloworld.R;

public class HelloWorldFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.hello_world_fragment,
                container,
                false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle fragmentData = getArguments();
        if(fragmentData != null) {
            Log.d(
                    "HelloWorld",
                    fragmentData.getString("foo")
            );
        }

    }
}
