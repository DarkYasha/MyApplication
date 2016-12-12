package org.edu.tecii.proyecto_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class ShareActivity extends AppCompatActivity {
    Button compartir, facebook, twitter, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        compartir = (Button)findViewById(R.id.btnCompartir);
        facebook = (Button)findViewById(R.id.btnFacebook);
        twitter = (Button)findViewById(R.id.btnTwitter);
        instagram = (Button)findViewById(R.id.btnInstagram);

        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Prueba compartir/");
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Prueba compartir/");
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Prueba compartir/");
                intent.setPackage("com.twitter.android");
                startActivity(intent);
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Prueba compartir/");
                intent.setPackage("com.instagram");
                startActivity(intent);
            }
        });
    }
}
