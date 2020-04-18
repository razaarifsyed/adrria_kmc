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

public class rmessage extends AppCompatActivity {


    DatabaseReference databaseReports;
    FirebaseAuth mAuth44;

    ListView listViewMessages;
    List<msg> messageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmessage);
        setTitle("All Enquiries");


        listViewMessages = (ListView) findViewById(R.id.listViewMessages);





        messageList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("messages");
        mAuth44 = FirebaseAuth.getInstance();

        // new message below


        listViewMessages.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //confusion below in reportList or reports or artists

                msg msg = messageList.get(adapterView.getCount()-i-1);

                readff(msg.getmId(),msg.getrdd());
                showUpdateDialog2(msg.getmId(), msg.getrnm2(),msg.getmname());
                return true;
            }
        });

//till here new read msg



    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseReports.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                messageList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    msg msg = postSnapshot.getValue(msg.class);

                    messageList.add(msg);
                }

                MessageList adapter = new MessageList(rmessage.this, messageList);
                listViewMessages.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

        //read message

        private void readff(final String mId, String rdd){


            String rdd2 = "";
            readff2(mId, rdd2);


    }

    private boolean readff2(String mId, String rdd2){
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("messages").child(mId).child("rdd");


        //updating artist
        //report report = new report(id, name);
        dR.setValue(rdd2);
        return true;


    }

        //end read mssg here



    private void showUpdateDialog2(final String artistId, String ass3,String artistName ) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog2, null);
        dialogBuilder.setView(dialogView);

        final EditText editText20 = (EditText) dialogView.findViewById(R.id.editText20);
        final EditText editText21 = (EditText) dialogView.findViewById(R.id.editText21);
        final EditText editText19 = (EditText) dialogView.findViewById(R.id.editText19);


        final FirebaseUser user444 = mAuth44.getCurrentUser();
        editText20.setText(user444.getDisplayName().toString());
        editText21.setText(user444.getEmail().toString());


        final Button buttonUpdate2 = (Button) dialogView.findViewById(R.id.buttonUpdate2);


        dialogBuilder.setTitle("Enquiry of :"+artistName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        String nas2 = "";
        DatabaseReference dR4 = FirebaseDatabase.getInstance().getReference("messages").child(artistId).child("rdd");
        dR4.setValue(nas2);


        //here
        buttonUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String ass3 = editText20.getText().toString();
                String asse = editText21.getText().toString();


                String arem = editText19.getText().toString();
                if (!TextUtils.isEmpty(arem)) {
                    updateArtist2(artistId,ass3, asse,arem);
                    b.dismiss();
                }



            }
        });

        //here

    }

    //below is the update button insde dialog
    //causing error
    private boolean updateArtist2(String id, String ass3,String asse,String arem) {
        //getting the specified artist reference



        //updating artist
        //report report = new report(id, name);


        DatabaseReference dR7 = FirebaseDatabase.getInstance().getReference("messages").child(id).child("rnm2");
        dR7.setValue(ass3);
        DatabaseReference dR22 = FirebaseDatabase.getInstance().getReference("messages").child(id).child("rml2");
        dR22.setValue(asse);
        DatabaseReference dR232 = FirebaseDatabase.getInstance().getReference("messages").child(id).child("mmsg2");
        dR232.setValue(arem);


        Date currentTime = Calendar.getInstance().getTime();
        String dat2 = currentTime.toString();

        DatabaseReference dR89 = FirebaseDatabase.getInstance().getReference("messages").child(id).child("dat2");
        dR89.setValue(dat2);



        Toast.makeText(getApplicationContext(), "Question Answered Successfully!", Toast.LENGTH_LONG).show();
        return true;
    }




}


