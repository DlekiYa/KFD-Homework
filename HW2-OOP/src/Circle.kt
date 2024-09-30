class Circle(property: Double) : Figure(property) {
    override fun toString(): String {
        return "Circle(property=$property)"
    }
}