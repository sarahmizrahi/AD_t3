package Ejercicios


import java.io.*

import javax.xml.parsers.*
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


fun main(args: Array<String>) {

    //Pasar .obj a .xml

    //Abre flujo para leer el archivo .obj
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))
    //Crea xml
    val docXml = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    //Crea la etiqueta raiz <ruta>
    val raiz = docXml.createElement("rutas")
    //Añade la etiqueta raiz al xml
    docXml.appendChild(raiz)

    //Leer objetos en try-catch para lanzar excepciones
    try {
        //Mientras haya objetos que leer
        while (true){
            //Lee un objeto y conviertelo a tipo Ruta, y guardalo en e
            val e = f.readObject() as Ruta
            //Crear etiqueta <ruta>
            val ruta = docXml.createElement("ruta")
            //Añade etiqueta
            raiz.appendChild(ruta)

            //Crea y añade <nombre>
            val nomRuta = docXml.createElement("nombre")
            nomRuta.setTextContent(e.nom)
            ruta.appendChild(nomRuta)

            //Crea y añade <desnivel>
            val desnivel = docXml.createElement("desnivel")
            desnivel.setTextContent(e.desnivell.toString())
            ruta.appendChild(desnivel)

            //Crea y añade <desnivelAcumulado>
            val desnivelAcumulado = docXml.createElement("desnivelAcumulado")
            desnivelAcumulado.setTextContent(e.desnivellAcumulat.toString())
            ruta.appendChild(desnivelAcumulado)

            //Crea y añade <puntos>
            val puntos = docXml.createElement("puntos")
            ruta.appendChild(puntos)

            //Itera sobre la lista de puntos
            for (i in 0 until e.llistaDePunts.size) {
                //Obtiene cada punto de la lista
                val punto = e.getPunt(i)

                //Crea y añade <punto>
                val ePunto = docXml.createElement("punto")
                //Crea el atributo numero <punto num="1">
                ePunto.setAttribute("num", (i + 1).toString())  //i+1 para empezar por 1 en lugar de 0

                //Crea y añade <nombre>>
                val nomPunt = docXml.createElement("nombre")
                nomPunt.setTextContent(punto.nom)
                ePunto.appendChild(nomPunt)

                //Crea y añade <latitud>
                val latitud = docXml.createElement("latitud")
                latitud.setTextContent(punto.coord.latitud.toString())
                ePunto.appendChild(latitud)

                //Crea y añade <longitud>
                val longitud = docXml.createElement("longitud")
                longitud.setTextContent(punto.coord.longitud.toString())
                ePunto.appendChild(longitud)

                //Añade el punto a la etiqueta <puntos>
                puntos.appendChild(ePunto)
            }
        }

    } catch (eof: EOFException) {
        f.close();
    }

    //Crea un transformador para convertir el documento XML a un archivo
    val trans = TransformerFactory.newInstance().newTransformer()

    //Configura el transformador para que el XML sea legible con saltos de línea
    trans.setOutputProperty(OutputKeys.INDENT, "yes")
    trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")

    //Transforma el XML y lo guarda en "Rutas.xml"
    trans.transform(DOMSource(docXml), StreamResult("Rutas.xml"))
}