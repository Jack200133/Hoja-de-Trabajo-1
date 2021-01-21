import java.util.Scanner;

public class MainRadio {

    public static void main(String[] args){
        int op = 0;
        Radio rd = new Radio();
        Scanner scan = new Scanner(System.in);
        boolean bandera = true;

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

            try {
                op = scan.nextInt();
                if (op >=1 && op <=7){
                    switch (op) {
                        case 1 -> {
                            rd.encender();
                        }
                        case 2 -> {
                            if (rd.isON()) {
                                rd.frecuencia();
                            } else {
                                System.out.println("La radio esta apagada, porfavor prendala");
                            }
                        }
                        case 3 -> {
                            if (rd.isON()) {
                                rd.incrementar();
                            } else {
                                System.out.println("La radio esta apagada, porfavor prendala");
                            }

                        }
                        case 4 -> {
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
                            rd.apagar();
                        }
                        case 7 -> {
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
