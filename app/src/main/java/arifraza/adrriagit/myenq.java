package arifraza.adrriagit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class myenq extends AppCompatActivity {

    DatabaseReference databaseReports;
    FirebaseAuth mAuth;
    ListView listViewMessages;
    List<msg> messageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myenq);
        setTitle("My Enquiries");
        mAuth = FirebaseAuth.getInstance();


       // final FirebaseUser user4 = mAuth.getCurrentUser();
        //String mmg=user4.getEmail().toString();

        listViewMessages = (ListView) findViewById(R.id.listViewReports6);
        messageList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("messages");

        open393();

    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            messageList.clear();
            if (dataSnapshot.exists()) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    msg msg = postSnapshot.getValue(msg.class);

                    messageList.add(msg);
                }

                MessageList adapter = new MessageList(myenq.this, messageList);
                listViewMessages.setAdapter(adapter);

            }
            else
            {
                open230();
            }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };



    public void open393() {
        //textView3 = (TextView) findViewById(R.id.textView3);

        final FirebaseUser user3 = mAuth.getCurrentUser();
        String deml2=user3.getEmail().toString();

        Query query= FirebaseDatabase.getInstance().getReference("messages")
                .orderByChild("seml")
                .equalTo(deml2);


        query.addListenerForSingleValueEvent(valueEventListener);

    }

    public void open230() {

        Toast.makeText(this, "No Message found", Toast.LENGTH_LONG).show();

    }

}
