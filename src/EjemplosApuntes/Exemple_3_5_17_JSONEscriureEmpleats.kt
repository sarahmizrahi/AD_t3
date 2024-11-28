package EjemplosApuntes

import org.json.JSONObject
import org.json.JSONArray
import java.io.FileWriter

/*Crear un JSON, Empleats.json y organizar con una identacion de 4 espacios:
{
    "empresa": {
        "empleat": [
        {"num": "1", "nom": "Andreu", "departament": "10", "edat": "32", "sou": "1000.0"},
        {"num": "2", "nom": "Bernat", "departament": "20", "edat": "28", "sou": "1200.0"},
        {"num": "3", "nom": "Clàudia", "departament": "10", "edat": "26", "sou": "1100.0"},
        {"num": "4", "nom": "Damià", "departament": "10", "edat": "40", "sou": "1500.0"}
        ]
    }
}*/

fun main(args: Array<String>) {
    val noms = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")
    val departaments = arrayOf( 10, 20, 10, 10 )
    val edats = arrayOf( 32, 28, 26, 40 )
    val sous = arrayOf( 1000.0, 1200.0, 1100.0, 1500.0)

    val arrel = JSONObject()
    val empresa = JSONObject()
    arrel.put("empresa", empresa)
    val empleats = JSONArray()
    empresa.put("empleat", empleats)

    for (i in 0..3){
        val emp = JSONObject()
        emp.put("num", i + 1)
        emp.put("nom", noms[i])
        emp.put("departament", departaments[i])
        emp.put("edat", edats[i])
        emp.put("sou", sous[i])
        empleats.put(emp)
    }

    val f = FileWriter("Empleats.json")
    f.write(arrel.toString(4))
    f.close()
}