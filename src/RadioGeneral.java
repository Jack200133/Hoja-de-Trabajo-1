public interface RadioGeneral {

    /** Comprueba el estado de la radio */
    boolean isON();
    /** Prende la radio*/
    void encender();
    /** Apaga la radio*/
    void apagar();
    /** Incrementa el dial de la radio dependiendo de si es FM o AM*/
    void incrementar();
    /** Asigna a un boton la frecuencia actual y contiene de parametro el boton*/
    boolean asignar(int a);
    /** Presiona un boton y asigana la frecuencia y contiene de parametro el boton*/
    boolean emisora(int a);
    /** Cambia la frecuencia de FM a AM o viceversa */
    void frecuencia();
}
