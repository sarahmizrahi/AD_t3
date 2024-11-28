package EjemplosApuntes

import java.io.DataOutputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {

    //El unico cambio respecto al ejemplo 1, es la variable nombre
    //Se deja espacio de 10 caracteres para que que la longitud sea fija

    val f = DataOutputStream(FileOutputStream("Empleats2.dat"))

    val noms = arrayOf("Andreu    ","Bernat    ","Clàudia   ","Damià     ")
    val departaments = arrayOf( 10, 20, 10, 10 )
    val edats = arrayOf( 32, 28, 26, 40 )
    val sous = arrayOf( 1000.0, 1200.0, 1100.0, 1500.0 )

    for (i in 0..3){
        f.writeInt(i + 1)
        f.writeUTF(noms[i])
        f.writeInt(departaments[i])
        f.writeInt(edats[i])
        f.writeDouble(sous[i])
    }
    f.close()
    println("Fitxer creat")
}