class FigureServiceImpl : FigureService {
    private val figures: MutableList<Figure> = ArrayList()

    override fun addSquare(property: Double) {
        figures.add(Square(property))
    }

    override fun addCircle(property: Double) {
        figures.add(Circle(property))
    }

    override fun getArea() : Double {
        return figures.sumOf {
            when (it) {
                is Circle -> Math.PI * it.property * it.property
                is Square -> it.property * it.property
            }
        }
    }

    override fun getPerimeter(): Double {
        return figures.sumOf {
            when (it) {
                is Circle -> 2.0 * Math.PI * it.property
                is Square -> 4.0 * it.property
            }
        }
    }
}