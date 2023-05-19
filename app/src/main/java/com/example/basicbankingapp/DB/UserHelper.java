package com.example.basicbankingapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Aarav Patel', 'tp2134@gmail.com', 'HDFC0000123', '9977641238', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Riya Sharma', 'rs3456@yahoo.com', 'ICIC0000456', '9988776655', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Arjun Singh', 'arjunsingh@gmail.com', 'SBIN0001234', '9876543210', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Zara Desai', 'zara.desai@hotmail.com', 'AXIS0000567', '9123456789', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Aryan Mehta', 'amehta12@gmail.com', 'PNB0007890', '9456789123', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Ishan Roy', 'ishan221@gmail.com','1085','9184640238', 1200)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Sanaya Gupta', 'sanaya.gupta@gmail.com', 'BOI0000345', '9034567890', 7200)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Rohan Kapoor', 'rohankapoor@yahoo.com', 'UBIN0000987', '9987654321', 1500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Naina Reddy', 'naina.reddy@gmail.com', 'IDBI0000765', '9345678901', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Advait Mishra', 'advait.mishra@gmail.com', 'CANB0000123', '9976543210', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Ishita Choudhury', 'ishita_c@yahoo.com', 'IOBA0000456', '9123456789', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Vihaan Joshi', 'vihaanjoshi@gmail.com', 'SBI0000987', '9898765432', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Vasudev Sankla', 'sanklavasudev@gmail.com','1166','8581541001', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Priya Patel', 'priya1212@gmail.com','5436','7295642205', 12500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Reyansh Malhotra', 'reyanshmalhotra@gmail.com', 'ICIC0000345', '9876543210', 9110)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}