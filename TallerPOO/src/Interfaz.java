import javax.swing.*;

public class Interfaz {
    public static void main(String[] args) {
        //Objeto
        Clase_Parqueadero parqueadero = new Clase_Parqueadero();

        //Variables
        String op = "";

        do {
            op = JOptionPane.showInputDialog(null, "A. Registrar Vehículo\n" +
                    "B. Retirar Vehículo\n" +
                    "C. Consultar capacidad disponible\n" +
                    "D. Salir", "Menú Principal", JOptionPane.INFORMATION_MESSAGE);

            switch (op.charAt(0)) {
                case 'a':
                case 'A':
                    Clase_Vehiculo obj = new Clase_Vehiculo("", "", "", "");

                    obj.setPlaca(JOptionPane.showInputDialog(null, "" +
                            "Digite la placa del vehículo: "));
                    obj.setTipoVehiculo(JOptionPane.showInputDialog(null, "" +
                            "Ingrese el tipo de vehículo (carro/moto/etc): "));
                    obj.setHoraEntrada(JOptionPane.showInputDialog(null, "" +
                            "Digite la hora de entrada (HH:mm, horario militar): "));
                    obj.setHoraSalida(JOptionPane.showInputDialog(null, "" +
                            "Digite la hora de salida (HH:mm, horario militar): "));

                    // Registrar el vehículo en el parqueadero
                    if (parqueadero.registrarVehiculo(obj)) {
                        JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay capacidad disponible.");
                    }


                    break;
                case 'b':
                case 'B':
                    // Crear un objeto temporal para almacenar la placa
                    Clase_Vehiculo vehiculoTemp = new Clase_Vehiculo("", "", "", "");
                    vehiculoTemp.setPlaca(JOptionPane.showInputDialog(null, "Digite la placa del vehículo a retirar: "));

                    // Retirar el vehículo utilizando la placa almacenada en vehiculoTemp
                    parqueadero.retirarVehiculo(vehiculoTemp.getPlaca());


                    break;
                case 'c':
                case 'C':
                    int espaciosOcupados = parqueadero.getEspaciosOcupados();
                    int capacidadDisponible = parqueadero.consultarCapacidadDisponible();
                    JOptionPane.showMessageDialog(null, "Espacios ocupados: " + espaciosOcupados +
                            "\nCapacidad disponible: " + capacidadDisponible);

                    break;
                case 'd':
                case 'D':
                    JOptionPane.showMessageDialog(null, "Saliendo....:D");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción Incorrecta");
                    break;
            }
        } while (!op.equalsIgnoreCase("D"));

    }
}
