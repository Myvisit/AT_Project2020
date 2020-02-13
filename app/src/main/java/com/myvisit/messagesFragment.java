package com.myvisit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class messagesFragment extends Fragment {
    private View messageFragmentView;
    private Button buttonGroup ;

    public View onCreateView( LayoutInflater inflater,
                              @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        messageFragmentView = inflater.inflate(R.layout.fragment_messages, container, false);


        //buttonGroup = (Button) messageFragmentView.findViewById(R.id.buttonGroup);
        /*buttonGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextAc();
            }
        });*/

        return messageFragmentView;

    }

    private void openNextAc()
    {
        Intent intent = new Intent(getActivity(), GroupFragment.class);
        startActivity(intent);
    }

}
