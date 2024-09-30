class ConsoleServiceImpl : ConsoleService {
    private val figureService = FigureServiceImpl()

    override fun work() {
        while (true) {
            println("Введите тип операции, которую хотите исполнить:\n1) добавить фигуру\n2) получить площадь всех фигур\n3) получить периметр всех фигур\n4) завершить выполнение")
            try {
                val operation = getOperation(readln())
                when (operation) {
                    Operation.INSERT -> addFigure()
                    Operation.GET_AREA -> getArea()
                    Operation.GET_PERIMETER -> getPerimeter()
                    Operation.EXIT -> break
                }
            } catch (e: WrongOperationTypeException) {
                println("Введен неизвестный тип операции: ${e.operationType}")
            } catch (e: BadPropertyException) {
                println("Введено неверное значение параметра property: ${e.property}")
            }
        }
    }

    private fun addFigure() {
        println("Введите тип фигуры (circle/square) и её property через пробел:")
        val input = readln().split(" ")
        if (input.size != 2) {
            println("Неверный формат ввода")
            return
        }
        val type = input[0]
        val property = input[1].toDoubleOrNull() ?: throw BadPropertyException(input[1].toDouble())

        when (type) {
            "circle" -> figureService.addCircle(property)
            "square" -> figureService.addSquare(property)
            else -> println("Неизвестный тип фигуры")
        }
    }

    private fun getArea() {
        println("Площадь всех фигур: ${figureService.getArea()}")
    }

    private fun getPerimeter() {
        println("Периметр всех фигур: ${figureService.getPerimeter()}")
    }
}