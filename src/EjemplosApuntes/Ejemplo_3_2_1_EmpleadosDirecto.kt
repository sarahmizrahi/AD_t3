package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Acceso directo a ficheros

    val f = RandomAccessFile("Empleados.dat", "r")  //El 2 parametro hace referencia al permiso (r/w)
    f.seek(56)  //Situa el puntero en la posicion 56, en Claudia
    println("Núm.: " + f.readInt())
    println("Nom: " + f.readUTF())
    println("Depart: " + f.readInt())
    println("Edat: " + f.readInt())
    println("Sou: " + f.readDouble())
    f.close()
}