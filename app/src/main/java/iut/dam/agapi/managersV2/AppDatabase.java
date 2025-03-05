package iut.dam.agapi.managersV2;

import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;


import iut.dam.agapi.managersV2.DAO.DonDao;
import iut.dam.agapi.managersV2.DAO.UtilisateurDao;
import iut.dam.agapi.managersV2.models.Administrateur;
import iut.dam.agapi.managersV2.models.AdministrateurAsso;
import iut.dam.agapi.managersV2.models.Association;
import iut.dam.agapi.managersV2.models.Categorie;
import iut.dam.agapi.managersV2.models.Don;
import iut.dam.agapi.managersV2.models.Rapport;
import iut.dam.agapi.managersV2.models.Utilisateur;


@Database(entities = {Utilisateur.class, Administrateur.class, Categorie.class,
        Association.class, Don.class,
        AdministrateurAsso.class, Rapport.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UtilisateurDao utilisateurDao();
    public abstract DonDao donDao();


    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Agapi")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}
