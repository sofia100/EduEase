package com.example.android.eduease;


import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.eduease.R;
import com.example.android.eduease.TeacherDataRetrieve;

import java.util.ArrayList;

public class objAdapter extends ArrayAdapter<TeacherDataRetrieve> {

    objAdapter(Context context, ArrayList<TeacherDataRetrieve> w)
    {
        super(context,0,w);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        TeacherDataRetrieve currentWord = getItem(position);
        //androidflavor=words


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getName());
        nameTextView.setTextSize(18);
        nameTextView.setTypeface(Typeface.DEFAULT_BOLD);
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeToTextView = (TextView) listItemView.findViewById(R.id.time_to);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        timeToTextView.setText(currentWord.getTimeTo());

        TextView timeFrmTextView = (TextView) listItemView.findViewById(R.id.time_from);
        timeFrmTextView.setText(currentWord.getTimeFrom());





      /*  View textContainer =listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),cid);
        textContainer.setBackgroundColor(color);
       */
      return listItemView;
    }
}
