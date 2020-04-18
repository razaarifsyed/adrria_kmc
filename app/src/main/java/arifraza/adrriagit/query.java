package arifraza.adrriagit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
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


public class query extends AppCompatActivity {


    DatabaseReference databaseReports;

    ListView listViewReports;
    List<report> reportList;
    EditText editText15;
    Button button11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        setTitle("Search Report");

        editText15 = (EditText) findViewById(R.id.editText15);

        listViewReports = (ListView) findViewById(R.id.listViewReports2);

        reportList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("reports");

        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open534();
            }
        });

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

                ReportList adapter = new ReportList(query.this,reportList);
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

        Query query= FirebaseDatabase.getInstance().getReference("reports")
                .orderByChild("pName")
                .equalTo(editText15.getText().toString());


        query.addListenerForSingleValueEvent(valueEventListener);


    }
    public void open6666() {

        editText15.setError("No record found for PID");
        editText15.requestFocus();
       // Toast.makeText(this, "No record found for PID", Toast.LENGTH_LONG).show();

    }


    }



