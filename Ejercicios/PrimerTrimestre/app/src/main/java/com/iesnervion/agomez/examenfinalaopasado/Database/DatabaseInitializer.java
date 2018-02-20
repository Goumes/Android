package com.iesnervion.agomez.examenfinalaopasado.Database;

/**
 * Created by aleja on 21/01/2018.
 */

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.iesnervion.agomez.examenfinalaopasado.Models.Contact;

public class DatabaseInitializer {

    // Simulate a blocking operation delaying each Loan insertion with a delay:

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Contact addContact(AppDatabase db, int id, String name, String phone, int age, String gender) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setPhone(phone);
        contact.setAge(age);
        contact.setGender(gender);
        db.contactDao().insertContact(contact);
        return contact;
    }

    private static void populateWithTestData(AppDatabase db) {
        db.contactDao().deleteAll();

        addContact(db, 1, "pepa", "954554", 45, "Mujer");


    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }
}