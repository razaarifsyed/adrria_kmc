package arifraza.adrriagit;

import android.widget.ArrayAdapter;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MessageList extends ArrayAdapter<msg> {





    private Activity context;
    private List<msg> messageList;

    public MessageList(Activity context, List<msg> messageList) {
        super(context, R.layout.list_layout2, messageList);
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem2 = inflater.inflate(R.layout.list_layout2, null, true);

        TextView textViewName2 = (TextView) listViewItem2.findViewById(R.id.textViewName2);
        TextView textViewGenre2 = (TextView) listViewItem2.findViewById(R.id.textViewGenre2);
        TextView textViewcon2 = (TextView) listViewItem2.findViewById(R.id.textViewCon2);
        TextView textView6 = (TextView) listViewItem2.findViewById(R.id.textView6);
        TextView textView34 = (TextView) listViewItem2.findViewById(R.id.textView34);
        TextView textView36 = (TextView) listViewItem2.findViewById(R.id.textView36);
        TextView textView37 = (TextView) listViewItem2.findViewById(R.id.textView37);
        TextView textView38 = (TextView) listViewItem2.findViewById(R.id.textView38);
        TextView textView41 = (TextView) listViewItem2.findViewById(R.id.textView41);
        TextView textView44 = (TextView) listViewItem2.findViewById(R.id.textView44);

        msg msg = messageList.get(getCount()-position-1);
        textViewName2.setText("Asker:"+msg.getmname());
        textView34.setText("Asker's Email:"+msg.getseml());
        textViewcon2.setText("Asker's Designation :"+msg.getcon());
        textViewGenre2.setText("Question:"+msg.getmmsg());
        textView6.setText(msg.getrdd());
        textView36.setText("Answer:"+msg.getmmsg2());
        textView37.setText("Answerer:"+msg.getrnm2());
        textView38.setText("Answerer's Email:"+msg.getrml2());
        textView41.setText("Date Asked:"+msg.getdat());
        textView44.setText("Date Answered:"+msg.getdat2());

        return listViewItem2;
    }

}
