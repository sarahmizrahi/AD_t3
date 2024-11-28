package Ejercicios

import com.squareup.moshi.*
import java.io.*



fun main(args: Array<String>) {
    //Abre el archivo Rutes.obj para lectura de objetos
    val obj = ObjectInputStream(FileInputStream("Rutes.obj"))

    //Crea una lista para almacenar las rutas leidas
    val rutes = mutableListOf<Ruta>()

    //Lee objetos mientras haya
    try {
        while (true) {
            //Lee un objeto de tipo Ruta
            val ruta = obj.readObject() as Ruta
            //y lo añade
            rutes.add(ruta)
        }
    } catch (e: EOFException) {
       e.message
    }

    //Crea un objeto Rutes con la lista de rutas leídas
    val rutesObj = Rutes(rutes)

    //Moshi para convertir el objeto a JSON
    //Crea un objeto moshi para deserializar y serializar clases
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() //Usar aunque este tachado, de lo contrario no funciona
    //Crea adaptador JSON para la clase Rutes
    val adapter: JsonAdapter<Rutes> = moshi.adapter(Rutes::class.java)
    //Usa el adaptador para convertir el objeto Rutes en cadena JSON y viceversa
    val json = adapter.toJson(rutesObj)

    //Escribe y guarda el archivo Rutes.json
    File("Rutes.json").writeText(json)
}


