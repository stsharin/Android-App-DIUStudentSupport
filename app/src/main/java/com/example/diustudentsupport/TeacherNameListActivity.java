package com.example.diustudentsupport;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diustudentsupport.pojo.TeacherInfo;

import java.util.ArrayList;

public class TeacherNameListActivity extends AppCompatActivity implements ListAdapter {
    private TextView name, ti, emID, desig, dept, faculty, pWebpage, email, cell;
    private ListView nameinfoList;
    private ArrayList<TeacherInfo> dbStates = new ArrayList<>();
    private TeacherNameListActivity teacherNameListActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teacher_name_part2);

        name = (TextView) findViewById(R.id.tecaherName);
        ti = (TextView) findViewById(R.id.teacherInitial);
        emID = (TextView) findViewById(R.id.emID);
        desig = (TextView) findViewById(R.id.desig);
        dept = (TextView) findViewById(R.id.dept);
        faculty = (TextView) findViewById(R.id.faculty);
        pWebpage = (TextView) findViewById(R.id.pWebpage);
        email = (TextView) findViewById(R.id.email);
        cell = (TextView) findViewById(R.id.cellPhone);

        TeacherInfo teacherInfo = (TeacherInfo) getIntent().getSerializableExtra("data");

        name.setText(teacherInfo.getName());
    }


    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
