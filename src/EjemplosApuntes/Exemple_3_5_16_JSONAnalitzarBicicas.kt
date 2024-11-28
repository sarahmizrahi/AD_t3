package EjemplosApuntes

import org.json.JSONTokener
import org.json.JSONObject
import org.json.JSONArray
import java.io.FileReader

fun main(args: Array<String>) {

    /*tomamos el primer objeto de la matriz, y luego utilizamos un bucle para procesar cada estación de la lista*/

    val r_json = FileReader("Bicicas.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONArray

    val estacions = arrel.getJSONObject(0).getJSONArray("ocupacion")

    for (e in estacions){
        val est = e as JSONObject
        println("" + e.get("id") + ".- " + e.get("punto") + " (" + e.get("ocupados") + "/" + e.get("puestos") + ")")
    }
}