package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managers.models.Utilisateur;

@Dao
public interface UtilisateurDao {
    @Insert
    void insert(Utilisateur utilisateur);

    @Query("SELECT * FROM Utilisateur")
    List<Utilisateur> getAllUtilisateurs();

    @Query("SELECT * FROM Utilisateur WHERE email_ = :email")
    Utilisateur getUtilisateurByEmail(String email);
}
