package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.firebasegetdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import bt.bootcampfinalexam.R;

public class FirebaseGetDataActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewPersons;
    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_get_data);

        buttonSave = (Button) findViewById(R.id.buttonSave);

        textViewPersons = (TextView) findViewById(R.id.textViewPersons);

        Firebase.setAndroidContext(this);
        buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Firebase  ref = new Firebase(Config.FIREBASE_URL);
        ref.addValueEventListener(new com.firebase.client.ValueEventListener() {

            @Override
            public void onDataChange(com.firebase.client.DataSnapshot snapshot) {
                for (com.firebase.client.DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    Person person = postSnapshot.getValue(Person.class);

                    //Adding it to a string
                    String string = "İsim: "+person.getName()+"\nAdres: "+person.getAddress()+"\n\n";

                    //Displaying it on textview
                    textViewPersons.setText(string);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }
}