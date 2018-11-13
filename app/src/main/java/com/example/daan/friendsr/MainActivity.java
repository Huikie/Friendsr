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
        int resID4 = getResources().getIdentifier("jon","drawable",getPackageName());
        int resID5 = getResources().getIdentifier("jorah","drawable",getPackageName());
        int resID6 = getResources().getIdentifier("margaery","drawable",getPackageName());
        int resID7 = getResources().getIdentifier("melisandre","drawable",getPackageName());
        int resID8 = getResources().getIdentifier("sansa","drawable",getPackageName());
        int resID9 = getResources().getIdentifier("tyrion","drawable",getPackageName());

        friends.add(new Friend("arya","I'm Arya and I'm foxy",resID));
        friends.add(new Friend("cersei","I'm Cersei and I'm powerfull",resID1));
        friends.add(new Friend("daenerys","I'm Deanerys and I'm good",resID2));
        friends.add(new Friend("jaime","I'm Jaime and I'm a soldier",resID3));
        friends.add(new Friend("jon","I'm Jon and no one knows me",resID4));
        friends.add(new Friend("jorah","I'm the same as Jon",resID5));
        friends.add(new Friend("margaery","I'm nice",resID6));
        friends.add(new Friend("melisandre","I'm nice too",resID7));
        friends.add(new Friend("sansa","I'm mean",resID8));
        friends.add(new Friend("tyrion","I'm wise",resID9));

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
