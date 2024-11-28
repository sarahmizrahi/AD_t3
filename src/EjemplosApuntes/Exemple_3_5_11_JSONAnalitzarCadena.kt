package EjemplosApuntes

import org.json.*


/*Analizar JSON desde una cadena*/


fun main(args: Array<String>) {

    val cadena = "{ \"p1\" : 2 , \"p2\" : 4 , \"p3\" : 6 , \"p4\" : 8 , \"p5\" : 10 }"


    val raiz = JSONTokener(cadena)       //inicializa JSONTokener con una cadena JSON
        .nextValue() as JSONObject      //nextValue() convierte la cadena en un objeto JSON (JSONObject)


    println(raiz.get("p1"))     //obtenemos el valor asociado a la clave "p1"
}