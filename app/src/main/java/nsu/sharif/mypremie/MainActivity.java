package nsu.sharif.mypremie;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends Activity {

    //Variables Declarations.
    private Button hitSignUpButton;
    LoginButton login_button;
    CallbackManager callbackManager;

    //For Testing
    private Button hitLogInButton;

    //Removed Title Bar By Using requestWindowFeature.
    //Initialized CallBackManager for Handling the login Response.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //Sign Up Button properties, Where a onClickListener is used to initialize the nxt view.
        //hitSignUpButton = (Button) findViewById(R.id.buttonNewAccountCreate);

        //For Testing the button
        hitLogInButton = (Button) findViewById(R.id.buttonlogInButton);
        hitLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateLogInPage();
            }
        });

        //Facebook Button Properties
        login_button = findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();

        // Callback registration
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //Now Making a toast if Login is successfull.

                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {

            }
        });
    }

    // Calling callbackManager.onActivityResult to pass the login results to the LoginManager via callbackManager.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    //Change the activity from Login Page to Sign Up Page.
    //After Hitting the button Intent class show a new view.
    public void activateSignUpPage(){
        Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void activateLogInPage(){
        Intent intent = new Intent(MainActivity.this,NavigationDrawerView.class);
        startActivity(intent);
    }

    public void createAccount(View view) {
        startActivity(new Intent(this,SignUpActivity.class));
    }
}
