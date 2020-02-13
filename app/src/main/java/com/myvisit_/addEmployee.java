package com.myvisit_;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class addEmployee extends AppCompatActivity {
    private static final String TAG = "addEmployee";

    private EditText textCard, textFullName, textMobile, textEmail, textPosition;
    private Button btnAdd;

    //private FirebaseDatabase mFirebaseDatabase;
    //private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    //private DatabaseReference myRef;

    private FirebaseFirestore fstore;
    private DatabaseReference myRef;
    private FirebaseDatabase mFirebaseDatabase;
    private CollectionReference colRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee);

        //myRef = FirebaseDatabase.getInstance().getReference("Employee");

        fstore = FirebaseFirestore.getInstance();

        textCard =  (EditText)findViewById(R.id.text_card);
        textFullName = (EditText) findViewById(R.id.text_fullname);
        textMobile = (EditText) findViewById(R.id.text_mobile);
        textEmail = (EditText) findViewById(R.id.text_email);
        textPosition = (EditText) findViewById(R.id.text_position);

        //mFirebaseDatabase = FirebaseDatabase.getInstance();
        //myRef = mFirebaseDatabase.getReference();
        //fstore = FirebaseFirestore.getInstance();
        //colRef = fstore.collection("Employee");

       // myRef = FirebaseDatabase.getInstance().getReference();

        btnAdd = (Button) findViewById(R.id.button);

        //btnAdd.setOnClickListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 addUser2();
            }
        });
    }

    public void addUser2(){
        String card = textCard.getText().toString();
        String fullName = textFullName.getText().toString();
        String mobile = textMobile.getText().toString();
        String email = textEmail.getText().toString();
        String position = textPosition.getText().toString();

        if(!TextUtils.isEmpty(card) && !TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(position)    ) {

            Map<String, String> userMap = new HashMap<>();

            userMap.put("id", card);
            userMap.put("fname", fullName);
            userMap.put("mobile", mobile);
            userMap.put("email", email);
            userMap.put("position", position);

            fstore.collection("Employee").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_LONG).show();


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            });

            Intent i = new Intent(getApplicationContext(), Fragment1.class);
            startActivity(i);

            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            //f.replace(R.id.fragment_container, new messagesFragment());
            //f.commit();

        }else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

        }
    }

    public void addUser(){
        String card = textCard.getText().toString();
        String fullName = textFullName.getText().toString();
        String mobile = textMobile.getText().toString();
        String email = textEmail.getText().toString();
        String position = textPosition.getText().toString();

        if(!TextUtils.isEmpty(card) && !TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(position)    ){

            String id = myRef.push().getKey();
            UserInformation userInformation = new UserInformation(card, fullName, mobile, email, position);
            myRef.child(id).setValue(userInformation);
            textCard.setText("");
            textFullName.setText("");
            textMobile.setText("");
            textEmail.setText("");
            textPosition.setText("");

            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_LONG).show();

            Intent i = new Intent(getApplicationContext(),Fragment1.class);
            startActivity(i);

        }else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

        }
    }

    public void addUser3(){
        //String card = Integer.parseInt(textCard.getText().toString());
        String card = textCard.getText().toString();
        String fullName = textFullName.getText().toString();
        //String mobile = Integer.parseInt(textMobile.getText().toString());
        String mobile = textMobile.getText().toString();
        String email = textEmail.getText().toString();
        String position = textPosition.getText().toString();

        if(!TextUtils.isEmpty(card) && !TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(position)    ){

            String id = myRef.push().getKey();
            UserInformation userInformation = new UserInformation(card, fullName, mobile, email, position);
            myRef.child(id).setValue(userInformation);
            textCard.setText("");
            textFullName.setText("");
            textMobile.setText("");
            textEmail.setText("");
            textPosition.setText("");

            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_LONG).show();

            Intent i = new Intent(getApplicationContext(),Fragment1.class);
            startActivity(i);

        }else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

        }
    }

    //@Override
    public void onClick(View v) {

        /*colRef.add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), " Error", Toast.LENGTH_LONG).show();
            }
        });

         */


/*


                colRef.document("1").set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), " Error", Toast.LENGTH_SHORT).show();

                    }
                });
*/
        textCard =  (EditText)v.findViewById(R.id.text_card);
        textFullName = (EditText) v.findViewById(R.id.text_fullname);
        textMobile = (EditText) v.findViewById(R.id.text_mobile);
        textEmail = (EditText) v.findViewById(R.id.text_email);
        textPosition = (EditText) v.findViewById(R.id.text_position);

                String card = textCard.getText().toString();
                String fullName = textFullName.getText().toString();
                String mobile = textMobile.getText().toString();
                String email = textEmail.getText().toString();
                String position = textPosition.getText().toString();

        UserInformation userInformation = new UserInformation(card, fullName, mobile, email, position);

        myRef.child("Employee").setValue(userInformation)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_LONG).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });

        switch (v.getId()){
            case R.id.button:
                Intent i = new Intent(getApplicationContext(),Fragment1.class);
                startActivity(i);
                break ;

        }


    }


}



        /*if(TextUtils.isEmpty(card)){
                    textCard.setError("Id number is required.");
                    return;
                }

                if(TextUtils.isEmpty(fullName)){
                    textFullName.setError(" number is required.");
                    return;
                }

                if(TextUtils.isEmpty(mobile)){
                    textMobile.setError("Full name is required.");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    textEmail.setError("Email is required.");
                    return;
                }

                if(TextUtils.isEmpty(position)){
                    textPosition.setError("position is required.");
                    return;
                }
*/

        /*UserInformation userInformation = new UserInformation(card, fullName, mobile, email, position);

        fstore.collection("Employee").document("emp4").set(userInformation)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_LONG).show();

                            //Intent i = new Intent(getApplicationContext(),Fragment1.class);
                            //startActivity(i);

                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });



         */

        /*fstore.collection("Employee")
                .add(userMap)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "Add successfully with ID: " + documentReference.getId());
                        Intent i = new Intent(getApplicationContext(),Fragment1.class);
                        startActivity(i);

                        Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_SHORT).show();


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
*/
        //DocumentReference df = fstore.collection("Employee").document("emp4");

        //userInformation.setId(card);
        //userInformation.setFname(fullName);
        //userInformation.setPhone_num(mobile);
        //userInformation.setEmail(email);
        //userInformation.setPosition(position);

        /*df.set(userInformation).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent i = new Intent(getApplicationContext(),Fragment1.class);
                    startActivity(i);
                    //Toast.makeText(addEmployee.this, "add Employee successfull " , Toast.LENGTH_SHORT).show();
                }
                else{
                    //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

         */




                /*

                if(!card.equals("") && !fullName.equals("") && !mobile.equals("") && !email.equals("") && !position.equals("")){
                    UserInformation userInformation = new UserInformation(card,fullName,mobile,email,position);

                    myRef.child("Employee").setValue(userInformation);
                    Toast.makeText(getApplicationContext(),"New Information has been saved.",Toast.LENGTH_SHORT).show();
                    textCard.setText("");
                    textFullName.setText("");
                    textMobile.setText("");
                    textEmail.setText("");
                    textPosition.setText("");
                }else{
                    Toast.makeText(getApplicationContext(),"Fill out all the fields",Toast.LENGTH_SHORT).show();
                    //toastMessage("Fill out all the fields");
                }

               */