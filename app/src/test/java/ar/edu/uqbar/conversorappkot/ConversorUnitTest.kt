package ar.edu.uqbar.conversorappkot

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ConversorUnitTest {
    val conversor = Conversor()

    @Before
    fun init() {
        conversor.millas = 100.0
        conversor.convertir()
    }

    @Test
    fun conversionEmptyConverter() {
        val conversorVacio = Conversor()
        assertEquals(0.0, conversorVacio.kilometros, 0.01)
    }

    @Test
    fun conversionHappyPath() {
        assertEquals(160.9344, conversor.kilometros, 0.01)
    }

    @Test
    fun conversionToStringHappyPath() {
        assertEquals("160,934", conversor.kilometrosAsString())
    }

}