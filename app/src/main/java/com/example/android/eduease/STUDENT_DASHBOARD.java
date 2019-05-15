package com.example.android.eduease;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class STUDENT_DASHBOARD extends AppCompatActivity {
String TAG = "STUDENT_DASHBOARD";
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);

        Intent intent = getIntent();
        String subj = intent.getStringExtra("subject");

        database= FirebaseDatabase.getInstance();
        myRef = database.getReference(subj);//subject


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
               // TeacherDataUpload value = dataSnapshot.getValue(TeacherDataUpload.class);

                collectNames((Map<String,TeacherDataUpload>) dataSnapshot.getValue());

              //  Toast.makeText(getApplicationContext(),"teacher is "+value.getName(),Toast.LENGTH_SHORT).show();


               // Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getApplicationContext(),"error in retrieving",Toast.LENGTH_SHORT).show();

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    private void collectNames(Map<String,TeacherDataUpload> users) {

        ArrayList<String> names = new ArrayList<>();

        ArrayList<String> timeTo = new ArrayList<>();

        ArrayList<String> timeFrom = new ArrayList<>();

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, TeacherDataUpload> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            names.add((String) singleUser.get("name"));
            timeFrom.add((String) singleUser.get("timeFRom"));
            timeTo.add((String) singleUser.get("timeTo"));
        }
       /* Toast.makeText(getApplicationContext(),"teacher is "+names.toString(),Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"FROM TIME is "+timeFrom.toString(),Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(),"TO TIME is "+timeTo.toString(),Toast.LENGTH_SHORT).show();
*/
       // System.out.println(names.toString());

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = audioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mediaPlayer = MediaPlayer.create(getActivity(), word.getVid());

                    // Start the audio file
                    mediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }
}
