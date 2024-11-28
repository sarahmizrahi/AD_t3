package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //FICHEROS BINARIOS
    //Recuperar los datos de Empleados.dat

    val f = DataInputStream(FileInputStream("Empleados.dat"))    //Abre el fichero

    while (f.available() > 0) {     //available devuelve el numero de bytes que pueden ser leidos
                                    //Mientras el fichero (f) tenga datos para leer, o sea, mayor que 0
        //Muestra y lee
        System.out.println("Número: " + f.readInt())
        System.out.println("Nombre: " + f.readUTF())
        System.out.println("Depart: " + f.readInt())
        System.out.println("Edad: " + f.readInt())
        System.out.println("Sueldo: " + f.readDouble())
        //Linea en blanco
        System.out.println()
    }
    f.close()
}