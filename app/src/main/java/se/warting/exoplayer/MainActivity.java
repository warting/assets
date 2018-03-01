package se.warting.exoplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_exo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExoActivity.show(v.getContext());
            }
        });

        findViewById(R.id.button_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImgActivity.show(v.getContext());
            }
        });
    }
}
