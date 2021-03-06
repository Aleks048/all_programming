package ca.uottawa.tophillhotelmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.MenuItem;
import java.util.Arrays;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.firebase.ui.auth.AuthUI;

public class MainActivity extends AppCompatActivity {


    //Firebase staff is here
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static int RC_SIGN_IN = 1;//login status
    public final String ANONYMUS = "ANANIMUS";
    private String mUsername = ANONYMUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button MEGABUTTON = (Button) findViewById(R.id.megaButton);
        MEGABUTTON.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "You SUCK!",
                        Toast.LENGTH_LONG).show();

            }
        });


        //initialize Firebase staff
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                //check if logined in
                if (user != null) {
                    //user is signed in
                    // Toast.makeText(MainActivity.this, "You are now sighned in.", Toast.LENGTH_SHORT).show();
                    onSignedInInitialize(user.getDisplayName());
                } else {
                    //user is not sighned out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)//log in every time
                                    .setAvailableProviders(
                                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }
//dealing with canceling during singing
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // Sign-in succeeded, set up the UI
                Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                // Sign in was canceled by the user, finish the activity
                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    //sighing out is coming soon

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//      switch (item.getItemId()) {
//                  case R.id.sign_out_menu:
//                            AuthUI.getInstance().signOut(this);
//                            return true;
//                    default:
//                            return super.onOptionsItemSelected(item);
//               }
//}

    //adding and removing listener if activity is on the background
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);

    }

    private void onSignedInInitialize(String user) {
        mUsername = user;
        //Build of main activity starts here
    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMUS;
        //destruction before loging out
    }


}
