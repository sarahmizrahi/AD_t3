package Ejercicios

import javax.swing.*
import java.awt.*
import com.squareup.moshi.*
import java.io.*

class FinestraJSON : JFrame() {

    init {
        //Crea objeto Moshi para manejar JSON
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        //Adaptador para deserializar la clase Rutes
        val adaptador = moshi.adapter(Rutes::class.java)

        //Lee Rutes.json
        val json = File("Rutes.json").readText()

        //Deserializa JSON en un objeto Rutes
        val rutesObj = adaptador.fromJson(json)
        val rutes = if (rutesObj != null) rutesObj.rutes else emptyList()


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)


        val nomsLlistaRutes = arrayListOf<String>()
        //Obtiene los nombres de las rutas
        for (ruta in rutes) {
            nomsLlistaRutes.add(ruta.nom)
        }

        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)


        combo.addActionListener {
            val selec = combo.selectedIndex  //Obtiene el índice del elemento seleccionado
            val rutaSelec = rutes[selec]  //Obtiene la ruta seleccionada

            //Limpia el JTextArea
            area.text = ""

            //Recorre la lista de la ruta seleccionada
            for (punt in rutaSelec.llistaDePunts) {
                val nomPunt = punt.nom
                val latitud = punt.coord.latitud
                val longitud = punt.coord.longitud

                //Mostrar datos
                area.append("$nomPunt ($latitud, $longitud)\n")
            }
        }
    }
}


// Main
fun main() {
    // Llamamos al constructor de la clase FinestraJSON para mostrar la ventana
    EventQueue.invokeLater {
        FinestraJSON().isVisible = true
    }
}