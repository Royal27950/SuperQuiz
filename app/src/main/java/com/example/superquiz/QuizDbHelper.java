package com.example.superquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.superquiz.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AttackOnTitan.db";
    private  static final int DATABASE_VERSION = 2;

    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                AttackOnTitanQuestionsTable.TABLE_NAME + " (  " +
                AttackOnTitanQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AttackOnTitanQuestionsTable.COLUMN_QUESTION + " TEXT, " +
                AttackOnTitanQuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                AttackOnTitanQuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                AttackOnTitanQuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                AttackOnTitanQuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                AttackOnTitanQuestionsTable.COLUMN_ANSWER_NUMBER + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AttackOnTitanQuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionTable(){
        AttackOnTitanQuestion q1 = new AttackOnTitanQuestion("D est correct", "A","B","C","D",4);
        addQuestion(q1);
        AttackOnTitanQuestion q2 = new AttackOnTitanQuestion("D est correct", "A","B","C","D",4);
        addQuestion(q2);
        AttackOnTitanQuestion q3 = new AttackOnTitanQuestion("D est correct", "A","B","C","D",4);
        addQuestion(q3);
        AttackOnTitanQuestion q4 = new AttackOnTitanQuestion("D est correct", "A","B","C","D",4);
        addQuestion(q4);
        AttackOnTitanQuestion q5 = new AttackOnTitanQuestion("D est correct", "A","B","C","D",4);
        addQuestion(q5);
    }

    private void addQuestion(AttackOnTitanQuestion attackOnTitanQuestion){
        ContentValues cv = new ContentValues();
        cv.put(AttackOnTitanQuestionsTable.COLUMN_QUESTION, attackOnTitanQuestion.getQuestion());
        cv.put(AttackOnTitanQuestionsTable.COLUMN_OPTION1, attackOnTitanQuestion.getOption1());
        cv.put(AttackOnTitanQuestionsTable.COLUMN_OPTION2, attackOnTitanQuestion.getOption2());
        cv.put(AttackOnTitanQuestionsTable.COLUMN_OPTION3, attackOnTitanQuestion.getOption3());
        cv.put(AttackOnTitanQuestionsTable.COLUMN_OPTION4, attackOnTitanQuestion.getOption4());
        cv.put(AttackOnTitanQuestionsTable.COLUMN_ANSWER_NUMBER, attackOnTitanQuestion.getAnswerNumber());
        db.insert(AttackOnTitanQuestionsTable.TABLE_NAME, null, cv);
    }

    public List<AttackOnTitanQuestion> getAllQuestion(){
        List<AttackOnTitanQuestion> attackOnTitanQuestionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + AttackOnTitanQuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()){
            do {
                AttackOnTitanQuestion attackOnTitanQuestion = new AttackOnTitanQuestion();
                attackOnTitanQuestion.setQuestion(c.getString(c.getColumnIndex(AttackOnTitanQuestionsTable.COLUMN_QUESTION)));
                attackOnTitanQuestion.setOption1(c.getString(c.getColumnIndex(AttackOnTitanQuestionsTable.COLUMN_OPTION1)));
                attackOnTitanQuestion.setOption2(c.getString(c.getColumnIndex(AttackOnTitanQuestionsTable.COLUMN_OPTION2)));
                attackOnTitanQuestion.setOption3(c.getString(c.getColumnIndex(AttackOnTitanQuestionsTable.COLUMN_OPTION3)));
                attackOnTitanQuestion.setOption4(c.getString(c.getColumnIndex(AttackOnTitanQuestionsTable.COLUMN_OPTION4)));
                attackOnTitanQuestion.setAnswerNumber(c.getInt(c.getColumnIndex(AttackOnTitanQuestionsTable.COLUMN_ANSWER_NUMBER)));
                attackOnTitanQuestionList.add(attackOnTitanQuestion);
            }while (c.moveToNext());
        }
        c.close();
        return attackOnTitanQuestionList;
    }
}

