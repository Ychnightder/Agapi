package iut.dam.agapi.databases.managers;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import iut.dam.agapi.databases.DatabaseManager;
import iut.dam.agapi.databases.models.Utilisateur;
public class ManagerUtilisateur {
    private Context context;
    public static String getTableName() {
        return TABLE_NAME;
    }
    private static String TABLE_NAME = "Utilisateur";
    private static final String COLUMN_ID = "id_utilisateur";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_PRENOM = "prenom_";
    private static final String COLUMN_EMAIL = "email_";
    private static final String COLUMN_MOT_DE_PASSE = "mot_de_passe_";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOM + " TEXT NOT NULL, " +
            COLUMN_PRENOM + " TEXT, " +
            COLUMN_EMAIL + " TEXT NOT NULL UNIQUE, " +
            COLUMN_MOT_DE_PASSE + " TEXT NOT NULL)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private DatabaseManager dbManager;
    public ManagerUtilisateur(Context context) {
        this.context = context;
        dbManager = new DatabaseManager(this.context);
    }
    public void close() {
        dbManager.close();
    }
    public void addUtilisateur(Utilisateur utilisateur) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, utilisateur.getNom());
        values.put(COLUMN_PRENOM, utilisateur.getPrenom());
        values.put(COLUMN_EMAIL, utilisateur.getEmail());
        values.put(COLUMN_MOT_DE_PASSE, utilisateur.getMotDePasse());
//        long result =
         db.insert(TABLE_NAME, null, values);
         // gestion d'erreur
//        if(result == -1){
//            Toast.makeText(context, "fail to add Utilisateur", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(context, "Utilisateur added", Toast.LENGTH_SHORT).show();
//        }
        db.close();
    }

    public Utilisateur getUtilisateurByEmail(String email) {
        SQLiteDatabase db = dbManager.getReadableDatabase();
        String[] columns = {COLUMN_ID, COLUMN_NOM, COLUMN_PRENOM, COLUMN_EMAIL, COLUMN_MOT_DE_PASSE};
        String selection = COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        Utilisateur utilisateur = null;
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String nom = cursor.getString(cursor.getColumnIndex(COLUMN_NOM));
            String prenom = cursor.getString(cursor.getColumnIndex(COLUMN_PRENOM));
            String motDePasse = cursor.getString(cursor.getColumnIndex(COLUMN_MOT_DE_PASSE));
            utilisateur = new Utilisateur(nom, prenom, email, motDePasse);
        }
        cursor.close();
        db.close();
        return utilisateur;
    }

    public boolean deleteUtilisateurByEmail(String email) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        String whereClause = COLUMN_EMAIL + " = ?";
        String[] whereArgs = {email};
        int rowsDeleted = db.delete(TABLE_NAME, whereClause, whereArgs);
        db.close();
        return rowsDeleted > 0;
    }

    public boolean updateUtilisateur(Utilisateur utilisateur) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, utilisateur.getNom());
        values.put(COLUMN_PRENOM, utilisateur.getPrenom());
        values.put(COLUMN_MOT_DE_PASSE, utilisateur.getMotDePasse());
        values.put(COLUMN_EMAIL, utilisateur.getEmail());
        // Mettre à jour l'utilisateur dans la base de données
        int rowsAffected = db.update(TABLE_NAME, values, COLUMN_EMAIL + " = ?", new String[]{utilisateur.getEmail()});
        db.close();
        return rowsAffected > 0;
    }


    public boolean utilisateurExists(String email) {
        SQLiteDatabase db = dbManager.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT 1 FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + " = ?", new String[]{email});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }


    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        SQLiteDatabase db = dbManager.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, COLUMN_NOM + " ASC");
        if (cursor.moveToFirst()) {
            do {
                String nom = cursor.getString(cursor.getColumnIndex(COLUMN_NOM));
                String prenom = cursor.getString(cursor.getColumnIndex(COLUMN_PRENOM));
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
                String motDePasse = cursor.getString(cursor.getColumnIndex(COLUMN_MOT_DE_PASSE));

                utilisateurs.add(new Utilisateur(nom, prenom, email, motDePasse));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return utilisateurs;
    }

}
