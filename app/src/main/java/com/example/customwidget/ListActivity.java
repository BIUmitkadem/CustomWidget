package com.example.customwidget;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends Activity {

    final private int[] profilePictures = {
            R.drawable.blue, R.drawable.gold, R.drawable.green,
            R.drawable.red, R.drawable.lightblue, R.drawable.pink
    };

    final private String[] userNames = {
            "Blue User", "Golden User", "Green User", "Red User", "Lightblue User", "Pink User"
    };

    final private String[] lastMassages = {
            "Hi, how are you?", "24K Magic", "I'm GREEN!", "Red is my name", "wasap :)", "Yo!"
    };

    final private String[] times = {
            "12:00", "00:30", "3:23", "8:59", "14:52", "12:23"
    };

    ListView listView;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < profilePictures.length; i++) {
            User aUser = new User(
                    userNames[i], profilePictures[i],
                    lastMassages[i], times[i]
            );

            users.add(aUser);
        }

        listView = findViewById(R.id.list_view);
        adapter = new CustomListAdapter(getApplicationContext(), users);

        listView.setAdapter(adapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);

                intent.putExtra("userName", userNames[i]);
                intent.putExtra("profilePicture", profilePictures[i]);
                intent.putExtra("lastMassage", lastMassages[i]);
                intent.putExtra("time", times[i]);

                startActivity(intent);
            }
        });
    }
}