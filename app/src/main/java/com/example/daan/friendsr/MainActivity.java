package com.example.daan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Friend> friends = new ArrayList<>();

        int resID = getResources().getIdentifier("arya","drawable",getPackageName());
        int resID1 = getResources().getIdentifier("cersei","drawable",getPackageName());
        int resID2 = getResources().getIdentifier("daenerys","drawable",getPackageName());
        int resID3 = getResources().getIdentifier("jaime","drawable",getPackageName());

        friends.add(new Friend("arya","fat",resID));
        friends.add(new Friend("cersei","fatt",resID1));
        friends.add(new Friend("daenerys","fattt",resID2));
        friends.add(new Friend("jaime","fattt",resID3));
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid = findViewById(R.id.friend_pictures);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new GridItemClickListener());


    }
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int i = position;
            Friend clickedFriend = (Friend) parent.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
            //finish();
        }
    }

}
