package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managers.models.Utilisateur;

@Dao
public interface UtilisateurDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Utilisateur utilisateur);

    @Query("SELECT * FROM Utilisateur WHERE email = :email")
    Utilisateur getUtilisateurByEmail(String email);

    @Query("SELECT * FROM Utilisateur WHERE email = :email AND mot_de_passe = :motDePasse")
    Utilisateur login(String email, String motDePasse);
}
