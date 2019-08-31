package nsu.sharif.mypremie;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SignUpActivity extends Activity {


    EditText etFirstName,etLastName,etDateOfBirth,etMobileNumber,etEmail,etPassword,etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etFirstName = (EditText) findViewById(R.id.editTextFirstName);
        etLastName = (EditText)findViewById(R.id.editTextLastName);
        etDateOfBirth = (EditText)findViewById(R.id.editTextDateInput);
        etMobileNumber = (EditText)findViewById(R.id.editTextPhoneNumber);
        etEmail = (EditText)findViewById(R.id.editTextEmail);
        etPassword  = (EditText)findViewById(R.id.editTextPassword);
        etConfirmPassword  = (EditText)findViewById(R.id.editTextConfirmPassword);
    }


    public void saveInfo(View view) {
        String confirmPassword = etConfirmPassword.getText().toString();
        boolean error = false;
        String firstName = etFirstName.getText().toString();
        if(firstName.isEmpty()){
            etFirstName.setError("নামের প্রথম অংশ মিসিং!");
            error = true;
        }

        String lastName = etLastName.getText().toString();
        if(lastName.isEmpty()){
            etLastName.setError("নামের শেষাংশ মিসিং!");
            error = true;
        }

        String dateOfBirth = etDateOfBirth.getText().toString();
        if(dateOfBirth.isEmpty()){
            etDateOfBirth.setError("জন্ম তারিখ মিসিং!");
            error = true;
        }

        String mobileNo = etMobileNumber.getText().toString();
        if(mobileNo.isEmpty()){
            etMobileNumber.setError("মোবাইল নাম্বার মিসিং!");
            error = true;
        }else if(mobileNo.length()==11){

        }else if (mobileNo.length()>11){
            etMobileNumber.setError("মোবাইল নাম্বার ১১ ডিজিটের বেশি নয়");
            error = true;

        }else if (mobileNo.length()<11){
            etMobileNumber.setError("মোবাইল নাম্বার ১১ ডিজিটের কম নয়");
            error = true;
        }

        String emailId = etEmail.getText().toString();
        if(emailId.isEmpty()){
            etEmail.setError("ই-মেইল মিসিং!");
            error = true;
        }

        String enterPassword = etPassword.getText().toString();
        if(enterPassword.isEmpty()){
            etPassword.setError("পাসওয়ার্ড মিসিং!");
            error = true;
        }else if(enterPassword.length()<8){
            etPassword.setError("পাসওয়ার্ড ৮ ডিজিটের কম!");
            error = true;
        }
        if(confirmPassword.isEmpty()){
            etConfirmPassword.setError("পাসওয়ার্ড মিসিং!");
            error = true;
        }else if(!enterPassword.equals(confirmPassword)){
            etConfirmPassword.setError("পাসওয়ার্ড মিলে নাই !");
            error = true;
        }

        BackgroundTask backgroundTask =new BackgroundTask();
        backgroundTask.execute(firstName,lastName,dateOfBirth,mobileNo,emailId,enterPassword,confirmPassword);
    }



    class BackgroundTask extends AsyncTask<String,Void,String>
    {
        String add_info_url;
        @Override
        protected void onPreExecute() {
            add_info_url = "http://jachaibd.com/myPremie/add_info.php";
        }

        @Override
        protected String doInBackground(String... args) {
            String firstName,lastName,dateOfBirth,mobileNo,emailId,enterPassword,confirmPassword;
            firstName = args[0];
            lastName = args[1];
            dateOfBirth = args[2];
            mobileNo = args[3];
            emailId = args[4];
            enterPassword = args[5];
            confirmPassword = args[6];


            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data_string =  URLEncoder.encode("firstName","UTF-8")+"="+URLEncoder.encode(firstName,"UTF-8")+"&"
                                     +URLEncoder.encode("lastName","UTF-8")+"="+URLEncoder.encode(lastName,"UTF-8")+"&"+
                        URLEncoder.encode("dateOfBirth","UTF-8")+"="+URLEncoder.encode(dateOfBirth,"UTF-8")+"&"
                        +URLEncoder.encode("mobileNo","UTF-8")+"="+URLEncoder.encode(mobileNo,"UTF-8")+"&"+
                        URLEncoder.encode("emailId","UTF-8")+"="+URLEncoder.encode(emailId,"UTF-8")+"&"
                        +URLEncoder.encode("enterPassword","UTF-8")+"="+URLEncoder.encode(enterPassword,"UTF-8")+"&"+
                        URLEncoder.encode("confirmPassword","UTF-8")+"="+URLEncoder.encode(confirmPassword,"UTF-8");
                        bufferedWriter.write(data_string);
                        
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        inputStream.close();
                        httpURLConnection.disconnect();

                        return "One Row of data inserted.. ";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }
    }


}
