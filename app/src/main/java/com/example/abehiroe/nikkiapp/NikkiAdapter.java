package com.example.abehiroe.nikkiapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

public class NikkiAdapter extends RealmBaseAdapter<Nikki> {

    private static class ViewHolder {
        TextView date;
        TextView title;
    }

    public NikkiAdapter(Context context, RealmResults<Nikki> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.date = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.title = (TextView)convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Nikki nikki = realmResults.get(position);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = sdf.format(nikki.getDate());
        viewHolder.date.setText(formatDate);
        viewHolder.title.setText(nikki.getTitle());

        return convertView;
    }
}
