package com.example.project_ubi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "fitness.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(CREATE_TABLE_EXERCISE);
        sqLiteDatabase.execSQL(CREATE_TABLE_WORKOUT);
        sqLiteDatabase.execSQL(CREATE_TABLE_FEEDBACK);
        sqLiteDatabase.execSQL(CREATE_TABLE_WORKOUT_PLAN);
        sqLiteDatabase.execSQL(CREATE_TABLE_WORKOUT_RECORD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //Table name and columns for user
    public static final String TABLE_USER="user";
    public static final String COLUMN_USER_ID = "_id";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PASSWORD = "password";
    public static final String COLUMN_USER_HEIGHT = "height";
    public static final String COLUMN_USER_WEIGHT = "weight";
    public static final String COLUMN_USER_AGE = "age";
    public static final String COLUMN_USER_GENDER = "gender";

    //Create user table
    public static final String CREATE_TABLE_USER="CREATE TABLE "+TABLE_USER+" ("+
            COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_USER_NAME+" TEXT, "+
            COLUMN_USER_AGE+" INTEGER, "+
            COLUMN_USER_GENDER+" TEXT, "+
            COLUMN_USER_EMAIL+" TEXT, "+
            COLUMN_USER_PASSWORD+" TEXT, "+
            COLUMN_USER_HEIGHT+" REAL, "+
            COLUMN_USER_WEIGHT+" REAL)";


    //Table name and columns for exercise
    public  static final String TABLE_EXERCISE="exercise";
    public static final String EXERCISE_COLUMN_ID = "_id";
    public static final String EXERCISE_COLUMN_NAME = "name";
    public static final String EXERCISE_COLUMN_WORKED_MUSCLES = "worked_muscles";
    public static final String EXERCISE_COLUMN_DESCRIPTION = "description";
    public static final String EXERCISE_COLUMN_IMAGE = "image";

    //Create exercise table
    public static final String CREATE_TABLE_EXERCISE="CREATE TABLE "+TABLE_EXERCISE+" ("+
            EXERCISE_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            EXERCISE_COLUMN_NAME+" TEXT, " +
            EXERCISE_COLUMN_WORKED_MUSCLES+" TEXT, "+
            EXERCISE_COLUMN_DESCRIPTION+" TEXT, "+
            EXERCISE_COLUMN_IMAGE+" BLOB)"
            ;

    //Table name and columns for feedback
    public static final String TABLE_FEEDBACK = "feedback";
    public static final String FEEDBACK_COLUMN_ID = "_id";
    public static final String FEEDBACK_COLUMN_USER_ID = "user_id";
    public static final String FEEDBACK_COLUMN_SUBJECT = "subject";
    public static final String FEEDBACK_COLUMN_MESSAGE_BODY = "message_body";

    //Create feedback table
    public static final String CREATE_TABLE_FEEDBACK="CREATE TABLE "+TABLE_FEEDBACK+" ("+
            FEEDBACK_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            FEEDBACK_COLUMN_USER_ID+" INTEGER, " +
            FEEDBACK_COLUMN_SUBJECT+ " TEXT, "+
            FEEDBACK_COLUMN_MESSAGE_BODY+" TEXT, "+
            "FOREIGN KEY("+FEEDBACK_COLUMN_USER_ID+") REFERENCES "+TABLE_USER+"("+COLUMN_USER_ID+")"
            +")";

    //Table name and columns for workout plan
    public static final String TABLE_WORKOUT_PLAN = "workout_plan";
    public static final String WORKOUT_PLAN_COLUMN_ID = "_id";
    public static final String WORKOUT_PLAN_COLUMN_NAME = "name";
    public static final String WORKOUT_PLAN_COLUMN_CREATION_DATE = "creation_date";
    public static final String WORKOUT_PLAN_COLUMN_GOAL = "goal";

    //create workout plan
    public static final String CREATE_TABLE_WORKOUT_PLAN="CREATE TABLE "+ TABLE_WORKOUT_PLAN+" ("+
            WORKOUT_PLAN_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            WORKOUT_PLAN_COLUMN_NAME+" TEXT,"+
            WORKOUT_PLAN_COLUMN_CREATION_DATE+" TEXT,"+
            WORKOUT_PLAN_COLUMN_GOAL+" TEXT)";

    //Table name and columns for workout
    public static final String TABLE_WORKOUT = "workout";
    public static final String WORKOUT_COLUMN_ID = "_id";
    public static final String WORKOUT_COLUMN_WORKOUT_PLAN_ID = "workout_plan_id";
    public static final String WORKOUT_COLUMN_EXERCISE_ID = "exercise_id";
    public static final String WORKOUT_COLUMN_REPETITIONS = "repetitions";
    public static final String WORKOUT_COLUMN_SETS = "sets";

    //Create workout table
    public static final String CREATE_TABLE_WORKOUT="CREATE TABLE "+TABLE_WORKOUT+" ("+
            WORKOUT_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            WORKOUT_COLUMN_WORKOUT_PLAN_ID+" INTEGER, "+
            WORKOUT_COLUMN_EXERCISE_ID+" INTEGER, "+
            WORKOUT_COLUMN_REPETITIONS+" INTEGER, "+
            WORKOUT_COLUMN_SETS+" INTEGER, "+
            "FOREIGN KEY(" + WORKOUT_COLUMN_WORKOUT_PLAN_ID + ") REFERENCES " + TABLE_WORKOUT_PLAN + " (" + WORKOUT_PLAN_COLUMN_ID + ")," +
            "FOREIGN KEY(" + WORKOUT_COLUMN_EXERCISE_ID + ") REFERENCES " + TABLE_EXERCISE + "(" + EXERCISE_COLUMN_ID + ")" +
            ")";

    //Table name and columns for workout record
    public static final String TABLE_WORKOUT_RECORD = "workout_record";
    public static final String WORKOUT_RECORD_COLUMN_ID = "_id";
    public static final String WORKOUT_RECORD_COLUMN_USER_ID = "user_id";
    public static final String WORKOUT_RECORD_COLUMN_WORKOUT_ID = "workout_id";
    public static final String WORKOUT_RECORD_COLUMN_DATE = "date";
    public static final String WORKOUT_RECORD_COLUMN_TIME = "time";
    public static final String WORKOUT_RECORD_COLUMN_DURATION = "duration";
    public static final String WORKOUT_RECORD_COLUMN_WEIGHT_USED = "weight_used";

    //create workout record
    public static final String CREATE_TABLE_WORKOUT_RECORD="CREATE TABLE "+TABLE_WORKOUT_RECORD+" ("+
            WORKOUT_RECORD_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            WORKOUT_RECORD_COLUMN_USER_ID+" INTEGER, "+
            WORKOUT_RECORD_COLUMN_WORKOUT_ID+" INTEGER, "+
            WORKOUT_RECORD_COLUMN_DATE+" TEXT, "+
            WORKOUT_RECORD_COLUMN_TIME+" TEXT, "+
            WORKOUT_RECORD_COLUMN_DURATION+" INTEGER, "+
            WORKOUT_RECORD_COLUMN_WEIGHT_USED+" REAL, "+
            "FOREIGN KEY(" + WORKOUT_RECORD_COLUMN_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "), "+
            "FOREIGN KEY(" + WORKOUT_RECORD_COLUMN_WORKOUT_ID + ") REFERENCES " + TABLE_WORKOUT + "(" + WORKOUT_COLUMN_ID + ")"+
            ")";
}