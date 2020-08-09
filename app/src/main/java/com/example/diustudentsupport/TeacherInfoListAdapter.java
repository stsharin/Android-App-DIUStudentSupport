package com.example.diustudentsupport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.diustudentsupport.pojo.TeacherInfo;

import java.util.ArrayList;

public class TeacherInfoListAdapter extends ArrayAdapter<TeacherInfo> {

    private int layoutResource;
    private Activity activity;
    private ArrayList<TeacherInfo> teacherInfos = new ArrayList<>();

    public TeacherInfoListAdapter(Activity act, int resource, ArrayList<TeacherInfo> data){
        super(act, resource, data);
        activity = act;
        layoutResource = resource;
        teacherInfos = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return teacherInfos.size();
    }

    @Nullable
    @Override
    public TeacherInfo getItem(int position) {
        return teacherInfos.get(position);
    }

    @Override
    public int getPosition(@Nullable TeacherInfo item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        InfoViewHolder  holder = null;

        if (row == null || row.getTag() == null){
            LayoutInflater inflater = LayoutInflater.from(activity);
            row = inflater.inflate(layoutResource, null);

            holder = new InfoViewHolder();

            holder.name = (TextView) row.findViewById(R.id.tecaherName);
            holder.teacherInitial = (TextView) row.findViewById(R.id.teacherInitial);
            holder.employeeID = (TextView) row.findViewById(R.id.emID);
            holder.designation = (TextView) row.findViewById(R.id.desig);
            holder.department = (TextView) row.findViewById(R.id.dept);
            holder.faculty = (TextView) row.findViewById(R.id.faculty);
            holder.personalWebPage = (TextView) row.findViewById(R.id.pWebpage);
            holder.email = (TextView) row.findViewById(R.id.email);
            holder.cellPhone = (TextView) row.findViewById(R.id.cellPhone);

            row.setTag(holder);
        }else{
            holder = (InfoViewHolder) row.getTag();
        }
        holder.teacherInfo = getItem(position);

        holder.name.setText(holder.teacherInfo.getName());
        holder.teacherInitial.setText(String.valueOf(holder.teacherInfo.getTeacherInitial()));
        holder.employeeID.setText(String.valueOf(holder.teacherInfo.getEmployeeID()));
        holder.designation.setText(holder.teacherInfo.getDesignation());
        holder.department.setText(holder.teacherInfo.getDepartment());
        holder.faculty.setText(holder.teacherInfo.getFaculty());
        holder.personalWebPage.setText(holder.teacherInfo.getPWebPage());
        holder.email.setText(holder.teacherInfo.getEmail());
        holder.cellPhone.setText(holder.teacherInfo.getCellPhone());

        holder.infoIdInt = holder.teacherInfo.getID();

        final InfoViewHolder finalHolder = holder;

        row.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, TeacherNameListActivity.class);

                Bundle mBundle = new Bundle();
                mBundle.putSerializable("data", finalHolder.teacherInfo);

                i.putExtras(mBundle);

                activity.startActivity(i);

            }
        });

        return row;
    }

    public class InfoViewHolder{
        TeacherInfo teacherInfo;
        TextView name;
        TextView teacherInitial;
        TextView employeeID;
        TextView designation;
        TextView department;
        TextView faculty;
        TextView personalWebPage;
        TextView email;
        TextView cellPhone;
        int infoIdInt;
    }

}


