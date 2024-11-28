package EjemplosApuntes

import java.io.RandomAccessFile
import java.util.Scanner

fun main(args: Array<String>) {

    //REVISAR Y EXPLICAR

    val f = RandomAccessFile("Empleats3.dat", "rw") //Abre fichero con permisos r y w
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")    //Introducir registro por teclado
    var num = sc.nextInt()

    //Calcula la posición del registro en el fichero y muestra los datos
    //Empieza por el registro introducido por teclado
    while (num != -1) {     //Mientras el usuario no introduzca -1
        f.seek(40 * (num - 1).toLong()) /*Cada registro tiene 40 bytes, y se busca el registro multiplicando
                                           por 40 el número del registro (ajustado con `num - 1` para indexar desde 0)*/
        println("Núm.: " + f.readInt()) //Lee el entero correspondiente al id, 4 bytes
        var nom = ""    //Se inicializa una cadena vacía para leer el nombre del empleado
        for (i in 1..10)
            nom += f.readChar() //Se leen los 10 caracteres y se concatenan en la variable `nom`
        println("Nom: " + nom)
        println("Depart: " + f.readInt())
        println("Edat: " + f.readInt())
        println("Sou: " + f.readDouble())
        println()
        println("Quin registre? (-1 per a eixir): ")
        num = sc.nextInt()  //Permite inroducir nuevo numero por teclado

    }
    f.close()
}