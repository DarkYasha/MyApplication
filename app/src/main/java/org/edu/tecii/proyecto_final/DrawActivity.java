package org.edu.tecii.proyecto_final;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton negro, blanco, azul, rojo, verde;
    public Lienzo lienzo= new Lienzo(getBaseContext());
    float ppequeño, pmediano, pgrande, pdefault;
    ImageButton añadir, trazo, borrar, guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_draw);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        negro = (ImageButton)findViewById(R.id.negro);
        blanco = (ImageButton)findViewById(R.id.blanco);
        azul = (ImageButton)findViewById(R.id.azul);
        rojo = (ImageButton)findViewById(R.id.rojo);
        verde = (ImageButton)findViewById(R.id.verde);
        añadir = (ImageButton)findViewById(R.id.añadir);
        trazo = (ImageButton)findViewById(R.id.trazo);
        borrar = (ImageButton)findViewById(R.id.borrar);
        guardar = (ImageButton)findViewById(R.id.guardar);

        negro.setOnClickListener(this);
        blanco.setOnClickListener(this);
        azul.setOnClickListener(this);
        rojo.setOnClickListener(this);
        verde.setOnClickListener(this);
        añadir.setOnClickListener(this);
        trazo.setOnClickListener(this);
        borrar.setOnClickListener(this);
        guardar.setOnClickListener(this);


        lienzo = (Lienzo) findViewById(R.id.lienzo);

        ppequeño = 10;
        pmediano = 20;
        pgrande = 30;
        pdefault = pmediano;


    }

    @Override
    public void onClick(View v) {
        String color = null;

        switch (v.getId()){
            case R.id.negro:

                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.blanco:

                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.azul:

                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.rojo:

                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.verde:

                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.añadir:

                AlertDialog.Builder newDialog  = new AlertDialog.Builder(this);
                newDialog.setTitle("Nuevo Dibujo");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lienzo.nuevoDibujo();
                        dialog.dismiss();
                    }
                });
                newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                newDialog.show();
                break;
            case R.id.trazo:

                final Dialog tamPunto = new Dialog(this);
                tamPunto.setTitle("Tamaño del punto:");
                tamPunto.setContentView(R.layout.tam_punto);
                TextView smallBtn = (TextView)tamPunto.findViewById(R.id.peque);
                smallBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lienzo.setBorrado(false);
                        lienzo.setTamPunto(ppequeño);
                        tamPunto.dismiss();
                    }
                });
                TextView mediumBtn = (TextView)tamPunto.findViewById(R.id.med);
                mediumBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lienzo.setBorrado(false);
                        lienzo.setTamPunto(pmediano);
                        tamPunto.dismiss();
                    }
                });
                TextView largeBtn = (TextView)tamPunto.findViewById(R.id.grand);
                largeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lienzo.setBorrado(false);
                        lienzo.setTamPunto(pgrande);
                        tamPunto.dismiss();
                    }
                });
                tamPunto.show();
                break;
            case R.id.borrar:

                final Dialog borrarPunto = new Dialog(this);
                borrarPunto.setTitle("Tamaño de borrado:");
                borrarPunto.setContentView(R.layout.tam_punto);
                TextView smallBtnBorrar = (TextView)borrarPunto.findViewById(R.id.peque);
                smallBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lienzo.setBorrado(true);
                        lienzo.setTamPunto(ppequeño);
                        borrarPunto.dismiss();
                    }
                });
                TextView mediumBtnBorrar = (TextView)borrarPunto.findViewById(R.id.med);
                mediumBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lienzo.setBorrado(true);
                        lienzo.setTamPunto(pmediano);
                        borrarPunto.dismiss();
                    }
                });
                TextView largeBtnBorrar = (TextView)borrarPunto.findViewById(R.id.grand);
                largeBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lienzo.setBorrado(true);
                        lienzo.setTamPunto(pgrande);
                        borrarPunto.dismiss();
                    }
                });
                borrarPunto.show();
                break;
            case R.id.guardar:

                AlertDialog.Builder salvarDibujo = new AlertDialog.Builder(this);
                salvarDibujo.setTitle("Salvar Dibujo");
                salvarDibujo.setMessage("¿Desea guardar el dibujo?");
                salvarDibujo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        lienzo.setDrawingCacheEnabled(true);
                        String imgSaved = MediaStore.Images.Media.insertImage(getContentResolver(), lienzo.getDrawingCache(), UUID.randomUUID().toString() + ".png", "drawing");
                        if (imgSaved != null) {
                            Toast savedToast = Toast.makeText(getApplicationContext(), "Dibujo Guardado", Toast.LENGTH_SHORT);
                            savedToast.show();
                        } else{
                            Toast unsavedToast = Toast.makeText(getApplicationContext(), "Error, la imagen no ha podido guardarse", Toast.LENGTH_SHORT);
                            unsavedToast.show();
                        }
                        lienzo.destroyDrawingCache();
                    }
                });
                salvarDibujo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                salvarDibujo.show();
                break;
            default:

                break;
        }
    }
}
