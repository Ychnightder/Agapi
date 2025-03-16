package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import iut.dam.agapi.managers.models.Don;

@Dao
public interface DonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Don don);

    @Query("SELECT * FROM Don WHERE id_utilisateur = :idUtilisateur")
    List<Don> getDonsByUtilisateur(int idUtilisateur);

    @Query("SELECT * FROM Don WHERE id_association = :idAssociation")
    List<Don> getDonsByAssociation(int idAssociation);
}
