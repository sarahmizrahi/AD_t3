package EjemplosApuntes

import java.io.*

fun main(args: Array<String>) {

    //Leer obejtos serializados de .obj

    val f = ObjectInputStream(FileInputStream("Empleats.obj"))  //Permite leer objetos serializados

    //try-catch para manejar la lectura de los objetos hasta llegar al final del archivo
    try {
        while (true) {
            //Se lee un objeto de Empleado.obj y se convierte a un objeto de tipo Empleado
            val e = f.readObject() as Empleado
            //Imprime la info
            println("Número: " + e.num)
            println("Nom: " + e.nombre)
            println("Departament: " + e.departamento)
            println("Edat: " + e.edad)
            println("Sou: " + e.sueldo)
            println();
        }
        //Cuando se llega al final de la lectura, o sea, cuando acaba el bucle while, se lanza la excepcion
    } catch (eof: EOFException) {
        f.close()
    }
}