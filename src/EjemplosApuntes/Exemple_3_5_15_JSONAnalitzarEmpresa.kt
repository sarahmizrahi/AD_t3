package EjemplosApuntes

import org.json.JSONTokener
import org.json.JSONObject
import java.io.FileReader

fun main(args: Array<String>) {

    val r_json = FileReader("Empresa.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONObject
    val empresa = arrel.getJSONObject("empresa")

    for (e in empresa.getJSONArray("empleats")){    //hemos evitado definir previamente la variable empleats y directamente la obtenemos dentro del bucle
        val emp = e as JSONObject
        println("" + emp.get("nom") + " (" + emp.get("sou") + ")")
    }
}