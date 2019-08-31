package nsu.sharif.mypremie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

public class startingSpalshActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress;

    //Removed Title Bar By Using requestWindowFeature.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_starting_spalsh);

        progressBar = (ProgressBar) findViewById(R.id.progressBarId);

        //Creating a new Thread for the task.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });

        thread.start();
    }

    //Seting Time for the splashActivity.

    public void doWork(){
        for(progress = 25 ; progress<=100; progress= progress+25)
        {
            try{
                Thread.sleep(500);
                progressBar.setProgress(progress);
            }catch (InterruptedException e)
            {
             e.printStackTrace();
            }
        }
    }

    //For Starting the app after the splashScreen

    public void startApp(){
        Intent intent = new Intent(startingSpalshActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
