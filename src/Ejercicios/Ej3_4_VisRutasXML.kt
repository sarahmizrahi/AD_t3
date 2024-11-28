package Ejercicios

import javax.swing.*
import java.awt.*
import org.w3c.dom.*
import javax.xml.parsers.*

    //GRAFICOS. Permite seleccionar la ruta y ver todos sus puntos

class Finestra : JFrame() {

    init {
        //Mi implementacion
        //Carga Rutas.xml
        val docXml: Document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml")

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()

        //Mi implementacion
        //Obtiene todas las <ruta> y los almacena en ruta
        val ruta = docXml.getElementsByTagName("ruta")

        //Mi implementacion
        //Recorre todas las <ruta> que hay
        for (i in 0 until ruta.length) {   //Desde 0 hasta el total de <ruta> que hayan
            val eRuta = ruta.item(i) as Element //Obtiene cada <ruta> como un objeto Element
            //Obtiene el nombre de la ruta con getElementsByTagName para buscar el primer <nombre>
            val nomRuta = eRuta.getElementsByTagName("nombre").item(0).getTextContent()
            llistaRutes.add(nomRuta)    //Y lo añade a la lista
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        //Mi implementacion
        //Evento para la seleccion de la lista desplegable
        combo.addActionListener {
            val selec = combo.getSelectedIndex() //Obtiene el índice del elemento seleccionado
            val rutaSelec = ruta.item(selec) as Element //Obtiene el elemento <ruta> selecionado

            //Limpiar el JTextArea para que no se vayan añadiendo los datos
            area.text = ""

            val puntos = rutaSelec.getElementsByTagName("punto")    //Obtiene <punto>
            //Recorre la lista de los puntos de la ruta seleccionada
            for (i in 0 until puntos.length) {
                val puntoEle = puntos.item(i) as Element
                //Obtiene las etiquetas y contenido de los elementos de <punto>
                val nomPunt = puntoEle.getElementsByTagName("nombre").item(0).getTextContent()
                val latitud = puntoEle.getElementsByTagName("latitud").item(0).getTextContent()
                val longitud = puntoEle.getElementsByTagName("longitud").item(0).getTextContent()

                //Añade y muestra los datos
                area.append("$nomPunt ($latitud$longitud)\n")
            }
        }
    }
}

//Main
fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Finestra().isVisible = true
    }
}
