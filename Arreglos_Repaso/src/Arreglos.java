//Libreria de captura de información

import javax.swing.*;

public class Arreglos {
    public static void main(String[] args) {
        //Variable del control del menú
        String opcion = "";
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
            opcion = JOptionPane.showInputDialog(null, "" +
                    "A. Ver capacidad Arreglo\n" +
                    "B. Cargar Datos\n" +
                    "C. Mostrar Datos\n" +
                    "D. Salir\n", "Arreglos" +
                    "", JOptionPane.WARNING_MESSAGE);

            switch (opcion.charAt(0)) {
                case 'a':
                case 'A':
                    //variables locales
                    JOptionPane.showMessageDialog(null, "La capacidad del arreglo es: " +
                            "" + arregloNom.length);
                    break;
                case 'b':
                case 'B':
                    //Cargar los datos del arreglo
                    for (int i = 0; i < arregloNom.length; i++) {
                        arregloNom[i] = JOptionPane.showInputDialog(null, "" +
                                "Digite el nombre en la posición " + i);
                    }
                    break;
                case 'c':
                case 'C':
                    String msj = "";
                    //Mostrar los datos del arreglo
                    for (int i = 0; i < arregloNom.length; i++) {
                        msj+= "Este es el dato en la posición " + i + ": " + arregloNom[i] + "\n";
                    }
                    JOptionPane.showMessageDialog(null, msj);

                    break;
                case 'd':
                case 'D':
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Opción incorrecta");
                    break;
            }
        } while (!opcion.equalsIgnoreCase("D"));
    }
}
