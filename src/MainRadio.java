import java.util.Scanner;

public class MainRadio {

    public static void main(String[] args){
        int op = 0;
        Radio rd = new Radio();
        Scanner scan = new Scanner(System.in);
        boolean bandera = true;

        while (bandera){
            if(rd.isON()){
                System.out.println("Radio Encendida");
            }else {
                System.out.println("Radio Apagada");
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
                    switch (op){
                        case 1:{
                            rd.encender();
                        }
                        case 2:{

                        }
                        case 3:{

                        }
                        case 7:{
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
