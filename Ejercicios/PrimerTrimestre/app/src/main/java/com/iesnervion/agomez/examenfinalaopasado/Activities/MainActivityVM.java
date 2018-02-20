package com.iesnervion.agomez.examenfinalaopasado.Activities;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.iesnervion.agomez.examenfinalaopasado.Database.AppDatabase;
import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;
import com.iesnervion.agomez.examenfinalaopasado.Repositories.ContactRepository;

import java.util.List;

/**
 * Created by aleja on 20/02/2018.
 */

public class MainActivityVM extends AndroidViewModel
{
    private MutableLiveData<Integer> opcion;
    private LiveData<List<Contact>> contactos;
    private ContactRepository mRepositorio;
    private MutableLiveData<Contact> contactoSeleccionado;


    public MainActivityVM(@NonNull Application application) {
        super(application);

        mRepositorio = new ContactRepository(application);

        contactos = mRepositorio.getContactos();

        opcion = new MutableLiveData<>();

        contactoSeleccionado = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion.setValue(opcion);
    }

    public LiveData<List<Contact>> getContactos() {
        return contactos;
    }

    public void setContactos(LiveData<List<Contact>> contactos) {
        this.contactos = contactos;
    }

    public ContactRepository getmRepositorio() {
        return mRepositorio;
    }

    public void setmRepositorio(ContactRepository mRepositorio) {
        this.mRepositorio = mRepositorio;
    }

    public void insertContact (Contact contact)
    {
        mRepositorio.insertContact(this.getApplication(), contact);
    }

    public void updateContact (Contact contact)
    {
        mRepositorio.updateContact(this.getApplication(), contact);
    }

    public MutableLiveData<Contact> getContactoSeleccionado() {
        return contactoSeleccionado;
    }

    public void setContactoSeleccionado(Contact contactoSeleccionado) {
        this.contactoSeleccionado.setValue(contactoSeleccionado);
    }
}
