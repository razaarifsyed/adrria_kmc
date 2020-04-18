package arifraza.adrriagit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cusrs extends AppCompatActivity {

    DatabaseReference databaseReports;

    ListView listViewUsers;
    List<user> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusrs);
        setTitle("User Accounts");

        listViewUsers = (ListView) findViewById(R.id.listViewUsers);
        userList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("users");
    }



    @Override
    protected void onStart() {
        super.onStart();
        databaseReports.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                   user user = postSnapshot.getValue(user.class);

                    userList.add(user);
                }

                UserList adapter = new UserList(cusrs.this, userList);
                listViewUsers.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




}
