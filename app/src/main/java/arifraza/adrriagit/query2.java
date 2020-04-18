package arifraza.adrriagit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class query2 extends AppCompatActivity {
    DatabaseReference databaseReports;

    ListView listViewUsers;
    List<user> userList;

    EditText editText16;
    Button button13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query2);

        setTitle("Search a USER");

        editText16 = (EditText) findViewById(R.id.editText16);


        listViewUsers = (ListView) findViewById(R.id.listViewReports3);
        userList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("users");


        button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open534();
            }
        });

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            userList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    user user = postSnapshot.getValue(user.class);

                    userList.add(user);
                }
                UserList adapter = new UserList(query2.this, userList);
                listViewUsers.setAdapter(adapter);

            }
            else
            {
                open6666();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };



    public void open534() {

        Query query= FirebaseDatabase.getInstance().getReference("users")
                .orderByChild("deml")
                .equalTo(editText16.getText().toString());


        query.addListenerForSingleValueEvent(valueEventListener);


    }
    public void open6666() {

        editText16.setError("No record found for this name");
        editText16.requestFocus();
        // Toast.makeText(this, "No record found for PID", Toast.LENGTH_LONG).show();

    }


}
