package com.example.diustudentsupport;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diustudentsupport.db.DBHandler;
import com.example.diustudentsupport.pojo.TeacherInfo;

import java.util.ArrayList;

public class SearchResultActivity extends AppCompatActivity {
    private ListView searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        String searchString = getIntent().getStringExtra("searchString");

        searchList = (ListView) findViewById(R.id.searchList);

        DBHandler dbHandler =  DBHandler.getInstance(this);
        //dbHandler.open();

        ArrayList<TeacherInfo> searchResult = dbHandler.searchInfo(searchString);

        TeacherInfoListAdapter adapter = new TeacherInfoListAdapter(SearchResultActivity.this, R.layout.fragment_teacher_name_part2, searchResult);
        searchList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        dbHandler.close();
    }
}
