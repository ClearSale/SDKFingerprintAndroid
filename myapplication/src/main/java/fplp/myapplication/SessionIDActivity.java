package fplp.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

import sale.clear.behavior.android.Behavior;
import sale.clear.behavior.android.exceptions.CaptureWasStartedException;
import sale.clear.behavior.android.exceptions.SessionIDAlreadyUsedException;


public class SessionIDActivity extends AppCompatActivity {

    private Behavior mBehavior;
    private static final String TAG = "GenerateSessionID";

    private TextView textViewPeopleLocation;
    private TextView textViewYearOfBirth;
    private TextView textViewPersonAge;
    private int personAge;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        mBehavior = Behavior.getInstance(this,
                "CLEAR_SALE_APP");

        try {
            mBehavior.start();
        } catch (CaptureWasStartedException e) {
            setErrorMessage(e.getMessage());
            e.printStackTrace();
        }

        Button mButtonAdd = findViewById(R.id.button_sendAge);

        textViewPeopleLocation = findViewById(R.id.text_peopleLocation);
        textViewYearOfBirth = findViewById(R.id.text_yearOfBirth);
        textViewPersonAge = findViewById(R.id.text_personAge);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        mButtonAdd.setOnClickListener(view -> {
            final String invalidYearMessage = "É necessário informar um ano de nascimento válido.";
            try {
                int inputYear = Integer.parseInt(textViewYearOfBirth.getText().toString());

                if (textViewYearOfBirth.getText().length() == 4 && inputYear < year) {

                    personAge = year - inputYear;

                    String sessionID = "FPLP_LOCATION" + UUID.randomUUID().toString().replace("-", "").substring(0, 5);
                    generateSessionID(sessionID);
                } else {
                    textViewPeopleLocation.setText(invalidYearMessage);
                    textViewPersonAge.setText("");
                }

            } catch (Exception ignored) {
                textViewPeopleLocation.setText(invalidYearMessage);
                textViewPersonAge.setText("");
                personAge = 0;
            }
        });
    }
    private void generateSessionID(String sessionID) {
        try {
            textViewPeopleLocation.setText("");
            Log.d(TAG, "onClick: " + sessionID);
            mBehavior.collectDeviceInformation(sessionID);
            setSuccessMessage(sessionID);
        } catch (SessionIDAlreadyUsedException e) {
            setErrorMessage(e.getMessage());
            e.printStackTrace();
        } finally {
            onPause();
        }
    }

    private void setErrorMessage(String message) {
        textViewPeopleLocation.setText(message);
        textViewPeopleLocation.setTextColor(Color.RED);
    }

    private void setSuccessMessage(String sessionID) {
        int random = 0;
        if (personAge > 0 && personAge < 100) {
            random = new Random().nextInt(200);
        }
        textViewPersonAge.setText("Você possui " + personAge + " anos de idade.");

        String SUCCESS_MESSAGE = random + " pessoas próximas a você\ncom a mesma idade. \nO seu Código de localização é: " + sessionID;

        textViewPeopleLocation.setText(SUCCESS_MESSAGE);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBehavior.stop();
    }
}

