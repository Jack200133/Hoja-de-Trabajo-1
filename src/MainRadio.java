
/***************************************************************
 * MainRadio.java
 * Autor: Juan Angel Carrera y Jessica Ortiz
 * Universidad del Valle de Guatemala
 *
 * Main class que sirve para mostrar el menu al usuario y luego llamar a las funciones de
 * la radio y esta implementa una interfaz de radio general.
 ***************************************************************/
import java.util.Scanner;

public class MainRadio {

    public static void main(String[] args){
        int op = 0;
        RadioStereo rd = new RadioStereo();
        Scanner scan = new Scanner(System.in);
        boolean bandera = true;
        //Ciclo while que le mostara el estado de la radio y el menu al usuario

        while (bandera){
            if(rd.isON()){
                System.out.println("\nRadio Encendida");
            }else {
                System.out.println("\nRadio Apagada");
            }
            System.out.println("--------------------\n");

            System.out.println("1. Encender Radio");
            System.out.println("2. Cambiar de FM a AM/ AM a FM");
            System.out.println("3. Avanzar en el dial de la radio");
            System.out.println("4. Guardar emisora");
            System.out.println("5. Seleccionar una emisora");
            System.out.println("6. Apagar radio");
            System.out.println("7. Salir");
            //try-catch que busca que el usuario ingrese un numero del 1 al 7
            try {
                op = scan.nextInt();
                if (op >=1 && op <=7){
                    switch (op) {
                        case 1 -> {
                            //enciende la radio
                            rd.encender();
                        }
                        case 2 -> {
                            //se asegura que la radio este encendida y cambia la frecuancia
                            if (rd.isON()) {
                                rd.frecuencia();
                            } else {
                                System.out.println("La radio esta apagada, porfavor prendala");
                            }
                        }
                        case 3 -> {
                            //se asegura que la radio este encendida y avanza el dial
                            if (rd.isON()) {
                                rd.incrementar();
                            } else {
                                System.out.println("La radio esta apagada, porfavor prendala");
                            }

                        }
                        case 4 -> {
                            //se asegura que la radio este encendida y se guarda la emisora
                            if (rd.isON()) {
                                while (true){
                                    try {
                                        System.out.println("Ingrese que en que boton se asignara de 1 a 12");
                                        int a = scan.nextInt();
                                        if(a >= 1 && a <=12){
                                            rd.asignar(a);
                                            break;
                                        }else {
                                            System.out.println("Ingrese un numero del 1 al 12");
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Ingrese un dato numerico");
                                    }
                                }

                            } else {
                                System.out.println("La radio esta apagada, porfavor prendala");
                            }
                        }
                        case 5 -> {
                            //se asegura que la radio este encendida y apacha un boton

                            if (rd.isON()) {
                                while (true){
                                    try {
                                        System.out.println("Ingrese que boton quiere apachar de 1 a 12");
                                        int a = scan.nextInt();
                                        if(a >= 1 && a <=12){
                                            rd.emisora(a);
                                            break;
                                        }else {
                                            System.out.println("Ingrese un numero del 1 al 12");
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Ingrese un dato numerico");
                                    }
                                }
                            } else {
                                System.out.println("La radio esta apagada, porfavor prendala");
                            }

                        }
                        case 6 -> {
                            // apaga la radio
                            rd.apagar();
                        }
                        case 7 -> {
                            //cierra el programa
                            bandera = false;
                        }
                    }
                }else {
                    System.out .println("Ingrese un numero del 1 al 7");

                }
            }catch (Exception e){
                System.out .println("Ingrese solo datos numericos");
            }
        }
    }
}
