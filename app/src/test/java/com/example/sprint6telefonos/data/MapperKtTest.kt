package com.example.sprint6telefonos.data

import com.example.sprint6telefonos.data.remote.Fono
import org.junit.Assert.*

import org.junit.Test

class MapperKtTest {

    @Test
    fun toEntity() {
        val phone  = Fono(987,"algo", 777777, "noimg")

        val result = phone.toEntity()

        assertEquals(phone.id, result.id)
        assertEquals(phone.name, result.nombre)
        assertEquals(phone.price, result.precio)
        assertEquals(phone.image, result.imagen)

    }
}