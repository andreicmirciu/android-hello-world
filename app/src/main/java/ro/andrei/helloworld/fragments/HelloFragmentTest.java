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
import ro.andrei.helloworld.listeners.ActivityListener;

public class HelloFragmentTest extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hello_fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle initArgs = getArguments();
        if(initArgs!=null) {
            Log.d("HelloWorld", initArgs.getString("initString"));
            ((ActivityListener) getActivity()).onNotification();
        }
    }

    public void logWork(String logMessage) {
        Log.d("HelloWorld", logMessage);
    }
}
