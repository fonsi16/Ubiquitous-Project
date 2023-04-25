package com.example.project_ubi.database;

import android.provider.BaseColumns;

public final class DatabaseContract {
    private DatabaseContract() {}

    public final class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
        public static final String COLUMN_HEIGHT = "height";
        public static final String COLUMN_WEIGHT = "weight";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_EMAIL + " TEXT," +
                        COLUMN_PASSWORD + " TEXT," +
                        COLUMN_DATE_OF_BIRTH + " TEXT," +
                        COLUMN_HEIGHT + " REAL," +
                        COLUMN_WEIGHT + " REAL)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public class WorkoutPlanEntry implements BaseColumns {
        public static final String TABLE_NAME = "workout_plan";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CREATION_DATE = "creation_date";
        public static final String COLUMN_GOAL = "goal";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_CREATION_DATE + " DATETIME," +
                        COLUMN_GOAL + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class ExerciseEntry implements BaseColumns {
        public static final String TABLE_NAME = "exercise";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WORKED_MUSCLES = "worked_muscles";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGE = "image";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_WORKED_MUSCLES + " TEXT," +
                        COLUMN_DESCRIPTION + " TEXT," +
                        COLUMN_IMAGE + " BLOB)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final class WorkoutEntry implements BaseColumns {

        public static final String TABLE_NAME = "workout";
        public static final String COLUMN_WORKOUT_PLAN_ID = "workout_plan_id";
        public static final String COLUMN_EXERCISE_ID = "exercise_id";
        public static final String COLUMN_REPETITIONS = "repetitions";
        public static final String COLUMN_SETS = "sets";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_WORKOUT_PLAN_ID + " INTEGER," +
                        COLUMN_EXERCISE_ID + " INTEGER," +
                        COLUMN_REPETITIONS + " INTEGER," +
                        COLUMN_SETS + " INTEGER," +
                        "FOREIGN KEY (" + COLUMN_WORKOUT_PLAN_ID + ") REFERENCES " +
                        WorkoutPlanEntry.TABLE_NAME + "(" + WorkoutPlanEntry._ID + ")," +
                        "FOREIGN KEY (" + COLUMN_EXERCISE_ID + ") REFERENCES " +
                        ExerciseEntry.TABLE_NAME + "(" + ExerciseEntry._ID + ")" +
                        ")";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

        private WorkoutEntry() {}
    }

    public final class WorkoutRecordEntry implements BaseColumns {
        public static final String TABLE_NAME = "workout_record";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_WORKOUT_ID = "workout_id";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_WEIGHT_USED = "weight_used";

        private static final String INTEGER_TYPE = " INTEGER";
        private static final String REAL_TYPE = " REAL";
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
                        COLUMN_USER_ID + INTEGER_TYPE + COMMA_SEP +
                        COLUMN_WORKOUT_ID + INTEGER_TYPE + COMMA_SEP +
                        COLUMN_DATE + TEXT_TYPE + COMMA_SEP +
                        COLUMN_TIME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_DURATION + INTEGER_TYPE + COMMA_SEP +
                        COLUMN_WEIGHT_USED + REAL_TYPE + COMMA_SEP +
                        "FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " +
                        UserEntry.TABLE_NAME + "(" + UserEntry._ID + ")" + COMMA_SEP +
                        "FOREIGN KEY (" + COLUMN_WORKOUT_ID + ") REFERENCES " +
                        WorkoutEntry.TABLE_NAME + "(" + WorkoutEntry._ID + ")" +
                        ")";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

        private WorkoutRecordEntry() {}
    }

    public final class FeedbackEntry implements BaseColumns {
        public static final String TABLE_NAME = "feedback";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_SUBJECT = "subject";
        public static final String COLUMN_MESSAGE_BODY = "message_body";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USER_ID + " INTEGER NOT NULL, " +
                COLUMN_SUBJECT + " TEXT NOT NULL, " +
                COLUMN_MESSAGE_BODY + " TEXT NOT NULL, " +
                "FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " +
                UserEntry.TABLE_NAME + " (" + UserEntry._ID + "));";

        private FeedbackEntry() {}
    }

}

