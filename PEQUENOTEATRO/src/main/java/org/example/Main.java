package org.example;

import java.lang.foreign.PaddingLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerTeclado=new Scanner(System.in);

        //MENÚ DE OPCIONES
        System.out.println("*****************************");
        System.out.println("**********BIENVENIDO*********");
        System.out.println("*******MENÚ DE OPCIONES******");
        System.out.println("1. Agregar Obra");
        System.out.println("2. Buscar todas las Obras");
        System.out.println("3. Buscar obra por nombre");
        System.out.println("4. Modificar obra (tiene un costo adicional)");
        System.out.println("0. Salir del menú");

        //Creamos un Menú de opciones
        int opcionElegida;
        ArrayList<HashMap<String, Object>> obras =new ArrayList<>();

        do {
            HashMap<String,Object> obra =new HashMap<>();
            System.out.print("Digita una opción: ");
            opcionElegida= leerTeclado.nextInt();
            //LIMPIANDO BUFFER
            leerTeclado.nextLine();

            if (opcionElegida==1){
                System.out.println("Agregando una obra");
                System.out.print("Ingresa el nombre de la obra: ");
                String nombreobra=leerTeclado.nextLine();
                System.out.print("Ingresa el director de la obra: ");
                String directorObra= leerTeclado.nextLine();
                System.out.print("Ingresa el genero de la obra: ");
                String generoObra= leerTeclado.nextLine();
                System.out.print("Ingresa el costo de la obra: ");
                String costoObra=leerTeclado.nextLine();

                //Haciendo el LocalDate
                System.out.print("Ingresa el año fin de obra: ");
                int anio= leerTeclado.nextInt();
                System.out.print("Ingresa el mes fin de obra: ");
                int mes= leerTeclado.nextInt();
                System.out.print("Ingresa el dia fin de obra: ");
                int dia= leerTeclado.nextInt();
                LocalDate fechaFinObra= LocalDate.of(anio,mes,dia);

                //Cuadrando el id aleatorio para las obras
                Random aleatorio=new Random();
                int idObra=aleatorio.nextInt(100);

                //LLENANDO EL OBJETO
                obra.put("nombre", nombreobra);
                obra.put("director", directorObra);
                obra.put("genero", generoObra);
                obra.put("costo", costoObra);
                obra.put("fecha", fechaFinObra);
                obra.put("id", idObra);

                //LLENANDO EL ARREGLO
                obras.add(obra);


            } else if (opcionElegida==2) {
                System.out.println("Mostrando todas las obras");
                for(HashMap<String, Object> obraAuxiliar: obras){
                    System.out.println(obraAuxiliar);
                }
            } else if (opcionElegida==3) {
                System.out.println("Buscando por nombre de obra");
                //Para buscar en un arreglo necesito el indice que estoy buscando
                System.out.print("Digita el nombre de la obra que quieres buscar: ");
                String nombreObraABucar=leerTeclado.nextLine();

                //Recorriendo el arreglo para buscar
                for (HashMap<String,Object>obraAuxiliar: obras){
                    System.out.println(obraAuxiliar.get("nombre"));
                    //Comparar si el nombre que encontro el auxiliar es el que digito el usuario
                    if (nombreObraABucar.equals(obraAuxiliar.get("nombre"))){
                        System.out.println("obra encontrada");
                        //Mostrar la informacion del producto que se encontro
                        System.out.println(obraAuxiliar);
                        //como encontrar el indice del producto auxiliar
                        //si es necesario encontrar el indice
                    }
                }

            } else if (opcionElegida==4) {
                System.out.println("Modificando producto");
                System.out.print("Ingresa el nombre de la obra para modificar el costo: ");
                String obraAmodificar=leerTeclado.nextLine();
                for (HashMap<String, Object> obraAuxiliar2:obras){
                    if (obraAmodificar.equals(obraAuxiliar2.get("nombre"))){
                        System.out.print("Ingrese el nuevo costo de la obra: ");
                        int nuevoCosto =leerTeclado.nextInt();
                        obraAuxiliar2.put("costo", nuevoCosto);
                    }
                }
            } else if (opcionElegida==0) {
                System.out.println("Saliendo");
            }else {
                System.out.println("Opción invalida");
            }

        }while (opcionElegida!=0);



    }
}