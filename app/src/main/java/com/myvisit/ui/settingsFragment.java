package com.myvisit.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.myvisit.R;

public class settingsFragment extends Fragment {

    public View onCreateView( LayoutInflater inflater,
                              @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);

        
    }
}