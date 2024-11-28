package EjemplosApuntes

import java.io.*
import javax.xml.parsers.*
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main(args: Array<String>) {

    //Pasa el archivo Empleados.obj a crear Empleados.xml


    //Permite leer Empleats.obj
    val f = ObjectInputStream(FileInputStream ("Empleats.obj"))
    //Crea un xml donde se guardará la info
    val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
    //Crea la etiqueta raiz
    val arrel = doc.createElement ("empleats")
    //Añade la etiqueta raiz al xml
    doc.appendChild(arrel)

    //Leer objetos en try-catch para lanzar excepciones
    try {
        //Mientras haya objetos que leer
        while (true) {
            //Lee un objeto y conviertelo a tipo Empleado, y guardalo en e
            val e = f.readObject () as Empleado
            //Crear etiqueta nueva
            val emp = doc.createElement ("empleat")
            //Crear el atributo numero <empleat numero="1">
            emp.setAttribute("numero", Integer.toString(e.num))

            //Crear etiqueta nueva
            val nom = doc.createElement ("nom")
            //Añade el nombre del empleado a <nom> y estable <nom> como etiqueta hijo
            nom.appendChild(doc.createTextNode(e.nombre)) // forma llarga: afegim un fill que és un node de text
            //Añade la etiqueta <nom> dentro de la etiqueta padre <empleado>
            emp.appendChild(nom)

            val dep = doc.createElement("departament")
            dep.setTextContent(e.departamento.toString()) // forma curta: amb setTextContent() li posem contingut
            emp.appendChild(dep)

            val edat = doc.createElement("edat")
            edat.setTextContent(e.edad.toString())
            emp.appendChild(edat)

            val sou = doc.createElement("sou");
            sou.setTextContent(e.sueldo.toString())
            emp.appendChild(sou)

            arrel.appendChild(emp)
        }

    } catch (eof: EOFException) {
        f.close();
    }
    val trans = TransformerFactory.newInstance().newTransformer()

    //Retornos de carro. Saltos de linea en las etiquetas
    trans.setOutputProperty(OutputKeys.INDENT, "yes")
    trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")

    trans.transform(DOMSource(doc), StreamResult("Empleats.xml"))
}