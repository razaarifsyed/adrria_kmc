package arifraza.adrriagit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin extends AppCompatActivity {
    Toolbar toolbar;
    FirebaseAuth mAuth;
    Button button3;
    Button button4;
    Button button333;
    Button button9;
    Button button10;
    Button button12;
    int ab;
    String v3;
    DatabaseReference databaseReports;
    DatabaseReference databaseReports22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        databaseReports = FirebaseDatabase.getInstance().getReference("rpno");
        //databaseReports22 = FirebaseDatabase.getInstance().getReference("usertot");

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        mAuth = FirebaseAuth.getInstance();
        setTitle("");


        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3();
            }
        });



        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open902();
            }
        });

        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open802();
            }
        });


        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openm9();
            }
        });



        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open210();
            }
        });

    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

       }



    public void open3() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

}

    public void open210() {


        Intent intent = new Intent(this, cusrs.class);
        startActivity(intent);

    }


    public void openm9() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, rmessage.class);
        startActivity(intent);

    }



    public void open902() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, query.class);
        startActivity(intent);

    }

    public void open802() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, query2.class);
        startActivity(intent);

    }



    public void openf1(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (!isFinishing()){
                    String msg="If you have any feedback/doubt. Or if you want to request a new feature. Then you can reach us by email at "+"\n"+"\n"+"navin.patil@manipal.edu "+"\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"or"+"\n"+"razaarifsyed@gmail.com";
                    final SpannableString s = new SpannableString(msg);
                    Linkify.addLinks(s, Linkify.ALL);


                    final AlertDialog d =new AlertDialog.Builder(admin.this,R.style.AlertDialogStyle)
                            .setTitle("Feedback")
                            .setMessage(s)
                            .setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Whatever...
                                }
                            }).show();
                    ((TextView)d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());


                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu_2,menu);

        MenuItem sinm = menu.findItem(R.id.m1);
        final FirebaseUser user323 = mAuth.getCurrentUser();
        String saa=user323.getDisplayName().toString();

        SpannableString content = new SpannableString("(Signed in As:"+saa+")" );
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        sinm.setTitle(content);
        // sinm.setIcon(R.drawable.common_full_open_on_phone);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int res_id=item.getItemId();
        if(res_id==R.id.m5)
        openf1();

        /*
        if(res_id==R.id.m6)
        {
            mAuth.signOut();
            finish();
            Intent intent = new Intent(this, MainActivitynew.class);
            startActivity(intent);
            Toast.makeText(this, "Signed Out!", Toast.LENGTH_LONG).show();

        }
        */
        //stats
        if(res_id==R.id.m7)
        {

            databaseReports.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    try {
                        ab = Integer.parseInt(value);
                    } catch(NumberFormatException nfe) {

                    }
                    ab=ab-1;

                    value=String.valueOf(ab);

                    v3=value;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (!isFinishing()){
                                new AlertDialog.Builder(admin.this,R.style.AlertDialogStyle)
                                        .setTitle("Stats")
                                        .setMessage("Total number of Reports generated by this app ="+v3)
                                        .setCancelable(false)
                                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                // Whatever...
                                            }
                                        }).show();

                            }
                        }
                    });

                    //textView40.setText(value);



                }

                @Override
                public void onCancelled(DatabaseError error) {
                }
            });






        }

        return super.onOptionsItemSelected(item);
    }


}
