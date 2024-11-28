package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Crea Empleados3.dat

    val f = DataOutputStream(FileOutputStream("Empleats3.dat"))

    val noms = arrayOf("Andreu    ","Bernat    ","Clàudia   ","Damià     ")
    val departaments = arrayOf( 10, 20, 10, 10 )
    val edats = arrayOf( 32, 28, 26, 40 )
    val sous = arrayOf( 1000.0, 1200.0, 1100.0, 1500.0 )

    for (i in 0..3){
        f.writeInt(i + 1)
        f.writeChars(noms[i])
        f.writeInt(departaments[i])
        f.writeInt(edats[i])
        f.writeDouble(sous[i])
    }
    f.close()
    println("Fitxer creat")
}