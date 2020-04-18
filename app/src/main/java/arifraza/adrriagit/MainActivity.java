package arifraza.adrriagit;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.Date;
import java.util.Calendar;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editText44;
    EditText editText13;
    FirebaseAuth mAuth;
    Toolbar toolbar;

    EditText editText3;
    Button buttonAdd;
    Spinner spinnerGenres;
    Button button5;
    Button button14;
    Button button7;
    DatabaseReference databaseReports;
    DatabaseReference databaseReports22;
    DatabaseReference databaseReports23;

    TextView textView40;
    TextView textView41;
int myNum;
int ab;
int rpno7;


    //to goto view page
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databaseReports22 = FirebaseDatabase.getInstance().getReference("rpno");

        //databaseReports24 = FirebaseDatabase.getInstance().
        mAuth = FirebaseAuth.getInstance();
        textView40=(TextView) findViewById(R.id.textView40);
        addcount();
       // textView41=(TextView) findViewById(R.id.textView41);







        databaseReports = FirebaseDatabase.getInstance().getReference("reports");



        editTextName = (EditText) findViewById(R.id.editTextName);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText44 = (EditText) findViewById(R.id.editText44);
        editText13 = (EditText) findViewById(R.id.editText13);
        buttonAdd = (Button) findViewById(R.id.buttonAddReport);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);
        //addcount();
        //int cnt=addcount();
        //String cn = String.valueOf(cnt);

        //textView40.setText(cn);
        openr11();


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sendMail();

                addReport();
                openr11();


            }
        });


    }







    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        Toast.makeText(this, "App closed!", Toast.LENGTH_LONG).show();
        /*
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast toast= Toast.makeText(getApplicationContext(),
                "Already on Homepage!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);

        toast.show();
        */
    }

    private void addReport() {
        //getting the values to save
        Date currentTime = Calendar.getInstance().getTime();


        String name = editTextName.getText().toString().trim();
        String dat = currentTime.toString();
        String rp = editText44.getText().toString().trim();
        String loc = editText3.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();
        String rem = editText13.getText().toString().trim();
        String rpno = textView40.getText().toString().trim();




        String dnm="Not Assessed by Pharmacologist yet";
        String rct="Not Assessed by Pharmacologist yet";
        String cst="Not Assessed by Pharmacologist yet";
        String nas="New Report!";
        String ass3="Not Assessed by Pharmacologist yet";
        String asse="Not Assessed by Pharmacologist yet";
        String arem="Not Assessed by Pharmacologist yet";
        String dat2="Not Assessed by Pharmacologist yet";

        final FirebaseUser user66 = mAuth.getCurrentUser();
        String rml=user66.getEmail().toString();



        if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(loc)&&!TextUtils.isEmpty(rp)) {

            String id = databaseReports.push().getKey();

            //creating an Artist Object
            report report = new report(id,name,rp,rml,dat, loc,genre,rem,dnm,rct,cst,nas,ass3,asse,arem,rpno,dat2);


            //Saving the Artist
            databaseReports.child(id).setValue(report);


            //rpno

            try {
                ab = Integer.parseInt(rpno);
            } catch(NumberFormatException nfe) {

            }



      ab=ab+1;

            rpno=String.valueOf(ab);


            //textView41.setText(v2);

           databaseReports22.setValue(rpno);






            //databaseReports23.child("rpno").setValue(v2);

            //setting edittext to blank again
            editTextName.setText("");
            editText3.setText("");
            editText13.setText("");
            editText44.setText("");


            //displaying a success toast
            Toast.makeText(this, "Report added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            //focus


            editTextName.requestFocus();

            Toast.makeText(this, "Please enter all mandatory information", Toast.LENGTH_LONG).show();
        }
    }

    private void sendMail() {

        Date currentTime = Calendar.getInstance().getTime();


        if (!TextUtils.isEmpty(editTextName.getText().toString())&&!TextUtils.isEmpty(editText3.getText().toString())&&!TextUtils.isEmpty(editText44.getText().toString())) {

            String messagel = "";
            messagel += "\n" + "Adverse Reaction Report";
            messagel += "\n" + "-----------------------------------------------------";
            messagel += "\n";
            messagel += "\n";
            messagel += "\n" + "Report No :" + textView40.getText().toString();
            messagel += "\n" + "Patient ID :" + editTextName.getText().toString();
            messagel += "\n" + "Date :" + currentTime.toString();
            messagel += "\n" + "Patient Location :" + editText3.getText().toString();
            messagel += "\n" + "Reporter Name :" + editText44.getText().toString();

            messagel += "\n" + "Seriousness :" + spinnerGenres.getSelectedItem().toString();
            messagel += "\n" + "Remarks :" + editText13.getText().toString();
            messagel += "\n";
            messagel += "\n";
            messagel += "\n" + "Report generated by the KMC - ADR Reporter app";
            messagel += "\n";
            messagel += "\n";
            messagel += "\n" + "-----------------------------------------------------";
            messagel += "\n";
            messagel += "\n" + "Department of Pharmacology";
            messagel += "\n" + "Kasturba Medical College,Manipal";


            //String recipientList = mEditTextTo.getText().toString();
            //String[] recipients = recipientList.split(",");

            //String subject = mEditTextSubject.getText().toString();
            //String message = mEditTextMessage.getText().toString();
            //String to1="adrrkmc@gmail.com";


            Intent intent = new Intent(Intent.ACTION_SEND);

            //String m2 = mEditText.getText().toString();

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"adrrkmc@gmail.com"});
            //intent.putExtra(Intent.EXTRA_EMAIL, to1);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Adverse Reaction Alert");
            intent.putExtra(Intent.EXTRA_TEXT, messagel);

            intent.setType("message/rfc822");

            intent.setPackage("com.google.android.gm");
            startActivity(intent);
            //startActivity(Intent.createChooser(intent, "Choose an email client"));
        }


    }

    public void openactivity2(){

Intent intent =  new Intent(this,passw.class);
startActivity(intent );

    }


    public void open4() {
            Intent intent = new Intent(this, cmessage.class);
            startActivity(intent);


    }

    public void open77()
    {
        final AlertDialog d = new AlertDialog.Builder(this)
                .setPositiveButton(android.R.string.ok, null)
                .setTitle("Created By")
                .setMessage(Html.fromHtml("<a href=\"https://manipal.edu/kmc-manipal/department-faculty/faculty-list/navin-a-patil.html\" >Dr. Navin Patil</a> &nbsp; &nbsp; &nbsp;: KMC <br> <a href=\"https://manipal.edu/kmc-manipal/department-faculty/faculty-list/veena-nayak.html\">Dr. Veena Nayak</a> :KMC<br> <a href=\"https://manipal.edu/mit/department-faculty/faculty-list/AkshayMJ.html\">Akshay MJ</a>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  : MIT<br><a href=\"https://www.linkedin.com/in/george-varghese-a1295814a/?originalSubdomain=in\" > Dr.George Varghese </a>  &nbsp;: KMC <br> <br><br><a href=\"https://www.linkedin.com/in/razaarifsyed/\">Arif Raza</a>  : App Developer<br> ")) //
                .create();
        d.show();
// Make the textview clickable. Must be called after show()
        ((TextView)d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());




    }

    public void openr11() {


        final FirebaseUser user3 = mAuth.getCurrentUser();
        editText44.setText(user3.getDisplayName().toString());

}
    public void open3001() {

        Intent intent = new Intent(this, myrep.class);
        startActivity(intent);
    }


    public void addcount() {


        databaseReports22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);



                textView40.setText(value);



            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
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
        if(res_id==R.id.m2)
           open3001();
        if(res_id==R.id.m3)
        {

            Intent intent = new Intent(this, myenq.class);
            startActivity(intent);

        }
        if(res_id==R.id.m4)
        {
            Intent intent =  new Intent(this,passw.class);
            startActivity(intent );
        }

        if(res_id==R.id.m5)
        {
            open77();
        }

        if(res_id==R.id.m6)
        {
            mAuth.signOut();
            finish();
            Intent intent = new Intent(this, MainActivitynew.class);
            startActivity(intent);

            Toast.makeText(this, "Signed Out!", Toast.LENGTH_LONG).show();

        }

        if(res_id==R.id.m8)
            open4();
        return super.onOptionsItemSelected(item);
    }
}
