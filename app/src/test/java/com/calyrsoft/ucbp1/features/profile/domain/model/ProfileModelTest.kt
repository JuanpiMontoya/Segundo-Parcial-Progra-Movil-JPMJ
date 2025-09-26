package com.calyrsoft.ucbp1.features.profile.domain.model

import kotlin.test.Test
import kotlin.test.assertFailsWith

class ProfileModelTest {
    @Test
    fun `Nombre correctamente`() {
        NameVO("Sara Montenegro")
        assertFailsWith<IllegalArgumentException> { NameVO("") }
        assertFailsWith<IllegalArgumentException> { NameVO("A") }
    }

    @Test
    fun `Email correctamente`() {
        EmailVO("sara@example.com") 
        assertFailsWith<IllegalArgumentException> { EmailVO("sara") }
        assertFailsWith<IllegalArgumentException> { EmailVO("sara@example") }
    }

    @Test
    fun `Teléfono correctamente`() {
         CellphoneVO("+591 755-48239") 
        assertFailsWith<IllegalArgumentException> { CellphoneVO("755-48239") }
        assertFailsWith<IllegalArgumentException> { CellphoneVO("+59175548239") }
    }

    @Test
    fun `URL correctamente`() {
        ImageUrlVO("https://example.com/image.jpg") 
        assertFailsWith<IllegalArgumentException> { ImageUrlVO("example.com/image.jpg") }
    }

    @Test
    fun `Resumen correctamente`() {
        SummaryVO("Ingeniera en telecomunicaciones...") 
        assertFailsWith<IllegalArgumentException> { SummaryVO("Corto") }
    }
}