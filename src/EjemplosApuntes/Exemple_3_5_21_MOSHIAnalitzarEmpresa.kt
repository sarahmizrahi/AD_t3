package EjemplosApuntes

import com.squareup.moshi.*
import java.io.File

/*Leer archivo Empresa.json con MOSHIm, en este formato:
{
  "empresa": {
    "empleats": [
      { "num": 1, "nom": "Andreu", "departament": 10, "edat": 32, "sou": 1000.0 },
      { "num": 2, "nom": "Bernat", "departament": 20, "edat": 28, "sou": 1200.0 },
      { "num": 3, "nom": "Clàudia", "departament": 10, "edat": 26, "sou": 1100.0 },
      { "num": 4, "nom": "Damià", "departament": 10, "edat": 40, "sou": 1500.0 }
    ]
  }
}

 */


fun main (args: Array<String>) {
    // Leer el archivo JSON
    val json = File("Empresa.json").readText()

    // Crear el Moshi con el adaptador de Kotlin
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // Aquí agregamos KotlinJsonAdapterFactory
    val adapter = moshi.adapter(Empresa::class.java)
    val empresa = adapter.fromJson(json)

    // Acceder a la lista de empleados y mostrar la información
    val llEmpleats = empresa!!.empresa.empleats
    println("Hi ha ${llEmpleats.size} empleats:")
    for (e in llEmpleats)
        println("${e.nom} (${e.sou})")
}