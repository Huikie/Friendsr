package com.example.daan.friendsr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView image = findViewById(R.id.image_profile);
        TextView text = findViewById(R.id.text_profile);
        TextView text2 = findViewById(R.id.text2_profile);
        Drawable image_id = getResources().getDrawable(retrievedFriend.getDrawableId(),null);
        image.setImageDrawable(image_id);
        text.setText(retrievedFriend.getName());
        text2.setText(retrievedFriend.getBio());

        final SharedPreferences prefs = getSharedPreferences(retrievedFriend.getName(), MODE_PRIVATE);
        RatingBar ratingBar = findViewById(R.id.rating_profile);
        Float rating = prefs.getFloat("rating", 0);
        if (rating != 0) {
            // we have something stored under "example_key"
            ratingBar.setRating(rating);
        }
        else {
            // there is nothing stored under "example_key"
            ratingBar.setRating(0);

        }
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                SharedPreferences.Editor editor;
                editor = prefs.edit();
                editor.putFloat("rating", rating);
                editor.apply();
            }
        });

    }

    }



