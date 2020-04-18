package arifraza.adrriagit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ReportList extends ArrayAdapter<report> {


    private Activity context;
    private List<report> reportList;

    public ReportList(Activity context, List<report> reportList) {
        super(context, R.layout.list_layout, reportList);
        this.context = context;
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewdat = (TextView) listViewItem.findViewById(R.id.textViewdat);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);
        TextView textViewLoc = (TextView) listViewItem.findViewById(R.id.textViewLoc);
        TextView textView15 = (TextView) listViewItem.findViewById(R.id.textView15);
        TextView textViewrep = (TextView) listViewItem.findViewById(R.id.textViewrep);
        TextView textView611 = (TextView) listViewItem.findViewById(R.id.textView611);
        TextView textView612 = (TextView) listViewItem.findViewById(R.id.textView612);
        TextView textView613 = (TextView) listViewItem.findViewById(R.id.textView613);
        TextView textView24 = (TextView) listViewItem.findViewById(R.id.textView24);
        TextView textView4 = (TextView) listViewItem.findViewById(R.id.textView4);
        TextView textView27 = (TextView) listViewItem.findViewById(R.id.textView27);
        TextView textView22 = (TextView) listViewItem.findViewById(R.id.textView22);
        TextView textView28 = (TextView) listViewItem.findViewById(R.id.textView28);
        TextView textView42 = (TextView) listViewItem.findViewById(R.id.textView42);
        TextView textView20 = (TextView) listViewItem.findViewById(R.id.textView20);




        report report = reportList.get(getCount()-position-1);

        textView42.setText("Report No:"+report.getrpno());
        textViewName.setText("Patient:"+report.getpName());
        textViewLoc.setText("Location:"+report.getpLoc());
        textViewdat.setText("Date Reported:"+report.getdat());
        textViewGenre.setText("Seriousness:"+report.getpGenre());
        textView15.setText("Reporter's remarks:"+report.getrem());
        textViewrep.setText("Name of Reporter:"+report.getrp());
        textView22.setText("Email of Reporter:"+report.getrml());
        textView4.setText("Assessed By:"+report.getass3());
        textView27.setText("Assessor's Email:"+report.getasse());
        textView611.setText("Drug Name:"+report.getdnm());
        textView612.setText("Reaction:"+"\t"+report.getrct());
        textView613.setText("Causality:"+"\t"+report.getcst());
        textView28.setText("Assessor's remarks:"+report.getarem());
        textView20.setText("Date Assessed:"+report.getdat2());
        textView24.setText(report.getnas());
        return listViewItem;
    }
}
