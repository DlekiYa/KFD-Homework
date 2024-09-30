class Square(property: Double) : Figure(property) {
    override fun toString(): String {
        return "Square(property=$property)"
    }
}