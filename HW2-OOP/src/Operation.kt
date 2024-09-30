enum class Operation {
    INSERT, GET_AREA, GET_PERIMETER, EXIT
}

fun getOperation(input: String): Operation {
    return when (input.toIntOrNull()) {
        1 -> Operation.INSERT
        2 -> Operation.GET_AREA
        3 -> Operation.GET_PERIMETER
        4 -> Operation.EXIT
        else -> throw WrongOperationTypeException(input)
    }
}