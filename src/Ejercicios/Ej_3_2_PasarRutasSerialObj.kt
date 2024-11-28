package Ejercicios


import java.io.*

fun main(args: Array<String>) {

    //COPIAR/PASAR la info de Rutes.dat a Rutes.obj

    //Abre el fichero para lectura
    val f_in = DataInputStream(FileInputStream("Rutes.dat"))

    //Preparar fichero para escritura
    val f_out = ObjectOutputStream(FileOutputStream("Rutes.obj"))

    //Mientras haya datos que leer
    while (f_in.available() > 0){
        //Lee dato por dato y almacena la lectura en variables
        val nomRuta = f_in.readUTF()
        val desnivel = f_in.readInt()
        val desnivelAcumulado = f_in.readInt()
        val puntos = f_in.readInt()

        println()   //Dejar salto de linea

        //Como enla clase Ruta se define listaPuntos como lista mutable para poder editarla
        val listaPuntos = mutableListOf<PuntGeo>()

        //Recorrer toda la lista mientras haya datos para leer
        for (i in 0 until puntos){
            val nombrePunto = f_in.readUTF()
            val latitud = f_in.readDouble()
            val longitud = f_in.readDouble()
            //Y agregar los datos que se van leyendo
            //Ojo, tener en cuenta que en la clase PuntGeo como parametro está la clase Coordenadas
            listaPuntos.add(PuntGeo(nombrePunto, Coordenadas(latitud, longitud)))
        }

        //Crear objeto Ruta
        val ruta = Ruta(nomRuta, desnivel, desnivelAcumulado, listaPuntos)
        ruta.mostrarRuta()  //Mostrar la lista del objeto
        f_out.writeObject(ruta) //Y escribirlo en Rutes.obj
    }
    //Cerrar los flujos
    f_in.close()
    f_out.close()
}