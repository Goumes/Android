package com.iesnervion.agomez.examenfinalaopasado.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.iesnervion.agomez.examenfinalaopasado.DAO.ContactDao;
import com.iesnervion.agomez.examenfinalaopasado.Database.AppDatabase;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;

import java.util.List;

/**
 * Created by aleja on 20/02/2018.
 */

public class ContactRepository
{
    private ContactDao mContactDao;
    private LiveData<List<Contact>> mTodosContactos;

    public ContactRepository(Application application)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        mContactDao = db.contactDao();
        mTodosContactos = mContactDao.cargarTodosContactos();
    }

    public LiveData<List<Contact>> getContactos() {
        return mTodosContactos;
    }

    public void insertContact (Application application, Contact contact)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        db.contactDao().insertContact(contact);
    }

    public void updateContact (Application application, Contact contact)
    {
        AppDatabase db = AppDatabase.getDatabase(application);
        db.contactDao().updateContact(contact);
    }

}
