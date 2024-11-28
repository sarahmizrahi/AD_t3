package EjemplosApuntes

import java.io.Serializable

class Empleado(var num: Int, var nombre: String, var departamento: Int, var edad: Int, var sueldo: Double): Serializable {  //Para convertir los datos en bytes

        //Permite compartir los datos
        companion object {
            private const val serialVersionUID: Long = 1
        }
}