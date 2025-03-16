package iut.dam.agapi.managers;

import android.content.Context;

import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;


import iut.dam.agapi.managers.DAO.AdministrateurAssoDAO;
import iut.dam.agapi.managers.DAO.AdministrateurDAO;
import iut.dam.agapi.managers.DAO.AssociationDAO;
import iut.dam.agapi.managers.DAO.CategorieDAO;
import iut.dam.agapi.managers.DAO.DonDAO;
import iut.dam.agapi.managers.DAO.RapportDAO;
import iut.dam.agapi.managers.DAO.UtilisateurDao;
import iut.dam.agapi.managers.models.Administrateur;
import iut.dam.agapi.managers.models.AdministrateurAsso;
import iut.dam.agapi.managers.models.Association;
import iut.dam.agapi.managers.models.Categorie;
import iut.dam.agapi.managers.models.Don;
import iut.dam.agapi.managers.models.Rapport;
import iut.dam.agapi.managers.models.Utilisateur;


@Database(entities = {Utilisateur.class,
        Administrateur.class,
        Categorie.class,
        Association.class,
        Don.class,
        AdministrateurAsso.class,
        Rapport.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UtilisateurDao utilisateurDao();
    public abstract DonDAO donDao();
    public abstract AdministrateurDAO administrateurDAO();
    public abstract CategorieDAO categorieDAO();
    public abstract AssociationDAO associationDAO();
    public abstract AdministrateurAssoDAO administrateurAssoDAO();
    public abstract RapportDAO rapportDAO();

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
