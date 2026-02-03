package io.mastercoding.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, yellowBtn, redBtn, greenBtn, purpleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.blackButton);
        redBtn = findViewById(R.id.redButton);
        greenBtn = findViewById(R.id.greenButton);
        purpleBtn = findViewById(R.id.purpleButton);
        yellowBtn = findViewById(R.id.yellowButton);

        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.redButton) {
            playSound(R.raw.red);
        } else if (clickedBtnId == R.id.blackButton) {
            playSound(R.raw.black);
        } else if (clickedBtnId == R.id.greenButton) {
            playSound(R.raw.green);
        } else if (clickedBtnId == R.id.purpleButton) {
            playSound(R.raw.purple);
        } else if (clickedBtnId == R.id.yellowButton) {
            playSound(R.raw.yellow);
        }
    }

    public void playSound(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(this,id);
        mediaPlayer.start();
    }
}