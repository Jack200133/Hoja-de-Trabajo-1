import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @org.junit.jupiter.api.Test
    void isON() {
    }

    @org.junit.jupiter.api.Test
    void asignar() {
    }

    @org.junit.jupiter.api.Test
    void emisora() {
    }

    public void s(){
        Radio radio = new Radio();
        assertFalse(radio.isON());
        radio.encender();

        assertTrue(radio.asignar(3));
    }


}