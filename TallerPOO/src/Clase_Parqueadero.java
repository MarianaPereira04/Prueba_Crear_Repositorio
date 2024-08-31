import javax.swing.*;

public class Clase_Parqueadero {
    private final int capacidad = 10;
    private Clase_Vehiculo[] vehiculos;
    private int vehiculosActuales;

    //Constructor de la clase Clase_Parqueadero
    public Clase_Parqueadero() {
        vehiculos = new Clase_Vehiculo[capacidad];
        vehiculosActuales = 0;
    }

    //Registrar un nuevo vehículo en el parqueadero
    public boolean registrarVehiculo(Clase_Vehiculo vehiculo) {
        if (vehiculosActuales < capacidad) {
            vehiculos[vehiculosActuales] = vehiculo;
            vehiculosActuales++;
            return true;
        } else {
            return false; // No hay espacio disponible
        }
    }

    //Retornar el número de espacios ocupados contenidos en la variable VehiculosActuales
    public int getEspaciosOcupados() {
        return vehiculosActuales;
    }

    //Retorna la capacidad disponible
    public int consultarCapacidadDisponible() {
        return capacidad - vehiculosActuales;
    }

    //Retira un vehículo del parqueadero según su placa
    public void retirarVehiculo(String placa) {
        for (int i = 0; i < vehiculosActuales; i++) {
            if (vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                // Calcular tarifa
                long tarifa = calcularTarifa(vehiculos[i]);

                // Mostrar información
                JOptionPane.showMessageDialog(null, "Placa: " + vehiculos[i].getPlaca() +
                        "\nTipo: " + vehiculos[i].getTipoVehiculo() +
                        "\nTiempo de permanencia: " + calcularTiempoPermanencia(vehiculos[i]) +
                        "\nPrecio a pagar: " + tarifa);

                // Eliminar el vehículo
                for (int j = i; j < vehiculosActuales - 1; j++) {
                    vehiculos[j] = vehiculos[j + 1];
                }
                vehiculosActuales--;
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
    }

    //Calcula la tarifa para un vehículo según su tipo y tiempo de permanencia
    private long calcularTarifa(Clase_Vehiculo vehiculo) {
        int[] entrada = parseHora(vehiculo.getHoraEntrada());
        int[] salida = parseHora(vehiculo.getHoraSalida());
        long horas = calcularHoras(entrada, salida);

        if (vehiculo.getTipoVehiculo().equalsIgnoreCase("carro")) {
            return horas * 1000;
        } else if (vehiculo.getTipoVehiculo().equalsIgnoreCase("moto")) {
            return horas * 500;
        } else {
            return horas * 1500; // tarifa para otro tipo de vehículos
        }
    }

    //Parsea una cadena de hora en un arreglo de enteros con horas y minutos
    private int[] parseHora(String hora) {
        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return new int[]{horas, minutos};
    }

    //Calcula el tiempo en horas entre dos momentos
    private long calcularHoras(int[] entrada, int[] salida) {
        int entradaHoras = entrada[0];
        int entradaMinutos = entrada[1];
        int salidaHoras = salida[0];
        int salidaMinutos = salida[1];

        long minutosEntrada = entradaHoras * 60 + entradaMinutos;
        long minutosSalida = salidaHoras * 60 + salidaMinutos;

        long diferenciaMinutos = minutosSalida - minutosEntrada;
        return (diferenciaMinutos + 59) / 60; // Redondeo hacia arriba para las horas parciales
    }

    //Calcula el tiempo de permanencia del vehículo en horas y minutos
    private String calcularTiempoPermanencia(Clase_Vehiculo vehiculo) {
        int[] entrada = parseHora(vehiculo.getHoraEntrada());
        int[] salida = parseHora(vehiculo.getHoraSalida());
        long diferenciaMinutos = calcularDiferenciaMinutos(entrada, salida);
        long horas = diferenciaMinutos / 60;
        long minutos = diferenciaMinutos % 60;
        return horas + " horas y " + minutos + " minutos";
    }


    //Calcula la diferencia de tiempo
    private long calcularDiferenciaMinutos(int[] entrada, int[] salida) {
        int entradaHoras = entrada[0];
        int entradaMinutos = entrada[1];
        int salidaHoras = salida[0];
        int salidaMinutos = salida[1];

        long minutosEntrada = entradaHoras * 60 + entradaMinutos;
        long minutosSalida = salidaHoras * 60 + salidaMinutos;

        return minutosSalida - minutosEntrada;
    }

}
