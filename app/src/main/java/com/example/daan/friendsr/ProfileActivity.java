package com.example.daan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_profile);

                // Extract friend information of what friend actually was clicked on and put it in the right profile views.
                Intent intent = getIntent();
                final Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

                ImageView image = findViewById(R.id.image_profile);
                TextView text = findViewById(R.id.text_profile);
                TextView text2 = findViewById(R.id.text2_profile);
                Drawable image_id = getResources().getDrawable(retrievedFriend.getDrawableId(),null);
                image.setImageDrawable(image_id);
                text.setText(retrievedFriend.getName());
                text2.setText(retrievedFriend.getBio());

                // Store inputted rating data in SharedPreferences and get rating data from it.
                final SharedPreferences prefs = getSharedPreferences(retrievedFriend.getName(), MODE_PRIVATE);
                RatingBar ratingBar = findViewById(R.id.rating_profile);
                Float rating = prefs.getFloat("rating", 0);
                if (rating != 0) {
                    // We have something stored under "rating".
                    ratingBar.setRating(rating);
                }
                else {
                    // There is nothing stored under "rating".
                    ratingBar.setRating(0);

                }
                // Edit ratingbar if ratingbar is changed.
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



