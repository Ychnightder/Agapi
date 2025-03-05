package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import iut.dam.agapi.managers.models.Association;

@Dao
public interface AssociationDAO {
    @Insert
    void insert(Association association);

    @Query("SELECT * FROM Association WHERE id_association = :idAssociation")
    Association getAssociationById(int idAssociation);
}
