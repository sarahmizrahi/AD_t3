package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //FICHEROS BINARIOS
    //Crear y guardar en Empleados.dat distintos datos

    val f = DataOutputStream(FileOutputStream("Empleados.dat")) //Crear fichero en modo que acepte distintos datos(Strings, ints etc)

    val nombres = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")   //indice 0
    val departamentos = arrayOf( 10, 20, 10, 10 )                   //indice 1
    val edades = arrayOf( 32, 28, 26, 40 )                          //indice 2
    val sueldos = arrayOf( 1000.0, 1200.0, 1100.0, 1500.0 )         //indice 3


    for (i in 0..3){    //Recorre todos los indices
        f.writeInt(i + 1)   //Y escribelos en el fichero. +1 porque empieza en 0. Asi empezara a escribir en 1
        f.writeUTF(nombres[i])
        f.writeInt(departamentos[i])
        f.writeInt(edades[i])
        f.writeDouble(sueldos[i])
    }
    f.close()
    println("Fichero creado")
}