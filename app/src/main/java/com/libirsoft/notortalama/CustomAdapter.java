package com.libirsoft.notortalama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yuşa Kopuz on 20.03.2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {
Context c;
ArrayList<String>lesson_names;
ArrayList<String>lesson_hourses;
ArrayList<String>lesson_avarages;
CustomAdapter(Context context, ArrayList lesson_names, ArrayList lesson_hour, ArrayList lesson_avarages){




super(context,R.layout.notes,lesson_names);
    this.c=context;
    this.lesson_names=lesson_names;
    this.lesson_hourses=lesson_hour;
    this.lesson_avarages=lesson_avarages;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 View  v=      layoutInflater.inflate(R.layout.notes,parent,false);
TextView tx_lesson_name= (TextView) v.findViewById(R.id.lesson_name1);
TextView tx_lesson_hours= (TextView) v.findViewById(R.id.lesson_hours1);
TextView tx_lesson_avarage= (TextView) v.findViewById(R.id.lesson_avarage1);

        tx_lesson_name.setText(lesson_names.get(position));
        tx_lesson_hours.setText(lesson_hourses.get(position));
        tx_lesson_avarage.setText(lesson_avarages.get(position));


return v;
    }
}
