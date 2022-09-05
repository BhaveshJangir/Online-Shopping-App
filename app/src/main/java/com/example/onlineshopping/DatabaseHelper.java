package com.example.onlineshopping;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="UserManager.db";

    private static final String TABLE_USER="user";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME="user_name";
    private static final String COLUMN_USER_EMAIL="user_email";
    private static final String COLUMN_USER_PASSWORD="user_password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private String CREATE_USER_TABLE = "CREATE TABLE "+TABLE_USER+" (" +
            COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_NAME+" TEXT," +
            COLUMN_USER_EMAIL+" TEXT," +
            COLUMN_USER_PASSWORD+" TEXT "+")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS  " + TABLE_USER;


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // drop user table if exists
          sqLiteDatabase.execSQL(DROP_USER_TABLE);
          //create tables again
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    public Boolean inset_data(String name,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(COLUMN_USER_NAME,name);
        c.put(COLUMN_USER_EMAIL,email);
        c.put(COLUMN_USER_PASSWORD,password);
        long r = db.insert("user",null,c);

        if(r==-1) return false;
        else return true;
    }

    public Boolean checkUser(String email, String password){
        String[] columns = { COLUMN_USER_ID };
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USER_EMAIL+" = ?"+" AND "+COLUMN_USER_PASSWORD+" = ?";
       String[] selectionArgs ={email,password};

        Cursor cursor =  db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount>0){
            return true;
        }
        else{
            return false;
        }
    }
}
