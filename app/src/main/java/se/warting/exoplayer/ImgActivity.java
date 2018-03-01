package se.warting.exoplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ImgActivity extends AppCompatActivity {


    public static void show(Context context) {
        Intent intent = new Intent(context, ImgActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView imageView = findViewById(R.id.image_view);
        // load image
        try {
            // get input stream
            InputStream ims = getAssets().open("img.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView

            imageView.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }

}
