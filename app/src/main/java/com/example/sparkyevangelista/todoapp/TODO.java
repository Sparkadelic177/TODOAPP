package com.example.sparkyevangelista.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.util.*;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.io.File;

/**
 * Find out what other apis I can use to make the todo app easier, better
 * Find out about some java css to style components
 */

public class TODO extends AppCompatActivity {

    ArrayList<String> items; //going to house the data the user has entered
    ArrayAdapter<String> itemsAdapter; //transfers the data from the array to the list view
    ListView listItems; //displays the data to the user

    //this is called when starting up the application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //to AppCompatActivity
        setContentView(R.layout.activity_todo);

        readItems();//initalzing the items object and connecting it to a flile
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);//(this is reference to the main activity/ type of item this adapter will wrap / item list just created)
        listItems = findViewById(R.id.listItems); //referencing the instance of the list view on the ui
        listItems.setAdapter(itemsAdapter); //connecting the adapter to the list View

        setupListViewListener();
    }


    public void addItem(View v) {
        EditText textInput = findViewById(R.id.textInput); //connecting the text input box on the ui
        String itemText = textInput.getText().toString(); //returning the text from the user as a string
        itemsAdapter.add(itemText); //adding to the text to the adapter
        textInput.setText(""); //clearing the text
        writeItems();
        Toast.makeText(getApplicationContext(), "Text Added to the list", Toast.LENGTH_SHORT).show(); //user notification of completion

    }

    private void setupListViewListener() {
        Log.i("TODO", " Setting up the Listner on list View"); //* logging is used to debug information about your app
        listItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("TODO", "Item removed from the list " + position);
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();//letting the adapter know something was changed in the referenced object
                writeItems(); //rewrite the new list to the file
                return true;
            }
        });
    }


    /**
     * read and write items method is used to add persistance to the application and
     * save the data input by the user
     */

    //this method creates a file
    private File getDataFiles() {
        return new File(getFilesDir(), "todo.txt");
    }

    //method is used to readitems to from the file
    private void readItems() {
        //reads files contents one line at a time and returns them as a list of string
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFiles(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("TODO", "There was an input/output error in readItems method: " + e); //logging it as an error
            items = new ArrayList<>(); //just to make sure the object was instantiated correctly
        }
    }

    //this method is used to write items to the file
    private void writeItems() {
        try {
            FileUtils.writeLines(getDataFiles(), items);
        } catch (IOException e) {
            Log.e("TODO", "There was an input/output error in writeItems method: " + e);
        }
    }
}
