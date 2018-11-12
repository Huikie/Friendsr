package com.example.daan.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    ArrayList<Friend> friends;
    //Constructor
    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        int index = position;
        ImageView image = convertView.findViewById(R.id.image);
        TextView text = convertView.findViewById(R.id.text);
        text.setText(friends.get(index).getName());
        Drawable image_id = getContext().getResources().getDrawable(friends.get(index).getDrawableId(),null);
        image.setImageDrawable(image_id);
        return convertView;
    }
}
