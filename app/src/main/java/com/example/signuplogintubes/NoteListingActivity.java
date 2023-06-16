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

public class NoteListingActivity extends AppCompatActivity {

    ImageButton close;
    Button noteList_addButton;
    EditText note_listing,note_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_listing);

        close =findViewById(R.id.close);
        note_listing =findViewById(R.id.note_listing);
        noteList_addButton =findViewById(R.id.noteList_addButton);
        note_time =findViewById(R.id.note_time);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteListingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        noteList_addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });


    }

    public void uploadData(){

        String noteList = note_listing.getText().toString();
        String noteTime = note_time.getText().toString();

        DataClass dataClass = new DataClass(noteList,noteTime);

        FirebaseDatabase.getInstance().getReference("Note List").child(noteList)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(NoteListingActivity.this,"Saved",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(NoteListingActivity.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}