package Ejercicios

import java.io.*

fun main(args: Array<String>) {

    val f = DataInputStream(FileInputStream("Rutes.dat"))   //Abre el fichero

    while (f.available() > 0) {     //Mientras el fichero sea mayor que 0, o sea, mientras tenga datos para leer

        //Leer datos de la ruta y guardarlo en variables
        //Dentro del while, de lo contrario no se leen todas las rutas, se repite la primera
        val nomRuta = f.readUTF()
        val desnivel = f.readInt()
        val desnivelAcumulado = f.readInt()
        val numPuntos = f.readInt()

        //Muestra los datos leidos del fichero que se han almacenado en las variables
        println("Ruta: $nomRuta")
        println("Desnivel: $desnivel")
        println("Desnivel acumulado: $desnivelAcumulado")
        println("Tiene $numPuntos puntos")

        //Recorrer todos los puntos y mostrarlos
        for (i in 0 until numPuntos) {
            val nomP = f.readUTF()
            val latitud = f.readDouble()
            val longitud = f.readDouble()
            println("Punto ${i+1}: $nomP ($latitud, $longitud)")

        }
        println() //Salto de linea para dejar linea en blanco
    }
}