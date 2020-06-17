package Interfaz;

public class Menu {
    int swValue;
    int origen;
    int destino;
    String fecha;

    public Menu(){

    }

    // Switch construct
    public void ejecutarMenu(){
        System.out.println("|   MENU SELECTION DEMO    |");
        System.out.println("| Options:                 |");
        System.out.println("|        1. Reservar pasaje       |");
        System.out.println("|        2. Option 2       |");
        System.out.println("|        3. Exit           |");
        swValue = Keyin.inInt(" Seleccionar opcion: ");

        switch (swValue) {
            case 1:
                System.out.println("Indicar fecha");
                System.out.println("Fecha: ");
                fecha = Keyin.inString();

                System.out.println("Indicar lugar de origen: ");

                do {
                    System.out.println("1. Buenos Aires\n2. Cordoba\n3. Santiago de Chile\n4. Montevideo");
                    origen = Keyin.inInt("Origen: ");

                    if (origen > 4 || origen < 1)
                        System.out.println("Opcion incorrecta.");
                }while (origen > 4 || origen < 1);

                switch (origen) {
                    case 1:
                        System.out.println("1. Cordoba\n2. Santiago de Chile\n3. Montevideo");
                        break;
                    case 2:
                        System.out.println("1. Buenos Aires\n2. Santiago de Chile\n3. Montevideo");
                        break;
                    case 3:
                        System.out.println("1. Buenos Aires\n2. Cordoba\n3. Montevideo");
                        break;
                    case 4:
                        System.out.println("1. Buenos Aires\n2. Cordoba\n3. Santiago de Chile");
                        break;
                }
                do{
                    destino = Keyin.inInt("Destino: ");
                    if (destino < 1 || destino > 3)
                        System.out.println("Opcion incorrecta.");
                }while (destino < 1 || destino > 3);

            /*case 2:
                System.out.println("Option 2 selected");
                break;
            case 3:
                System.out.println("Exit selected");
                break;
            case 4:
                System.out.println("Probando");
            default:
                System.out.println("Invalid selection");
                break; // This break is not really necessary*/
        }
    }

}
