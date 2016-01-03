package xyz.yakdmt.navremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.tasks.AuthTask;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 29/11/15.
 */
public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView, mFtpServer, mFtpUsername, mFtpPassword, mFtpPort, mFtpPath;
    private View mProgressView;
    private View mLoginFormView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.skipLogin) {
            App.currentClientId = "10111";
            App.currentContactId = "C000023";
            openMainActivity();
            finish();
        }
        if (!TextUtils.isEmpty(App.sharedPreferences.getString("contact_id", ""))
                && !TextUtils.isEmpty(App.sharedPreferences.getString("client_id", ""))) {
            openMainActivity();
            finish();
        }
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        mFtpServer = (EditText) findViewById(R.id.ftp_server);
        mFtpUsername = (EditText) findViewById(R.id.ftp_username);
        mFtpPassword = (EditText) findViewById(R.id.ftp_pass);
        mFtpPort = (EditText) findViewById(R.id.ftp_port);
        mFtpPath = (EditText) findViewById(R.id.ftp_path);

        mEmailView.setText(App.sharedPreferences.getString("login", ""));
        mPasswordView.setText(App.sharedPreferences.getString("password", ""));
        mFtpServer.setText(App.sharedPreferences.getString("ftp_server", ""));
        mFtpUsername.setText(App.sharedPreferences.getString("ftp_username", ""));
        mFtpPassword.setText(App.sharedPreferences.getString("ftp_password", ""));
        mFtpPort.setText(App.sharedPreferences.getString("ftp_port", ""));
        mFtpPath.setText(App.sharedPreferences.getString("ftp_path", ""));
    }

    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String ftpServer = mFtpServer.getText().toString();
        String ftpUsername = mFtpUsername.getText().toString();
        String ftpPassword = mFtpPassword.getText().toString();
        String ftpPort = mFtpPort.getText().toString();
        String ftpPath = mFtpPath.getText().toString();



        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError("неверный пароль");
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError("Поле не заполнено");
            focusView = mEmailView;
            cancel = true;
        }
        if (TextUtils.isEmpty(ftpServer)) {
            mFtpServer.setError("Поле не заполнено");
            focusView = mFtpServer;
            cancel = true;
        }
        if (TextUtils.isEmpty(ftpUsername)) {
            mFtpUsername.setError("Поле не заполнено");
            focusView = mFtpUsername;
            cancel = true;
        }
        if (TextUtils.isEmpty(ftpPassword)) {
            mFtpPassword.setError("Поле не заполнено");
            focusView = mFtpPassword;
            cancel = true;
        }
        if (TextUtils.isEmpty(ftpPort)) {
            mFtpPort.setError("Поле не заполнено");
            focusView = mFtpPort;
            cancel = true;
        }
        if (TextUtils.isEmpty(ftpPath)) {
            mFtpPath.setError("Поле не заполнено");
            focusView = mFtpPath;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            checkCredentials(mEmailView.getText().toString(), mPasswordView.getText().toString(),
                        mFtpServer.getText().toString(), mFtpUsername.getText().toString(),
                        mFtpPassword.getText().toString(), mFtpPort.getText().toString(),
                        mFtpPath.getText().toString());
        }
    }

    private void checkCredentials(String login, String password, String ftpServer, String ftpUsername,
                                  String ftpPass, String ftpPort, String ftpPath){
        App.sharedPreferences.edit().putString("login", login).commit();
        App.sharedPreferences.edit().putString("password", password).commit();
        App.sharedPreferences.edit().putString("ftp_server", ftpServer).commit();
        App.sharedPreferences.edit().putString("ftp_username", ftpUsername).commit();
        App.sharedPreferences.edit().putString("ftp_password", ftpPass).commit();
        App.sharedPreferences.edit().putString("ftp_port", ftpPort).commit();
        App.sharedPreferences.edit().putString("ftp_path", ftpPath).commit();
        new AuthTask(this, mProgressView).execute(login, password, ftpServer, ftpUsername, ftpPass, ftpPort, ftpPath);
    }

    @SuppressWarnings("unused")
    public void onEvent(Events.OnAuthCompleted event) {
        if (event.getIsOk()) {
            openMainActivity();
        } else {
            Toast.makeText(this, "Неверный логин/пароль",Toast.LENGTH_LONG).show();
        }
    }

    public void openMainActivity(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
