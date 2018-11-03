package com.libirsoft.notortalama;

        import android.app.Dialog;
        import android.os.Bundle;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class Avarage extends AppCompatActivity {
    public static final int DİALOG_ADD = 0;
    int Lesson_hours = 0;
    double Lesson_point = 0;
    double Lesson_avarage = 0;
    ListView listView;
    TextView avarage;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);
        actionBar  = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_background));
        listView = (ListView) findViewById(R.id.lesson_info_list);
        avarage = (TextView) findViewById(R.id.avarage);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.add:
                showDialog(DİALOG_ADD);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch (id) {
            case DİALOG_ADD:
                dialog = getAddDialog();
                break;

        }


        return dialog;
    }

    private Dialog getAddDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View notes = layoutInflater.inflate(R.layout.notes_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(notes);
        final AlertDialog dialog = builder.create();
        Button accpet = (Button) notes.findViewById(R.id.accept);
        Button cancel = (Button)notes.findViewById(R.id.cancel);
        final EditText lesson_name = (EditText) notes.findViewById(R.id.lesson);
        final EditText lesson_hours = (EditText) notes.findViewById(R.id.lesson_hours);
        final EditText lesson_avarage = (EditText) notes.findViewById(R.id.lesson_avarage);
        final ArrayList<String> lesson_names = new ArrayList<String>();
        final ArrayList<String> lesson_hourses = new ArrayList<String>();
        final ArrayList<String> lesson_avarages = new ArrayList<String>();
        accpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//***************************************************************
                int selfHours = Integer.parseInt(lesson_hours.getText().toString());
                int selfPoint = Integer.parseInt(lesson_avarage.getText().toString());
                Lesson_point = Lesson_point + (selfPoint * selfHours);
                Lesson_hours = Lesson_hours + Integer.parseInt(lesson_hours.getText().toString());
                Lesson_avarage = Lesson_point / Lesson_hours;
                avarage.setText(" " + Lesson_avarage);
//***************************************************************
                lesson_names.add(lesson_name.getText().toString());
                lesson_hourses.add(lesson_hours.getText().toString());
                lesson_avarages.add(lesson_avarage.getText().toString());

                CustomAdapter adapter = new CustomAdapter(getApplication(), lesson_names, lesson_hourses, lesson_avarages);
                listView.setAdapter(adapter);

                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        return dialog;
    }
}