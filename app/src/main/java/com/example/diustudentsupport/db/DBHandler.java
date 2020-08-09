package com.example.diustudentsupport.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.diustudentsupport.pojo.TeacherInfo;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "diussp.db";
    private static final String TABLE_TEACHER_INFO = "teacherInfo";

    // teacher info table columns
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_TI = "teacher_initial";
    private static final String COL_EMP_ID = "employee_id";
    private static final String COL_DESIGNATION = "designation";
    private static final String COL_DEPARTMENT = "department";
    private static final String COL_FACULTY = "faculty";
    private static final String COL_P_WEB_PAGE = "personal_web_page";
    private static final String COL_EMAIL = "email";
    private static final String COL_CELL_PH_NO = "cell_phone_no";

    //new adding
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DBHandler instance ;

    public static DBHandler getInstance(Context context){
        if (instance == null){
            instance = new DBHandler(context);
        }
        return instance;
    }


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEACHER_INFO_TABLE = "CREATE TABLE " + TABLE_TEACHER_INFO
                + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT, " + COL_TI + " TEXT, " + COL_EMP_ID + " TEXT, " +
                COL_DESIGNATION + " TEXT, " + COL_DEPARTMENT + " TEXT, " + COL_FACULTY + " TEXT, " + COL_P_WEB_PAGE + " TEXT, " +
                COL_EMAIL + " TEXT, " + COL_CELL_PH_NO + " TEXT " + ")";


        db.execSQL(CREATE_TEACHER_INFO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TEACHER_INFO );
        onCreate(db);
    }

    // code to add new info
    public void addInfo(TeacherInfo teacherInfo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, teacherInfo.getName());
        values.put(COL_TI, teacherInfo.getTeacherInitial());
        values.put(COL_EMP_ID, teacherInfo.getEmployeeID());
        values.put(COL_DESIGNATION, teacherInfo.getDesignation());
        values.put(COL_DEPARTMENT, teacherInfo.getDepartment());
        values.put(COL_FACULTY, teacherInfo.getFaculty());
        values.put(COL_P_WEB_PAGE, teacherInfo.getPWebPage());
        values.put(COL_EMAIL, teacherInfo.getEmail());
        values.put(COL_CELL_PH_NO, teacherInfo.getCellPhone());

        db.insert(TABLE_TEACHER_INFO, null, values);
        db.close();
    }

    TeacherInfo getInfo(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TEACHER_INFO, new String[] { COL_ID, COL_NAME, COL_TI, COL_EMP_ID, COL_DESIGNATION, COL_DEPARTMENT,
                        COL_FACULTY, COL_P_WEB_PAGE, COL_EMAIL, COL_CELL_PH_NO }, COL_ID + "=?", new String[] {String.valueOf(id)}, null,
                null, null, null);

        if (cursor!=null){
            cursor.moveToFirst();
        }
        TeacherInfo teacherInfo = new TeacherInfo(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9));

        return teacherInfo;
    }


    // to get all the data in a list view
    public List<TeacherInfo> getAllInfo(){
        List<TeacherInfo> infoList = new ArrayList<TeacherInfo>();

        String selectQuery = "Select * From " + TABLE_TEACHER_INFO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do {
                TeacherInfo teacherInfo = new TeacherInfo();
                teacherInfo.setID(Integer.parseInt(cursor.getString(0)));
                teacherInfo.setName(cursor.getString(1));
                teacherInfo.setTeacherInitial(cursor.getString(2));
                teacherInfo.setEmployeeID(cursor.getString(3));
                teacherInfo.setDesignation(cursor.getString(4));
                teacherInfo.setDepartment(cursor.getString(5));
                teacherInfo.setFaculty(cursor.getString(6));
                teacherInfo.setPWebPage(cursor.getString(7));
                teacherInfo.setEmail(cursor.getString(8));
                teacherInfo.setCellPhone(cursor.getString(9));

                infoList.add(teacherInfo);
            } while (cursor.moveToNext());
        }
        return infoList;
    }

    // code to update single contact
    public int updateInfo(TeacherInfo teacherInfo){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, teacherInfo.getName());
        values.put(COL_TI, teacherInfo.getTeacherInitial());
        values.put(COL_EMP_ID, teacherInfo.getEmployeeID());
        values.put(COL_DESIGNATION, teacherInfo.getDesignation());
        values.put(COL_DEPARTMENT, teacherInfo.getDepartment());
        values.put(COL_FACULTY, teacherInfo.getFaculty());
        values.put(COL_P_WEB_PAGE, teacherInfo.getPWebPage());
        values.put(COL_EMAIL, teacherInfo.getEmail());
        values.put(COL_CELL_PH_NO, teacherInfo.getCellPhone());

        return db.update(TABLE_TEACHER_INFO, values, COL_ID + "?", new String[] {String.valueOf(teacherInfo.getID())});
    }


    //delete single contact
    public void deleteInfo(TeacherInfo teacherInfo){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEACHER_INFO, COL_ID + "?", new String[] {String.valueOf(teacherInfo.getID())});
        db.close();
    }


    public int getInfoCount(){
        String countQuery = " SELECT * FROM " + TABLE_TEACHER_INFO;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public ArrayList<TeacherInfo> searchInfo(String query){
        ArrayList<TeacherInfo> searchResult = new ArrayList<>();
        database = this.getWritableDatabase();

        query = "%" + query + "%";

        Cursor cursor = database.rawQuery("SELECT * FROM infolist WHERE name LIKE '" + query + "' COLLATE NOCASE", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setTeacherInitial(cursor.getString(cursor.getColumnIndex("teacher_initial")));
            teacherInfo.setEmployeeID(cursor.getString(cursor.getColumnIndex("employee_id")));
            teacherInfo.setDesignation(cursor.getString(cursor.getColumnIndex("designation")));
            teacherInfo.setDepartment(cursor.getString(cursor.getColumnIndex("department")));
            teacherInfo.setFaculty(cursor.getString(cursor.getColumnIndex("faculty")));
            teacherInfo.setPWebPage(cursor.getString(cursor.getColumnIndex("personal_web_page")));
            teacherInfo.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            teacherInfo.setCellPhone(cursor.getString(cursor.getColumnIndex("cell_phone_no")));

            searchResult.add(teacherInfo);
            cursor.moveToNext();
        }
        return searchResult;
    }

    public void close(){
        if (database != null){
            this.database.close();
        }
    }


}
