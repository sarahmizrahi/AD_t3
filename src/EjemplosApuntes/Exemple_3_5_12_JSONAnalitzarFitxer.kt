package EjemplosApuntes

import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileReader


/*Analizar JSON desde un archivo*/

fun main(args: Array<String>) {

    val r_json = FileReader("parelles.json")

    val raiz = JSONTokener(r_json).nextValue() as JSONObject

    println(raiz.get("p3"))
}