package arifraza.adrriagit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class passw extends AppCompatActivity {

    DatabaseReference databaseReports;
    DatabaseReference databaseReports5;
    EditText editTextp;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passw);
        setTitle("Authentication");


        //databaseReports = FirebaseDatabase.getInstance().getReference("password");
        databaseReports5 = FirebaseDatabase.getInstance().getReference("pass");

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open222();

            }
        });



    }




    public void open222() {

        databaseReports5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);


               // textView30.setText(value);

                editTextp = (EditText) findViewById(R.id.p1);
                String pass = editTextp.getText().toString();
                if (pass.equals(value)) {
                    editTextp.setText("");
                    open332();
                } else {
                    open331();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                }
        });







    }
    public void open332() {

        Intent intent = new Intent(this, admin.class);
        startActivity(intent);
    }

    public void open331() {

        editTextp.setError("Wrong Password");
        editTextp.requestFocus();

    }


}
