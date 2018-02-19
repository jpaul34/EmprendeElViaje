package com.ev.jonathan.emprendeelvieajeev;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Localizacion2 implements LocationListener {
    Mapa ubicacion;
    LugarTuristico lugar;
    // Ubicacion ubication;
    TextView mensaje1;
    TextView mensaje2;
    String direccion = "";

    public Localizacion2(TextView mensaje1, TextView mensaje2){
        this.mensaje1=mensaje1;
        this.mensaje2=mensaje2;
    }

    public Localizacion2(String Direccion){
        this.direccion=direccion;
    }

    public Mapa getMainActivity() {
        return ubicacion;
    }

    public void setLocalizacion(Mapa ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setLocalizacion(LugarTuristico lugar) {
        this.lugar = lugar;
    }


    //public void setLocalizacion(Ubicacion ubicacion) { this.ubication = ubicacion;    }

    @Override
    public void onLocationChanged(Location loc) {
        // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
        // debido a la deteccion de un cambio de ubicacion
        loc.getLatitude();
        loc.getLongitude();

        String Text = "Mi ubicacion actual es: " + "\n Lat = "+ loc.getLatitude() + "\n Long = " + loc.getLongitude();
        mensaje1.setText(Text);

        //Llmanada al metodo para obtener la direccion
        // this.ubicacion.setLocation(loc);
        // this.lugar.setLocation(loc);
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Este metodo se ejecuta cuando el GPS es desactivado
        mensaje1.setText("GPS Desactivado");
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Este metodo se ejecuta cuando el GPS es activado
        mensaje1.setText("GPS Activado");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d("debug", "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
    }
}