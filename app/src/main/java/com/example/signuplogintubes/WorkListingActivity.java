package com.example.signuplogintubes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class WorkListingActivity extends AppCompatActivity {

    ImageButton close;
    Button workList_addButton;
    EditText work_listing,work_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_listing);

        close =findViewById(R.id.close);
        work_listing =findViewById(R.id.work_listing);
        workList_addButton =findViewById(R.id.workList_addButton);
        work_time =findViewById(R.id.work_time);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkListingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        workList_addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });
        
    }

    public void uploadData() {

        String workList = work_listing.getText().toString();
        String workTime = work_time.getText().toString();

        DataWorkClass dataWorkClass = new DataWorkClass(workList, workTime);

        FirebaseDatabase.getInstance().getReference("work List").child(workList)
                .setValue(dataWorkClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(WorkListingActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(WorkListingActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}