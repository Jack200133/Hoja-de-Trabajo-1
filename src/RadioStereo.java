/***************************************************************
 * RadioStereo.java
 * Autor: Juan Angel Carrera y Jessica Ortiz
 * Universidad del Valle de Guatemala
 *
 * Radio que implementa los metodos de la interfaz para que asi todas
 * las radios funcionen bajo un mismo main
 ***************************************************************/

import java.util.Arrays;


public class RadioStereo implements RadioGeneral {

    //Atributos de la clase
    private boolean status;
    private double BtFM[];
    private double BtAM[];
    private boolean FM;
    private double posicion;

    //constructor de la clase
    public RadioStereo() {
        status = false;
        BtAM = new double[12];
        BtFM = new double[12];
        FM = true;
        posicion = 87.9;
        Arrays.fill(BtAM, 530);
        Arrays.fill(BtFM, 87.9);
    }

    @Override // comprueba el estado de la radio
    public boolean isON() {
        return status;
    }

    @Override // prende la radio
    public void encender() {
       status = true;
       System.out.println("Se prendio la radio");
    }

    @Override // apaga la radio
    public void apagar() {
        status = false;
        System.out.println("Se apago la radio");
    }

    @Override // a la frecuencia actual se le suma segun si es AM o FM
    public void incrementar() {
        if (FM){
            if (posicion >= 107.9){
                posicion = 87.9;
            }else{
                posicion += 0.2;
            }
        }else {
            if( posicion >= 1610){
                posicion = 530;
            }else {
                posicion += 10;
            }
        }
        if(FM){
            System.out.println("La nueva posicion de la radio es FM:" + posicion);
        }else {
            System.out.println("La nueva posicion de la radio es AM:" + posicion);
        }
    }


    @Override //se asiga una frecuencia a un boton
    public boolean asignar(int a) {
        if (status) {

            if (FM) {
                BtFM[a - 1] = posicion;
                System.out.println("La frecuencia FM: " + posicion + " se guardo en el boton " + a);
            } else {
                BtAM[a - 1] = posicion;
                System.out.println("La frecuencia AM: " + posicion + " se guardo en el boton " + a);
            }
            return true;
        }
        return false;
    }

    @Override // las frecuencias guardadas son seleccionadas
    public boolean emisora(int a) {


        if(status){
            if(FM){
                posicion = BtFM[a-1];
            }else {
                posicion = BtAM[a-1];
            }
            System.out.println("La frecuencia AM: " + posicion + " se guardo en el boton " + a);
            return true;
        }
           return false;
    }

    @Override /** cambiar de am a fm y vice versa*/
    public void frecuencia() {
        FM = !FM;
        if(FM){
            posicion = 89.7;
            System.out.println("La radio ahora es FM");
        }else {
            posicion = 530;
            System.out.println("La radio ahora es AM");
        }

    }
}
