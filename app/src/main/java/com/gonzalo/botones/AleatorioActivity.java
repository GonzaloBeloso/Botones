package com.gonzalo.botones;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class AleatorioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    RadioGroup grupoRadios;
    RadioButton sinRango,conRango;
    EditText numeroMinimo,numeroMaximo,numeroDecimales,numerosTotales;
    CheckBox permitirDecimales;
    Switch repetirNumeros;
    ImageButton btnCohete;
    ArrayList numerosUsados;
    TextView etiqueta;
    int max,min;
    double generado;
    boolean rango;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instancias();
        acciones();
    }

    private void acciones() {
        grupoRadios.setOnCheckedChangeListener(this);
        sinRango.setOnCheckedChangeListener(this);
        conRango.setOnCheckedChangeListener(this);
        btnCohete.setOnClickListener(this);
        repetirNumeros.setOnCheckedChangeListener(this);
        permitirDecimales.setOnCheckedChangeListener(this);
    }

    private void instancias() {
        grupoRadios=findViewById(R.id.grupoRadios);
        sinRango=findViewById(R.id.SinRango);
        conRango=findViewById(R.id.ConRango);
        numeroMinimo=findViewById(R.id.minimo);
        numeroMinimo.setEnabled(false);
        numeroMaximo=findViewById(R.id.maximo);
        numeroMaximo.setEnabled(false);
        numeroDecimales=findViewById(R.id.PermitirDecimales);
        numeroDecimales.setEnabled(false);
        numerosTotales=findViewById(R.id.totales);
        permitirDecimales=findViewById(R.id.cPermitir);
        repetirNumeros=findViewById(R.id.repetir);
        btnCohete=findViewById(R.id.cohete);
        etiqueta=findViewById(R.id.resultado);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getCheckedRadioButtonId()){
            case R.id.SinRango:
                rango=false;
                numeroMinimo.setEnabled(false);
                numeroMaximo.setEnabled(false);
                break;
            case R.id.ConRango:
                rango=true;
                numeroMinimo.setEnabled(true);
                numeroMaximo.setEnabled(true);
                break;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.PermitirDecimales:
                if(permitirDecimales.isChecked())
                    numeroDecimales.setEnabled(true);
                else
                    numeroDecimales.setEnabled(false);
                break;
            case R.id.repetir:

                break;
        }

    }
    public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cohete:
                etiqueta.setText("");
                if(rango){
                    max=Integer.valueOf(numeroMaximo.getText().toString());
                    min=Integer.valueOf(numeroMinimo.getText().toString());
                    if(permitirDecimales.isChecked()){
                        for (int i=0;i< Integer.valueOf(numerosTotales.getText().toString());i++) {
                            generado = formatearDecimales((Math.random() * (max - min) + min), Integer.valueOf(numeroDecimales.getText().toString()));
                            etiqueta.setText(etiqueta.getText()+"\n"+(generado));
                        }
                    }else{
                        for (int i=0;i< Integer.valueOf(numerosTotales.getText().toString());i++) {
                            generado = formatearDecimales((Math.random() * (max - min) + min), 0);
                            etiqueta.setText(etiqueta.getText()+"\n"+(generado));
                        }
                    }
                }else{
                    if(permitirDecimales.isChecked()){
                        for (int i=0;i< Integer.valueOf(numerosTotales.getText().toString());i++) {
                            generado = formatearDecimales((Math.random() * 1000), Integer.valueOf(numeroDecimales.getText().toString()));
                            etiqueta.setText(etiqueta.getText()+"\n"+(generado));
                        }
                    }else{
                        for (int i=0;i< Integer.valueOf(numerosTotales.getText().toString());i++) {
                            generado = formatearDecimales((Math.random() * 1000), 0);
                            etiqueta.setText(etiqueta.getText()+"\n"+(generado));
                        }
                    }
                }
                break;
        }
    }
}