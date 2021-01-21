import static org.junit.jupiter.api.Assertions.*;

class RadioStereoTest {


    @org.junit.jupiter.api.Test
    void isON() {
        RadioStereo radio = new RadioStereo();
        boolean result = radio.isON();
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void asignar() {
        RadioStereo radio = new RadioStereo();
        radio.encender();
        boolean tip = radio.asignar(2);

        assertTrue(tip);
    }

    @org.junit.jupiter.api.Test
    void emisora() {
        RadioStereo radio = new RadioStereo();
        radio.encender();
        boolean tip = radio.emisora(2);
        assertTrue(tip);
    }



}