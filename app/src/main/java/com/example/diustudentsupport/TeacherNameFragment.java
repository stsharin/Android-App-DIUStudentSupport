package com.example.diustudentsupport;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.diustudentsupport.pojo.TeacherInfo;

import java.util.ArrayList;

public class TeacherNameFragment extends Fragment {

    private ListView listView;

    private ArrayList<TeacherInfo> dbInfos  = new ArrayList<>();
    private TeacherInfoListAdapter teacherInfoListAdapter;
    private EditText searchBox;
    private Button runSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_teacher_name, container, false);

        listView = root.findViewById(R.id.mainList);
        searchBox = root.findViewById(R.id.search_text);

        runSearch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    search();
                }
            }
        });

        return root;
    }
    private void search(){
        String searchString = searchBox.getText().toString().trim();
        if (null != searchString && searchString.compareToIgnoreCase("") != 0){

            Intent i = new Intent(getActivity(), SearchResultActivity.class);
            //Intent i = new Intent(TeacherNameFragment.this, SearchResultActivity.class);
            i.putExtra("searchString", searchString);
            startActivity(i);
        }
    }
}
