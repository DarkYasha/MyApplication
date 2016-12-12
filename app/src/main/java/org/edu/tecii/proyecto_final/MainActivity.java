package org.edu.tecii.proyecto_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNew = (Button) findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent btn = new Intent(v.getContext(), DrawActivity.class);
                startActivityForResult(btn, 0);
            }

        });
        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent btn = new Intent(v.getContext(), LoadActivity2.class);
                startActivityForResult(btn, 0);
            }
        });

        Button btnShare = (Button) findViewById(R.id.btnShare);
        btnNew.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent btn = new Intent(v.getContext(), ShareActivity.class);
                startActivityForResult(btn, 0);
            }

        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.itayuda:
                Toast.makeText(getApplicationContext(),"Ayuda",Toast.LENGTH_LONG).show();
                return true;
            case R.id.itacerca:
                Toast.makeText(getApplicationContext(),"Acerca",Toast.LENGTH_LONG).show();
                return true;
        }


        return false;
    }
}