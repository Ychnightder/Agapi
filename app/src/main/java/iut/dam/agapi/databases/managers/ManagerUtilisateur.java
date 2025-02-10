package iut.dam.agapi.databases.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
    void addUtilisateur(Utilisateur utilisateur) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOM, utilisateur.getNom());
        values.put(COLUMN_PRENOM, utilisateur.getPrenom());
        values.put(COLUMN_EMAIL, utilisateur.getEmail());
        values.put(COLUMN_MOT_DE_PASSE, utilisateur.getMotDePasse());
       long result = db.insert(TABLE_NAME, null, values);

        if(result == -1){
            Toast.makeText(context, "fail to add Utilisateur", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Utilisateur added", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }




    public void close() {
        dbManager.close();
    }

}
