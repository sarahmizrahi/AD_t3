package EjemplosApuntes

import com.squareup.moshi.*
import java.io.File


/*lee las estaciones de bicicletas, las transforma según el nuevo formato y actualiza el archivo JSON*/

class EstDesti(val num: Int, val nom: String, val llocs: Int, val ocupats: Int, val lliures: Int)

class Bicicas2(val bicicas: List<EstDesti>)

fun main(args: Array<String>) {
    // Leer el archivo JSON
    val json = File("Bicicas.json").readText()

    // Crear el Moshi con el adaptador de Kotlin
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    // Adaptador para deserializar la lista de Estacions
    val llistaTipus = Types.newParameterizedType(List::class.java, Estacions::class.java)
    val adapter: JsonAdapter<List<Estacions>> = moshi.adapter(llistaTipus)

    // Convertir el JSON a objetos
    val estacions = adapter.fromJson(json)?.get(0)?.ocupacion ?: emptyList()

    // Crear un nuevo objeto con los datos transformados
    val llistaEstDesti = estacions.map { e ->
        EstDesti(
            e.id.toInt(), e.punto, e.puestos, e.ocupados, e.puestos - e.ocupados
        )
    }

    val bicicas2 = Bicicas2(llistaEstDesti)

    // Adaptador para convertir el objeto a JSON
    val adapter2 = moshi.adapter(Bicicas2::class.java)
    val json2 = adapter2.toJson(bicicas2)

    // Escribir el nuevo JSON en un archivo
    File("Bicicas2.json").writeText(json2)
}