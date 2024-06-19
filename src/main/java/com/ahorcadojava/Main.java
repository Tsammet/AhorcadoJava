package com.ahorcadojava;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String instrumentoSecreto = getInstrumentoSecreto();
        char [] palabraGuiones = getPalabrasGuiones(instrumentoSecreto);
        

        // DETERMINO EL JUEGOTERMINADO COMO FALSE
        boolean juegoTerminado = false;

        // CREO EL LECTOR DE TECLADO
        Scanner sc = new Scanner(System.in);

        // CREO EL CONTADOR DE VIDAS
        int contadorVidas = 5;

        // HAGO UN BUCLE DO WHILE PARA EL JUEGO
        do{
            System.out.println(palabraGuiones);
            System.out.println("Ingrese una letra para su juego: ");

            // LEO LO QUE EL CARACTER QUE EL USUARIO VA A INGRESAR 
            char letra = sc.nextLine().charAt(0);
            
            // GENERO ESTE BOOLEANO PARA DAR MENSAJE SI NO ACERTÓ LA LETRA INGRESADA
            boolean algunaLetraAcertada = false;
            
            // ITERO SOBRE LA PALABRA SECRETA 
            for(int i = 0; i < instrumentoSecreto.length(); i++){

                // SI LA PALABRA SECRETA EN LA POSICIÓN DE I ES IGUAL A LA LETRA QUE EL USUARIO INGRESÓ ENTRA EN EL IF
                if(instrumentoSecreto.toLowerCase().charAt(i) == letra){

                    // CAMBIO EL GUIÓN EN LA POSICIÓN QUE LO ENCUENTRE POR LA LETRA INGRESADA 
                    palabraGuiones[i] = letra;

                    // CAMBIO LA LETRA ACERTADA PARA QUE NO ME MUESTRE EL MENSAJE QUE NO HABER ACERTADO NINGUNA LETRA 
                    algunaLetraAcertada = true;
                }

            }

            if (!algunaLetraAcertada) {

                System.out.println(MessageFormat.format("no has acertado, te quedan {0} vidas", contadorVidas));
                // SI NO SE ACIERTA EL CARACTER INGRESADO POR EL USUARIO CON LA PALABRA SECRETA, SE PERDERÀ UNA VIDA

                contadorVidas --;
                // SI EL CONTADOR DE VIDAS LLEGA A 0, EL JUEGO TERMINADO PASARÀ A TRUE Y SE ACABARÀ EL JUEGO 

                if (contadorVidas <= 0){
                    juegoTerminado = true;
                    System.out.println("Tús vidas han llegado a 0, haz perdido el juego </3");
                }
            }else{
                boolean juegoGanado = !hayGuiones(palabraGuiones);
                if (juegoGanado) {
                    System.out.println(MessageFormat.format("Haz ganado el juego <3 la palabra era {0}", instrumentoSecreto));
                    juegoTerminado = true;
                }
            }
        // TODO ESTO MIENTRAS EL JUEGO CAMBIE DE FALSO A VERDADERO  
        }while(!juegoTerminado);

        sc.close();

    }


    // METODO PARA ELEGIR UN INSTRUMENTO DE UN ARRAYLIST 
    static String getInstrumentoSecreto(){
        // CREACIÓN DEL ARRAYLIST
        ArrayList <String> instrumentosMusicales = new ArrayList<>();

        // AGREGO INSTRUMENTOS A MI ARRAYLIST 
        instrumentosMusicales.add("Piano");
        instrumentosMusicales.add("Guitarra");
        instrumentosMusicales.add("Violin");
        instrumentosMusicales.add("Viola");
        instrumentosMusicales.add("Violoncello");
        instrumentosMusicales.add("Contrabajo");
        instrumentosMusicales.add("Trompeta");
        instrumentosMusicales.add("Trombon");
        instrumentosMusicales.add("Tuba");
        instrumentosMusicales.add("Oboe");

        // CREO EL OBJETO RANDOM
        Random r = new Random();

        // GENERO UN NÚMERO ALEATORIO DENTRO DEL TAMAÑO DEL ARRAY CREADO 
        int numAleatorio = r.nextInt(instrumentosMusicales.size());

        // SELECCIONA EL NÚMERO ALEATORIO QUE TOMO 
        return instrumentosMusicales.get(numAleatorio);
    }


    // METODO PARA TRANSFORMAR LA PALABRA ELEGIDA DEL METODO DEL INSTRUMENTO SECRETO EN GUIONESBAJOS
    static char[] getPalabrasGuiones(String instrumentoSecreto){

        // AQUÍ CUENTO CADA LETRA DEL INSTRUMENTO GENERADO ALEATORIAMENTE 
        int letrasInstrumentoSecreto = instrumentoSecreto.length();

        System.out.println(letrasInstrumentoSecreto);

        // CREO UN ARRAY DE TIPO CHAR DEL TAMAÑO DE MI INSTRUMENTO SECRETO 
        char [] palabraGuiones = new char[letrasInstrumentoSecreto];

        // LO QUE HAGO EN ESTE FOR ES QUE POR CADA ITERACIÓN DEL ARRAY CREO UN GUIÓN BAJO
        for (int i = 0; i < palabraGuiones.length; i++) {
            palabraGuiones[i] = '_';
        }

        return palabraGuiones;
    }

    // CREO OTRO METODO PARA SABER SI AÚN HAY GUIONESBAJOS O NO
    static boolean hayGuiones(char[] arrayL){
        for (char l : arrayL) {
            if (l == '_')return true;
        }
        return false;

    }
}