package com.example.project_ubi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "workout_tracker.db";
    private static final int DATABASE_VERSION = 1;

    // Constantes para a tabela User
    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_GENDER = "gender";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PASSWORD = "password";
    private static final String COLUMN_USER_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_USER_HEIGHT = "height";
    private static final String COLUMN_USER_WEIGHT = "weight";

    // Constantes para a tabela WorkoutPlan
    private static final String TABLE_WORKOUT_PLAN = "workout_plan";
    private static final String COLUMN_WORKOUT_PLAN_ID = "id";
    private static final String COLUMN_WORKOUT_PLAN_NAME = "name";
    private static final String COLUMN_WORKOUT_PLAN_DESCRIPTION = "description";
    private static final String COLUMN_WORKOUT_PLAN_USER_ID = "user_id";

    // Constantes para a tabela Exercise
    private static final String TABLE_EXERCISE = "exercise";
    private static final String COLUMN_EXERCISE_ID = "id";
    private static final String COLUMN_EXERCISE_NAME = "name";
    private static final String COLUMN_EXERCISE_DESCRIPTION = "description";

    // Constantes para a tabela Workout
    private static final String TABLE_WORKOUT = "workout";
    private static final String COLUMN_WORKOUT_ID = "id";
    private static final String COLUMN_WORKOUT_DATE = "date";
    private static final String COLUMN_WORKOUT_WORKOUT_PLAN_ID = "workout_plan_id";

    // Constantes para a tabela WorkoutRecord
    private static final String TABLE_WORKOUT_RECORD = "workout_record";
    private static final String COLUMN_WORKOUT_RECORD_ID = "id";
    private static final String COLUMN_WORKOUT_RECORD_EXERCISE_ID = "exercise_id";
    private static final String COLUMN_WORKOUT_RECORD_WORKOUT_ID = "workout_id";
    private static final String COLUMN_WORKOUT_RECORD_WEIGHT = "weight";
    private static final String COLUMN_WORKOUT_RECORD_REPETITIONS = "repetitions";
    private static final String COLUMN_WORKOUT_RECORD_SETS = "sets";

    // Constantes para a tabela Feedback
    private static final String TABLE_FEEDBACK = "feedback";
    private static final String COLUMN_FEEDBACK_ID = "id";
    private static final String COLUMN_FEEDBACK_DATE = "date";
    private static final String COLUMN_FEEDBACK_USER_ID = "user_id";
    private static final String COLUMN_FEEDBACK_TEXT = "text";

    // Comandos SQL para criação das tabelas
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER +
            "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_NAME + " TEXT," +
            COLUMN_USER_GENDER + " TEXT," +
            COLUMN_USER_EMAIL + " TEXT," +
            COLUMN_USER_PASSWORD + " TEXT," +
            COLUMN_USER_DATE_OF_BIRTH + " INTEGER," +
            COLUMN_USER_HEIGHT + " REAL," +
            COLUMN_USER_WEIGHT + " REAL" + ")";

    private static final String CREATE_TABLE_WORKOUT_PLAN = "CREATE TABLE " + TABLE_WORKOUT_PLAN +
            "(" + COLUMN_WORKOUT_PLAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_WORKOUT_PLAN_NAME + " TEXT," +
            COLUMN_WORKOUT_PLAN_DESCRIPTION + " TEXT," +
            COLUMN_WORKOUT_PLAN_USER_ID + " INTEGER," +
            "FOREIGN KEY(" + COLUMN_WORKOUT_PLAN_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ")" +
            ")";


    private static final String CREATE_TABLE_EXERCISE = "CREATE TABLE " + TABLE_EXERCISE +
            "(" + COLUMN_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_EXERCISE_NAME + " TEXT," +
            COLUMN_EXERCISE_DESCRIPTION + " TEXT" + ")";

    private static final String CREATE_TABLE_WORKOUT = "CREATE TABLE " + TABLE_WORKOUT +
            "(" + COLUMN_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_WORKOUT_DATE + " INTEGER," +
            COLUMN_WORKOUT_WORKOUT_PLAN_ID + " INTEGER," +
            "FOREIGN KEY (" + COLUMN_WORKOUT_WORKOUT_PLAN_ID + ") REFERENCES " + TABLE_WORKOUT_PLAN + "(" + COLUMN_WORKOUT_PLAN_ID + "))";

    private static final String CREATE_TABLE_WORKOUT_RECORD = "CREATE TABLE " + TABLE_WORKOUT_RECORD +
            "(" + COLUMN_WORKOUT_RECORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_WORKOUT_RECORD_EXERCISE_ID + " INTEGER," +
            COLUMN_WORKOUT_RECORD_WORKOUT_ID + " INTEGER," +
            COLUMN_WORKOUT_RECORD_WEIGHT + " REAL," +
            COLUMN_WORKOUT_RECORD_REPETITIONS + " INTEGER," +
            COLUMN_WORKOUT_RECORD_SETS + " INTEGER," +
            "FOREIGN KEY (" + COLUMN_WORKOUT_RECORD_EXERCISE_ID + ") REFERENCES " + TABLE_EXERCISE + "(" + COLUMN_EXERCISE_ID + ")," +
            "FOREIGN KEY (" + COLUMN_WORKOUT_RECORD_WORKOUT_ID + ") REFERENCES " + TABLE_WORKOUT + "(" + COLUMN_WORKOUT_ID + "))";

    private static final String CREATE_TABLE_FEEDBACK = "CREATE TABLE " + TABLE_FEEDBACK +
            "(" + COLUMN_FEEDBACK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_FEEDBACK_DATE + " INTEGER," +
            COLUMN_FEEDBACK_USER_ID + " INTEGER," +
            COLUMN_FEEDBACK_TEXT + " TEXT," +
            "FOREIGN KEY (" + COLUMN_FEEDBACK_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "))";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_WORKOUT_PLAN);
        db.execSQL(CREATE_TABLE_EXERCISE);
        db.execSQL(CREATE_TABLE_WORKOUT);
        db.execSQL(CREATE_TABLE_WORKOUT_RECORD);
        db.execSQL(CREATE_TABLE_FEEDBACK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Caso seja necessário fazer uma atualização da estrutura do banco de dados, implemente aqui
    }


}