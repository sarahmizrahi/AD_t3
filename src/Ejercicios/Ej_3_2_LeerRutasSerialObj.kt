package Ejercicios


import java.io.*

fun main(args: Array<String>) {

    //LEER lo que se ha pasado en Ej_3_2 del Rutes.obj

    //Abre el archivo/objeto serializado para lectura
    val f_out = ObjectInputStream(FileInputStream("Rutes.obj"))

    //try-catch para manejar la lectura de los objetos hasta llegar al final del archivo
    try {
        //Mientras haya datos para leer (true)
        while (true) {
            //Lee f_out y lo convierte en tipo Ruta para acceder a su clase (metodos, etc)
            val e = f_out.readObject() as Ruta
            //Mostrar los datos con la funcion de la clase Ruta
            //Deja usar .mostrarRuta() porque se ha accedido a la clase Ruta "as Ruta"
            e.mostrarRuta()
            //Salto de linea
            /*Pese a que está puesto en el ejercicio de pasar los datos,
            no se copia porque solo afecta a la salida por consola. No es un dato*/
            println()
        }
    } catch (eof: EOFException) {
        //Cerrar el flujo
        f_out.close()
    }
}