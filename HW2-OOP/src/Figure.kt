sealed class Figure(val property: Double) {
    init {
        if (property <= 0.0 || property.isNaN()) {
            throw BadPropertyException(property)
        }
    }
}