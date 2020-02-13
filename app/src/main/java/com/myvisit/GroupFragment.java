package com.myvisit;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class GroupFragment extends messagesFragment {
    private View groupFragmentView;
    private ListView list_view;
    private ArrayAdapter arrayAdpater;
    private ArrayList<Person> list_of_groups = new ArrayList<>();

    private DatabaseReference GroupRef;

    private static final String TAG = "adapter_view_layout";

    public GroupFragment(){

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        groupFragmentView = inflater.inflate(R.layout.adapter_view_layout, container, false);

        Log.d(TAG, "onCreate: Started.");
        list_view = (ListView) groupFragmentView.findViewById(R.id.list_view);

        Person john = new Person("Jogn","12-20-1987","Male");
        Person stave = new Person("stave","01-03-1981","Male");
        Person stacy = new Person("stacy","11-08-1985","Female");

        list_of_groups.add(john);
        list_of_groups.add(stave);
        list_of_groups.add(stacy);

        //PersonListAdapter adpater = new PersonListAdapter(this , R.layout.adapter_view_layout, list_of_groups );
        //list_view.setAdapter(adpater);

        /*GroupRef = FirebaseDatabase.getInstance().getReference().child("Group");

        InitializeFields();

       RetrieveAndDisplayGroups();

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id)
            {
                //String currentGroupName = adapterView.getItemAtPosition(position).toString();

                Intent groupChatIntent = new Intent(getContext(), GroupChatActivity.class);
                //groupChatIntent.putExtra("groupName" , currentGroupName);
                startActivity(groupChatIntent);

            }
        });*/

        return groupFragmentView;

    }

    private void RetrieveAndDisplayGroups()
    {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void InitializeFields()
    {
        list_view = (ListView) groupFragmentView.findViewById(R.id.list_view);
        //arrayAdpater = new ArrayAdapter<String>(getContext(), android.R.layout.);
        list_view.setAdapter(arrayAdpater);
    }


}
