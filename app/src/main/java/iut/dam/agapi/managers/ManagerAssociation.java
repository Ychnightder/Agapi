package iut.dam.agapi.managers;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import iut.dam.agapi.managers.models.Association;


public class ManagerAssociation {
    private Context context;
    private DatabaseManager dbManager;

    private static final String TABLE_NAME = "Association";
    private static final String COLUMN_ID = "id_association";
    private static final String COLUMN_NOM = "nom_association_";
    private static final String COLUMN_DESCRIPTION = "Description_";
    private static final String COLUMN_LOGO = "Logo_";
    private static final String COLUMN_QRCODE = "QRCode_";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOM + " TEXT NOT NULL, " +
            COLUMN_DESCRIPTION + " TEXT, " +
            COLUMN_LOGO + " TEXT, " +
            COLUMN_QRCODE + " TEXT)";


    public ManagerAssociation(Context context) {
        this.context = context;
        dbManager = new DatabaseManager(this.context);
    }

    public static String getTableName() {
        return TABLE_NAME;
    }
    public  void close() {
        dbManager.close();
    }
    public void addAssociation(Association association) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, association.getNom());
        values.put(COLUMN_DESCRIPTION, association.getDescription());
        values.put(COLUMN_LOGO, association.getLogo());
        values.put(COLUMN_QRCODE, association.getQrCode());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public Association getAssociationById(int id) {
        SQLiteDatabase db = dbManager.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_NOM, COLUMN_DESCRIPTION, COLUMN_LOGO, COLUMN_QRCODE};
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        Association association = null;
        if (cursor.moveToFirst()) {
            String nom = cursor.getString(cursor.getColumnIndex(COLUMN_NOM));
            String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
            String logo = cursor.getString(cursor.getColumnIndex(COLUMN_LOGO));
            String qrCode = cursor.getString(cursor.getColumnIndex(COLUMN_QRCODE));
            association = new Association(id, nom, description, logo, qrCode);
        }
        cursor.close();
        db.close();
        return association;
    }
    public List<Association> getAllAssociations() {
        List<Association> associations = new ArrayList<>();
        SQLiteDatabase db = dbManager.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, COLUMN_NOM + " ASC");

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String nom = cursor.getString(cursor.getColumnIndex(COLUMN_NOM));
                String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                String logo = cursor.getString(cursor.getColumnIndex(COLUMN_LOGO));
                String qrCode = cursor.getString(cursor.getColumnIndex(COLUMN_QRCODE));
                associations.add(new Association(id, nom, description, logo, qrCode));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return associations;
    }
    public void deleteAssociation(int id) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

}
