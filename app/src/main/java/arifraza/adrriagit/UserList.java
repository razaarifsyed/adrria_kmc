package arifraza.adrriagit;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class UserList extends ArrayAdapter<user>{


    private Activity context;
    private List<user> userList;

    public UserList(Activity context, List<user> userList) {
        super(context, R.layout.list_layout3, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem3 = inflater.inflate(R.layout.list_layout3, null, true);

        TextView textView7 = (TextView) listViewItem3.findViewById(R.id.textView7);
        TextView textView9 = (TextView) listViewItem3.findViewById(R.id.textView9);
        TextView textView25 = (TextView) listViewItem3.findViewById(R.id.textView25);
        TextView textView26 = (TextView) listViewItem3.findViewById(R.id.textView26);
        TextView textView29 = (TextView) listViewItem3.findViewById(R.id.textView29);
        user user = userList.get(getCount()-position-1);
        textView7.setText("Name:"+user.getdname());
        textView29.setText("Email:"+user.getdeml());
        textView9.setText("Hospital ID:"+user.getdhid());
        textView25.setText("Designation:"+user.getdds());
        textView26.setText("Phone No:"+user.getdpn());


        return listViewItem3;
    }

}
