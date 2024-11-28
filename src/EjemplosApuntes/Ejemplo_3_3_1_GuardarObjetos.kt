package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Crear, escribir y guardar objetos serialiados en Empleats.obj

    val f = ObjectOutputStream(FileOutputStream("Empleats.obj"))   //Permite escribir objetos, FileOutputStream porque es una fichero

    //Arrays para almacenar info de los empleados
    val noms = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")
    val departaments = arrayOf(10, 20, 10, 10)
    val edats = arrayOf(32, 28, 26, 40)
    val sous = arrayOf(1000.0, 1200.0, 1100.0, 1500.0)

    //Recorre los indices de los arrays del 0 al 3
    for (i in 0..3){
        //C rea un nuevo objeto de tipo `Empleado`, asignando valores de los arrays
        //Se escribe el objeto "e" emn el archivo usando la serializacion
        //CLASE EMPLEADO
        val e = Empleado (i + 1, noms[i], departaments[i], edats[i], sous[i])
        f.writeObject(e)
    }

    f.close();
}