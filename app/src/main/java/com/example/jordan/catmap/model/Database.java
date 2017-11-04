package com.example.jordan.catmap.model;

import com.google.android.gms.maps.model.LatLng;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Jordan on 11/4/2017.
 */

public class Database {
    /**
     * Method to check if a user is valid
     *
     * @param email user email
     * @param password the user password
     * @return whether the email and password combo matches database
     */

    private static FirebaseDatabase database;
    private static DatabaseReference userRef;
    private static DatabaseReference reportRef;

    public Database() {
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("User/");
        reportRef = database.getReference("Reports/");
    }

    public boolean checkCredentials(String email, String password) {
        return true;
    }

    /**
     * Method to add user to database
     * @param email email of user
     * @param name name of user
     */
    public static void createUser(final String email, final String name) {
        DatabaseReference realRef = userRef.child(email);
        DatabaseReference nameChild = realRef.child("Name");
        nameChild.setValue(name);

    }

    /**
     * Add a report to the database
     * @param reportLocation location of the report being filed
     */
    public void report(LatLng reportLocation) {

    }

}
