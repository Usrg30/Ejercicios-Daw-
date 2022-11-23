import java.util.Scanner;



public class Hernandez_Martin_Alejandro_ProgramacionUD2_Caso1 {
    // Definimos el objeto scanner y los colores para la salida de la consola
    static Scanner sc = new Scanner(System.in);
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_DEFAULT = "\u001B[0m";

    public static void main(String[] args) {
        int importe_del_prestamo = 0;
        float deuda = 0;
        float aportacion = 0;

        System.out.println("Indique la cantidad que quiere recibir como prestamo\nRecuerde que el banco solo presta cantidades enteras:\nSi quiere salir del programa escriba \'quit\'.");
        // Validamos la entrada solo para números enteros, con opciones de salida del programa.
        do {
            if (!sc.hasNext("quit")){
                if (sc.hasNextInt()){
                    importe_del_prestamo = sc.nextInt();
                    break;
                } else {
                    sc.next();
                    System.out.println("Debe ser un numero entero por favor:\n(El banco solo presta cantidades enteras)");
                }
            } else {
                System.out.println("El programa finaliza con exito.");
                System.exit(0);
            }
        } while (!sc.hasNext("quit"));
        // Declaramos la dauda contraida con el banco.
        deuda = importe_del_prestamo;
        // Le indicamos al usuario el prestamo concedido
        System.out.printf("Perfecto, concedido prestamo de" + ANSI_GREEN + " %.2f€\n" + ANSI_DEFAULT, importe_del_prestamo);
        // hasta que el usuario salga o la deuda termine, solicitara datos, con validacion de entrada, esta vez a enteros y decimales en fomato float
        while(deuda>0){

            System.out.println("¿Desea hacer alguna aportación? (\'quit\' para salir)");

            do {
                if (!sc.hasNext("quit")){
                    if (sc.hasNextInt()){
                        aportacion = sc.nextInt();
                        break;
                    } else if (sc.hasNextFloat()){
                        aportacion = sc.nextFloat();
                        break;
                    } else {
                        sc.next();
                        System.out.println("Indique solo números, decimales o enteros...\nLos decimales se escriben con comas, no con puntos, reviselo por favor.\nSi quiere salir indique \'quit\'");
                    }
                } else {
                    System.out.printf("Tienes aun pendiente %.2f€\n",deuda);
                    System.out.println("El programa finaliza con exito.");
                    System.exit(0);
                }
            } while (!sc.hasNext("quit"));
            // imprimimos la aportacion en verde por consola con los parametros ansi declarados antes de main y devolvemos el color por defecto tras el dato
            System.out.printf("Aportación: " + ANSI_GREEN + " %.2f€\n" + ANSI_DEFAULT, aportacion);
            System.out.printf("Deuda: %.2f€\n", deuda-aportacion);
            deuda = deuda-aportacion;
        };
        // al finalizar la deuda, indicamos si ha sido exacto el pago o tiene excedentes para que los retire
        if(deuda<0){
            System.out.printf("Te ha sobrado %.2f\n", deuda);
            System.out.println("No olvides retirarlos!");
        } else {
        System.out.println("Has saldado tu deuda");
        }
        System.out.println("Programa finalizado.");
    }
    // Al utilizar los bucles y condicionales permite buscar los caminos necesarios a realizar y en caso necesario repetirlos las veces necesarias.
}
