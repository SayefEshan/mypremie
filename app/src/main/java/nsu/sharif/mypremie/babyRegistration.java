package nsu.sharif.mypremie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class babyRegistration extends AppCompatActivity {

    EditText etBabyName,etBabyBirthDate,etBabyGender,etBirthWeek,etBabyHeight,etBabyWeight,etBabyHeadsize,etBabySpecialCase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_registration);

        etBabyName = findViewById(R.id.editTextBabyname);
        etBabyBirthDate = findViewById(R.id.editTextBabyBirthday);
        etBabyGender= findViewById(R.id.editTextBabyGender);
        etBirthWeek = findViewById(R.id.editTextBabyBirthWeek);
        etBabyHeadsize = findViewById(R.id.editTextBabyheadSize);
        etBabyHeight = findViewById(R.id.editTextBabyheight);
        etBabyWeight = findViewById(R.id.editTextBabyWight);
        etBabySpecialCase = findViewById(R.id.editTextBabySpecialCase);
    }

    public void saveBabyData(View view){
        boolean error = false;
        String babyName = etBabyName.getText().toString();
        if(babyName.isEmpty()){
            etBabyName.setError("শিশুর নাম মিসিং!");
            error = true;
        }

        String babyBirthDate = etBabyBirthDate.getText().toString();
        if(babyBirthDate .isEmpty()){
            etBabyBirthDate.setError("শিশুর জন্ম তারিখ মিসিং!");
            error = true;
        }


        String babyGender = etBabyGender.getText().toString();
        if(babyGender.isEmpty()){
            etBabyGender.setError("শিশুর লিঙ্গ  মিসিং!");
            error = true;
        }

        String birthWeek = etBirthWeek.getText().toString();
        if(birthWeek.isEmpty()){
            etBirthWeek.setError("শিশুর জন্মের সপ্তাহ  মিসিং!");
            error = true;
        }

        String babyHeadSize = etBabyHeadsize.getText().toString();
        if(babyHeadSize.isEmpty()){
            etBabyHeadsize.setError("শিশুর হেড সাইজ মিসিং!");
            error = true;
        }

        String babyHeight = etBabyHeight.getText().toString();
        if(babyHeight.isEmpty()){
            etBabyHeight.setError("শিশুর উচ্চতা মিসিং!");
            error = true;
        }
        String babyWeight = etBabyWeight.getText().toString();
        if(babyWeight.isEmpty()){
            etBabyWeight.setError("শিশুর ওজন মিসিং!");
            error = true;
        }

    }
}
