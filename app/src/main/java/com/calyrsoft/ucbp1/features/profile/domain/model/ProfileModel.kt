package com.calyrsoft.ucbp1.features.profile.domain.model

// CREACION DE LOS VALUE OBJECT
data class ProfileModel(
    val pathUrl: ImageUrlVO,
    val name: NameVO,
    val email: EmailVO,
    val cellphone: CellphoneVO,
    val summary: SummaryVO
)

@JvmInline
value class NameVO(val value: String) {
    init {
        require(value.isNotBlank() && value.length >= 2) { "El nombre debe tener al menos 2 caracteres." }
    }
}

@JvmInline
value class EmailVO(val value: String) {
    init {
        require(value.matches(Regex("[^@]+@[^@]+\\.[^@]+"))) { "El email no es válido." }
    }
}

@JvmInline
value class CellphoneVO(val value: String) {
    init {
        require(value.matches(Regex("^\\+\\d{1,3} \\d{3}-\\d{4,}$"))) { "El teléfono no es válido. Ejemplo: +591 755-48239" }
    }
}

@JvmInline
value class ImageUrlVO(val value: String) {
    init {
        require(value.startsWith("http")) { "La URL de la imagen debe empezar con http o https." }
    }
}

@JvmInline
value class SummaryVO(val value: String) {
    init {
        require(value.length >= 10) { "El resumen debe tener al menos 10 caracteres." }
    }
}