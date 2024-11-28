package EjemplosApuntes

import com.squareup.moshi.*
import java.io.File

/*Leer Bicicas.json con MOSHI, en este formato:
[
{
    "ocupacion": [
    { "id": "01", "punto": "UJI - FCHS", "puestos": 28, "ocupados": 11, "latitud": "39.99533", "longitud": "-0.06999", "porcentajeAltaOcupacion": "80", "porcentajeBajaOcupacion": "20" },
    { "id": "02", "punto": "ESTACIÓN DE FERROCARRIL Y AUTOBUSES", "puestos": 28, "ocupados": 8, "latitud": "39.98765", "longitud": "-0.05281", "porcentajeAltaOcupacion": "80", "porcentajeBajaOcupacion": "20" },
    { "id": "03", "punto": "PLAZA DE PESCADERÍA", "puestos": 28, "ocupados": 13, "latitud": "39.98580", "longitud": "-0.03798", "porcentajeAltaOcupacion": "80", "porcentajeBajaOcupacion": "20" }
    ]
}
]*/

fun main(args: Array<String>) {
    // Leer el archivo JSON
    val json = File("Bicicas.json").readText()

    // Crear el Moshi con el adaptador de Kotlin
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // Agregar KotlinJsonAdapterFactory aquí
    val llistaTipus = Types.newParameterizedType(List::class.java, Estacions::class.java)
    val adapter: JsonAdapter<List<Estacions>> = moshi.adapter(llistaTipus)

    val bicicas = adapter.fromJson(json)

    // Acceder a las estaciones y mostrarlas
    val estacions = bicicas!!.get(0).ocupacion
    println("Hi ha " + estacions.size + " estacions:")
    for (e in estacions) {
        println("${e.id}: ${e.punto} (${e.ocupados}/${e.puestos})")
    }
}