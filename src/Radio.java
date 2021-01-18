

public class Radio implements RadioGeneral {

    private boolean status;
    private double BtFM[];
    private double BtAM[];
    private boolean FM;
    private double posicion;

    public Radio() {
        status = false;
        BtAM = new double[12];
        BtFM = new double[12];
        FM = true;
        posicion = 87.9;

    }

    @Override
    public boolean isON() {
        return status;
    }

    @Override
    public void encender() {
       status = true;
       System.out.println("Se prendio la radio");
    }

    @Override //
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
        System.out.println("La nueva posicion de la radio es + " + posicion);
    }

    @Override// a la frecuancia actual se la baja segun si es AM o FM
    public void disminuir() {
        if (FM){
            if (posicion <= 87.9){
                posicion = 107.9;
            }else{
                posicion -= 0.2;
            }
        }else {
            if( posicion <= 530){
                posicion = 1610;
            }else {
                posicion -= 10;
            }

        }
        System.out.println("La nueva posicion de la radio es + " + posicion);

    }

    @Override //se asiga una frecuencia a un boton
    public void asignar(int a) {
        if(FM){
            BtFM[a] = posicion;
        }else {
            BtAM[a] = posicion;
        }
    }

    @Override // las frecuencias guardadas son seleccionadas
    public void emisora(int a) {
        if(FM){
            posicion = BtFM[a];
        }else {
            posicion = BtAM[a];
        }
    }

    @Override //cambiar de am a fm y vice versa
    public void frecuencia() {
        FM = !FM;
    }
}
