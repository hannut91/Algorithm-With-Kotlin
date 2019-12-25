package printer.hys.saj.hhj

fun printer(priorities: IntArray, location: Int): Int {
    val newPriorities = priorities
        .mapIndexed { index, i -> Pair(i, location == index) }
    return print(newPriorities, 0)
}

fun print(priorities: List<Pair<Int, Boolean>>, count: Int): Int {
    val nextDoc = priorities.first()
    if (priorities.find { it.first > nextDoc.first } != null) {
        return print(priorities.drop(1).plus(nextDoc), count)
    }

    if (!nextDoc.second) {
        return print(priorities.drop(1), count + 1)
    }

    return count + 1
}
