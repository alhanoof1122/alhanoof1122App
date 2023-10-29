package com.example.starbucks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private long startTime;
    private long endTime;
    private boolean isLongClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button callButton = findViewById(R.id.callButton);
        Button worksHoursButton = findViewById(R.id.worksHoursButton);
        Button aboutButton = findViewById(R.id.aboutButton);


        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:920002482"));
                startActivity(callIntent);
            }
        });



        worksHoursButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startTime = System.currentTimeMillis();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    endTime = System.currentTimeMillis();
                    if (endTime - startTime < 1000) {

                        Toast.makeText(MainActivity.this, "اضغط طويلا لعرض ساعات العمل في المتجر", Toast.LENGTH_SHORT).show();
                        isLongClick = false;
                    }
                }
                return false;
            }
        });


        worksHoursButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!isLongClick) {

                    Toast.makeText(MainActivity.this, "أوقات العمل:مفتوح 24 ساعة !ءً", Toast.LENGTH_SHORT).show();
                    isLongClick = true;
                }
                return true;
            }
        });


        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aboutIntent = new Intent(MainActivity.this, Aboutbuton.class);
                startActivity(aboutIntent);
            }
        });
    }
}