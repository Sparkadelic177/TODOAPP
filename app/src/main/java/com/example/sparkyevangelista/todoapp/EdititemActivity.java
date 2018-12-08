package com.example.sparkyevangelista.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.sparkyevangelista.todoapp.TODO.ITEM_POSITION;
import static com.example.sparkyevangelista.todoapp.TODO.ITEM_TEXT;

public class EdititemActivity extends AppCompatActivity {

    //track edit text
    EditText etEditText;

    //position of edited item on the list
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititem);

        ///resolve the edit text on the layout
        etEditText = (EditText) findViewById(R.id.etEditText);

        //setting the text from the last list to the text input to edit
        etEditText.setText(getIntent().getStringExtra(ITEM_TEXT));

        //update position from intent extra
        position = getIntent().getIntExtra(ITEM_POSITION, 0);

        //setting the new title for this activity
        getSupportActionBar().setTitle("Edit Item");

    }

    //handler for save button
    public void onSaveItem(View v){
        //preparing a new intent
        Intent i = new Intent(EdititemActivity.this, TODO.class);

        //pass updated item text as extra
        i.putExtra(ITEM_TEXT, etEditText.getText().toString());
        //passing the position so that the other activity know what to do with it / where to put it
        i.putExtra(ITEM_POSITION, position);
        //send the Intent as the result of the activity
        setResult(RESULT_OK, i);
        //close the activity
        this.finish();
    }
}


