package EjemplosApuntes

/*representa una estación de bicicletas*/

class Estacio(
    val id: Long, val punto: String, val puestos: Int,
    val ocupados: Int, val latitud: Double, val longitud: Double,
    val porcentajeAltaOcupacion: Int, val porcentajeBajaOcupacion: Int
)