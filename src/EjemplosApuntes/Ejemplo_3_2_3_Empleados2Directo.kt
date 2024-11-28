package EjemplosApuntes

import java.io.RandomAccessFile
import java.util.Scanner

fun main(args: Array<String>) {

    //Acceso directo a Empleados2.dat
    //Pide por teclado que registro quiere ver

    val f = RandomAccessFile("Empleats2.dat", "rw") //Con permisos de lectura y escritura
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")
    var num = sc.nextInt ()

    while (num != -1) {
        //Psiciona el puntero en la posicion resultante de la formula
        //Cada registro ocupa 32 bytes, por lo que se multiplica por (num - 1)
        f.seek(32 * (num - 1).toLong())
        println("Núm.: " + f.readInt())
        println("Nom: " + f.readUTF())
        println("Depart: " + f.readInt())
        println("Edat: " + f.readInt())
        println("Sou: " + f.readDouble())
        println()
        println("Quin registre? (-1 per a eixir): ")

        num = sc.nextInt()  //Leer nueva entrada por teclado

    }
    f.close()
}