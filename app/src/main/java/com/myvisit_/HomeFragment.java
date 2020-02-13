package com.myvisit_;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import  java.util.*;
import java.lang.*;

import android.os.CountDownTimer;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private View homeView;
    private Date obj;
    private TextView Date;
    private Button VTbutton;
    private Button CSbutton;
    private Button WTbutton;
    private FrameLayout fl;
    private DatabaseReference ref;
    private int index;
    private TextView trytv;
    private static final long START_TIME_IN_MILLIS = 600000;

    //Timer
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private long mEndTime;


    public View onCreateView(LayoutInflater inflater,
                             @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home, container, false);

        VTbutton = homeView.findViewById(R.id.VTbutton);
        CSbutton = homeView.findViewById(R.id.CSbutton);
        WTbutton = homeView.findViewById(R.id.WTbutton);
        fl = homeView.findViewById(R.id.flNew);
        trytv = homeView.findViewById(R.id.variableCrowdState);

        ref = FirebaseDatabase.getInstance().getReference().child("Admin").child("admin1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String CrowdState = dataSnapshot.child("adminID").toString();
                trytv.setText(CrowdState);
                //int temp = Integer.parseInt(CrowdState);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        VTbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showVisitTime();
            }
        });

        CSbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcrowdState();

                //  fl.removeAllViews();

                //  LayoutInflater.from(getContext()).inflate(R.layout.activity_crowd_state, fl, true);

            }
        });

        WTbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWaitingTime();

            }
        });

        obj = new java.util.Date();
        Date = homeView.findViewById(R.id.editTextDate);

        Date.setText(obj.toString());


        return homeView;
    }


    private void showcrowdState() {

        fl.removeAllViews();
        // fl = R.layout.activity_crowd_state;
        LayoutInflater.from(getContext()).inflate(R.layout.activity_crowd_state, fl, true);
        TextView CrowsState = fl.findViewById(R.id.CrowsState);
        CrowsState.setText("");
        ProgressBar pb;
        index = 19;
        TextView tv;
        EditText et;


        pb = fl.findViewById(R.id.CSprogressBar);
        tv = fl.findViewById(R.id.variableCrowdState);


        // index = Integer.parseInt(et.getText().toString());


        if (index > 0 && index <= 20) {
            pb.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            pb.setProgress(index);
            tv.setText("Not Crowded");
            tv.setTextColor(ColorStateList.valueOf(Color.GREEN));


        } else if (index <= 69 && index >= 20) {
            pb.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
            pb.setProgress(index);
            tv.setText("Slightly Crowded");
            tv.setTextColor(ColorStateList.valueOf(Color.YELLOW));
        } else if (index >= 70) {
            pb.setProgressTintList(ColorStateList.valueOf(Color.RED));
            pb.setProgress(index);
            tv.setText("Crowded");
            tv.setTextColor(ColorStateList.valueOf(Color.RED));
        } else {

        }


    }

    private void showVisitTime() {
        fl.removeAllViews();

        LayoutInflater.from(getContext()).inflate(R.layout.activity_visit_time, fl, true);
    }

    private void showWaitingTime() {
        fl.removeAllViews();

        LayoutInflater.from(getContext()).inflate(R.layout.activity_waiting_time, fl, true);
    }
}
