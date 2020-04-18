package arifraza.adrriagit;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Date;
import java.util.Calendar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    DatabaseReference databaseReports;
    FirebaseAuth mAuth44;
    ListView listViewReports;
    List<report> reportList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("All Reports");

        listViewReports = (ListView) findViewById(R.id.listViewReports);

        reportList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("reports");
        mAuth44 = FirebaseAuth.getInstance();

        //added for update

        listViewReports.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //confusion below in reportList or reports or artists

                report report = reportList.get(adapterView.getCount()-i-1);

                showUpdateDialog(report.getpId(), report.getass3(),report.getpName(),report.getrct(),report.getcst());
                return true;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseReports.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                reportList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    report report = postSnapshot.getValue(report.class);

                    reportList.add(report);
                }

                ReportList adapter = new ReportList(Activity2.this,reportList);
                listViewReports.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


//for update
    private void showUpdateDialog(final String artistId, String ass3,String artistName, String rct,String cst) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editText9 = (EditText) dialogView.findViewById(R.id.editText9);
        final EditText editText10 = (EditText) dialogView.findViewById(R.id.editText10);
        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editText2 = (EditText) dialogView.findViewById(R.id.editText2);
        final EditText editText4 = (EditText) dialogView.findViewById(R.id.editText4);
        final EditText editText12 = (EditText) dialogView.findViewById(R.id.editText12);
        final FirebaseUser user444 = mAuth44.getCurrentUser();
        editText9.setText(user444.getDisplayName().toString());
        editText10.setText(user444.getEmail().toString());


        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);


        dialogBuilder.setTitle("Assessment of Patient ID :"+artistName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        String nas2 = "";
        DatabaseReference dR4 = FirebaseDatabase.getInstance().getReference("reports").child(artistId).child("nas");
        dR4.setValue(nas2);


        //here
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String ass3 = editText9.getText().toString();
                String asse = editText10.getText().toString();
                String name = editTextName.getText().toString().trim();
                String rct = editText2.getText().toString();
                String cst = editText4.getText().toString();
                String arem = editText12.getText().toString();
                Date currentTime = Calendar.getInstance().getTime();


                String dat2=currentTime.toString();
                if (!TextUtils.isEmpty(name)) {
                    updateArtist(artistId,ass3, asse,name,rct,cst,arem,dat2);
                    b.dismiss();
                }
            }
        });

        //here

    }

    //below is the update button insde dialog
    //causing error
    private boolean updateArtist(String id, String ass3,String asse,String dnm,String rct, String cst,String arem,String dat2) {
        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("reports").child(id).child("dnm");


        //updating artist
        //report report = new report(id, name);
        dR.setValue(dnm);
        DatabaseReference dR2 = FirebaseDatabase.getInstance().getReference("reports").child(id).child("rct");
        dR2.setValue(rct);
        DatabaseReference dR3 = FirebaseDatabase.getInstance().getReference("reports").child(id).child("cst");
        dR3.setValue(cst);

        DatabaseReference dR7 = FirebaseDatabase.getInstance().getReference("reports").child(id).child("ass3");
        dR7.setValue(ass3);
        DatabaseReference dR22 = FirebaseDatabase.getInstance().getReference("reports").child(id).child("asse");
        dR22.setValue(asse);
        DatabaseReference dR232 = FirebaseDatabase.getInstance().getReference("reports").child(id).child("arem");
        dR232.setValue(arem);

        DatabaseReference dR2324 = FirebaseDatabase.getInstance().getReference("reports").child(id).child("dat2");
        dR2324.setValue(dat2);



        Toast.makeText(getApplicationContext(), "Pharmacologist's Assesment Added", Toast.LENGTH_LONG).show();
        return true;
    }


}
