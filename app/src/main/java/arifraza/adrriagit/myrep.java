package arifraza.adrriagit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.widget.ListView;
import android.widget.TextView;
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


public class myrep extends AppCompatActivity {
    DatabaseReference databaseReports;
    FirebaseAuth mAuth;
    ListView listViewReports;
    List<report> reportList;
    TextView textView543;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrep);
        mAuth = FirebaseAuth.getInstance();
        setTitle("My Reports");

        listViewReports = (ListView) findViewById(R.id.listViewReports5);

        reportList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("reports");


        textView543 = (TextView) findViewById(R.id.textView12);
        final FirebaseUser user4 = mAuth.getCurrentUser();
        textView543.setText(user4.getDisplayName().toString());

        open534();

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


            reportList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    report report = postSnapshot.getValue(report.class);

                    reportList.add(report);
                }

                ReportList adapter = new ReportList(myrep.this,reportList);
                listViewReports.setAdapter(adapter);

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


        final FirebaseUser user3 = mAuth.getCurrentUser();
        String deml2=user3.getEmail().toString();

        Query query= FirebaseDatabase.getInstance().getReference("reports")
                .orderByChild("rml")
                .equalTo(deml2);


        query.addListenerForSingleValueEvent(valueEventListener);


    }
    public void open6666() {

        Toast.makeText(this, "No records found", Toast.LENGTH_LONG).show();

    }


}
