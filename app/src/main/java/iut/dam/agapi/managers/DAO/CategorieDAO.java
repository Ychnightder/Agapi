package iut.dam.agapi.managers.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import iut.dam.agapi.managers.models.Categorie;

@Dao
public interface CategorieDAO {
    @Insert
    void insert(Categorie categorie);

    @Query("SELECT * FROM Categorie WHERE idCategorie = :idCategorie")
    Categorie getCategorieById(String idCategorie);
}