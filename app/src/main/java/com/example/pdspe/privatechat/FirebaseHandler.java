package com.example.pdspe.privatechat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by pdspe on 26-Jan-18.
 */

public class FirebaseHandler {

    // parameters
    private RegisterActivity context;
    private String userKey;
    private DatabaseReference databaseReference;
    private static boolean isPersistenceEnabled = false;
    private static String fixedLocationA = "locationA";
    private static String fixedLocationB = "locationB";

    public FirebaseHandler(RegisterActivity context, String userKey) {
        this.context = context;    // context can be used to call PreferenceManager etc.
        this.userKey = userKey;
        if (!isPersistenceEnabled) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            isPersistenceEnabled = true;
        }
        databaseReference = FirebaseDatabase.getInstance().getReference().child(userKey);
    }

    public DatabaseReference getRefA() {
        return databaseReference.child(fixedLocationA);
    }

    public DatabaseReference getRefB() {
        return databaseReference.child(fixedLocationB);
    }
}