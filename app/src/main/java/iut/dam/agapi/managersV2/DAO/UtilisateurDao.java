package iut.dam.agapi.managersV2.DAO;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managersV2.models.Utilisateur;

public interface UtilisateurDao {
    @Insert
    void insert(Utilisateur utilisateur);

    @Query("SELECT * FROM Utilisateur")
    List<Utilisateur> getAllUtilisateurs();
}
