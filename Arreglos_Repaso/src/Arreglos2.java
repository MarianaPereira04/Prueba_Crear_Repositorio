//Libreria de captura de información

import javax.swing.*;

public class Arreglos2 {
    public static void main(String[] args) {
        //Variable del control del menú
        int opcion = 0;
        //Variables globales

        //Variable para controlar el tamaño del arreglo
        int tamArreglo = 0;

        //Pedirle al usuario que digite la cantidad de datos a guardar - tamaño arreglo
        tamArreglo = Integer.parseInt(JOptionPane.showInputDialog(null, "" +
                "Digite la cantidad de datos a guardar"));

        //Arreglo para guardar Strings-texto
        String[] arregloNom = new String[tamArreglo];

        //Menú interactivo
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "" +
                    "1. Ver capacidad Arreglo\n" +
                    "2. Cargar Datos\n" +
                    "3. Mostrar Datos\n" +
                    "4. Salir\n", "Arreglos" +
                    "", JOptionPane.WARNING_MESSAGE));

            switch (opcion) {
                case 1:
                    //variables locales
                    JOptionPane.showMessageDialog(null, "La capacidad del arreglo es: " +
                            "" + arregloNom.length);
                    break;
                case 2:
                    //Cargar los datos del arreglo
                    for (int i = 0; i < arregloNom.length; i++) {
                        arregloNom[i] = JOptionPane.showInputDialog(null, "" +
                                "Digite el nombre en la posición " + i);
                    }
                    break;
                case 3:
                    String msj = "";
                    //Mostrar los datos del arreglo
                    for (int i = 0; i < arregloNom.length; i++) {
                        msj+= "Este es el dato en la posición " + i + ": " + arregloNom[i] + "\n";
                    }
                    JOptionPane.showMessageDialog(null, msj);

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Opción incorrecta");
                    break;
            }
        } while (opcion!=4);
    }
}

