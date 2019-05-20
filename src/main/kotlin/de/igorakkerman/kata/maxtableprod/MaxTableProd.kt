package de.igorakkerman.kata.maxtableprod

import java.lang.Integer.max

class MaxTableProd(val prodSize: Int, numbersString: String) {

    val numbers: List<List<Int>>
    val width: Int
    val height: Int

    init {
        numbers = numbersString
                .lines()
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .map { it.split(' ') }
                .map { it.map { it.toInt() } }

        if (prodSize < 1)
            throw IllegalArgumentException("prodSize=${prodSize}<1")

        height = numbers.size

        if (height < prodSize)
            throw IllegalArgumentException("height=${height}<${prodSize}=prodSize")

        width = numbers[0].size

        if (width < prodSize)
            throw IllegalArgumentException("row 0 width=${width}<${prodSize}=prodSize")

        numbers.forEachIndexed { rowIndex, row ->
            if (row.size != width)
                throw IllegalArgumentException("row ${rowIndex} width=${row.size}!=${width}")
        }
    }

    internal fun maxHorizontalProd(): Int {
        var maxProd = 0
        for (i in (0 until height)) {
            for (j in (0..width - prodSize)) {
                maxProd = max(maxProd, (0 until prodSize).map { numbers[i][j + it] }.reduce { x, y -> x * y })
            }
        }
        return maxProd
    }

    internal fun maxVerticalProd(): Int {
        var maxProd = 0
        for (j in (0 until width)) {
            for (i in (0..height - prodSize)) {
                maxProd = max(maxProd, (0 until prodSize).map { numbers[i + it][j] }.reduce { x, y -> x * y })
            }
        }
        return maxProd
    }

    internal fun maxDiagonalLeftProd(): Int {
        return (prodSize - 1 until height).flatMap { i ->
            (prodSize - 1 until width).map { j ->
                (0 until prodSize).map { numbers[i - it][j - it] }.reduce { x, y -> x * y }
            }
        }.reduce { x, y -> max(x, y) }
    }

    internal fun maxDiagonalRightProd(): Int {
        var maxProd = 0
        for (i in (prodSize - 1 until height)) {
            for (j in (0..width - prodSize)) {
                val fn = { k: Int -> numbers[i - k][j + k] }
                maxProd = max(maxProd, (0 until prodSize).map(fn).reduce { x, y -> x * y })
            }
        }
        return maxProd
    }
}
