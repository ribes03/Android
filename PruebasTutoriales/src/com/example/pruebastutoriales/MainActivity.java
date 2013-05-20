package com.example.pruebastutoriales;
 
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 
public class MainActivity extends Activity {
 
   Camera camera = null;
   Parameters parameters;
   Button FlashLightControl;
 
   // Called when the activity is first created.
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
 
      //Creamos un boton con el texto adecuado
      FlashLightControl = (Button)findViewById(R.id.flashcontrol);
      FlashLightControl.setText("ENCENDER LED CAMARA");
   }
 
   /**
    * Control LED Camera.
    * Esta funcion se ejecuta al clickar el boton que hemos incluido
    * @param arg0
    */
   public void onClickLED(View arg0) {
      try{
         // Al pulsar, si el Led estaba encendido se apaga y viceversa
         if(camera == null){
            camera = Camera.open();
            parameters = camera.getParameters();
            parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
            camera.setParameters(parameters);
            FlashLightControl.setText("APAGANDO LED CAMARA");
         }else{
            parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
            camera.release();
            camera = null;
            FlashLightControl.setText("ENCENDIENDO LED CAMARA");
         }
      }catch(Exception e){
         //Control errores
      }
   }
 
   /**
    * Si al salir está el LED encendido, lo apagamos.
    * Esta funcion es llamada cuando se cierra una aplicación.
    */
   public void finish(){
      if (camera != null){
         parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
         camera.setParameters(parameters);
         camera.release();
         camera = null;
      }
      super.finish();
   }
}