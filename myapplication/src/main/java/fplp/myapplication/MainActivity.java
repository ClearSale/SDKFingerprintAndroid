package fplp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            List<String> permissions = new ArrayList<>();
            if (Build.VERSION.SDK_INT >= 23) {

                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

                String[] permissionsArray = new String[permissions.size()];

                permissions.toArray(permissionsArray);
                requestPermissions(permissionsArray, 170);
            }

        } catch (Exception ignored) {
        }

        setContentView(R.layout.activity_main);

        Button buttonTerms = findViewById(R.id.button_terms);

        buttonTerms.setOnClickListener(view -> {
            Intent intent = new Intent(this, SessionIDActivity.class);
            startActivity(intent);
        });
    }
}