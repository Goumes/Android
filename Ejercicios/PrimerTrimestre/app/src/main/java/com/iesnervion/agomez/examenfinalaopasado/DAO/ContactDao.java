package com.iesnervion.agomez.examenfinalaopasado.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by aleja on 20/02/2018.
 */

@Dao
public interface ContactDao
{
   @Query("SELECT * FROM contacts")
    public LiveData<List<Contact>> cargarTodosContactos ();

    @Insert(onConflict = REPLACE)
    void insertContact(Contact contact);

    @Query("DELETE FROM contacts")
    void deleteAll();

    @Update
    void updateContact (Contact contact);
}
