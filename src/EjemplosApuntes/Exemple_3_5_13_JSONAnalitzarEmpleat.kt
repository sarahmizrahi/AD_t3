package EjemplosApuntes

import org.json.JSONTokener
import org.json.JSONObject
import java.io.FileReader


/*Accede a la informacion de un empleado, lee nombre y sueldo*/

fun main(args: Array<String>) {

    val r_json = FileReader("Empleats.json")

    val raiz = JSONTokener(r_json).nextValue() as JSONObject

    val empleat = raiz.get("empleat") as JSONObject

    println("" + empleat.get("nom") + " (" + empleat.get("sou") + ")")
}