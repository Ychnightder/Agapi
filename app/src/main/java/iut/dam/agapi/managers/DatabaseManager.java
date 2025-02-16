package iut.dam.agapi.managers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.jetbrains.annotations.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agapi.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ManagerUtilisateur.CREATE_TABLE);
        db.execSQL(ManagerAssociation.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ManagerUtilisateur.getTableName());
        db.execSQL("DROP TABLE IF EXISTS " + ManagerAssociation.getTableName());
        onCreate(db);
    }
}
