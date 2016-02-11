package com.sushank.loginregistermaterial.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sushank.loginregistermaterial.model.User;

/**
 * Created by SushankKDahiwadkar on 2/4/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "OnlineExaminationSystem";

    //User table name
    private static final String USER_TABLE = "UserTable";

    //User table columns name
    private static final String USER_ID = "userId";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String USER_NAME = "userName";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + "(" + USER_ID + " INTEGER PRIMARY KEY, " + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," + EMAIL + " TEXT," + USER_NAME + "TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + USER_TABLE);
        onCreate(db);
    }

    /**
     * Add user to local database
     * @param user
     */
    public void addUser(User user){
        //get database object
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_ID, user.getUserId());
        values.put(FIRST_NAME, user.getFirstName());
        values.put(LAST_NAME, user.getLastName());
        values.put(EMAIL, user.getEmail());
        values.put(USER_NAME, user.getUserName());

        //insert a row into USER_TABLE
        db.insert(USER_TABLE, null, values);
        // close database connection
        db.close();
    }

    /**
     * Get [@class User] from local storage by userId
     * @param userId
     * @return
     */
    public User getUser(int userId){
        //get database object
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(USER_TABLE, new String[] {FIRST_NAME, LAST_NAME, EMAIL, USER_NAME}, USER_ID + "=?", new String[] {String.valueOf(userId)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        User user = new User(userId, cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
        return user;
    }

    /**
     * Update [@class User] into local Storage
     * @param user
     * @return
     */
    public int updateUser(User user){
        //get database object
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, user.getFirstName());

        return db.update(USER_TABLE, values, USER_ID + "=?", new String[] {String.valueOf(user.getUserId())});
    }

    /**
     * Delete [@class User] from local Storage
     * @param user
     */
    public void deleteUser(User user){
        //get database object
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(USER_TABLE, USER_ID + " = ?",
                new String[] { String.valueOf(user.getUserId()) });
        db.close();
    }
}
