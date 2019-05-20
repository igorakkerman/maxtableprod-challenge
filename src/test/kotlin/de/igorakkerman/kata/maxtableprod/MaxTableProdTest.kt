package de.igorakkerman.kata.maxtableprod

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MaxTableProdTest {

    @Test
    fun `1x1, 1`() {
        val maxTableProd = MaxTableProd(1, "42")

        assertThat(maxTableProd.maxHorizontalProd()).isEqualTo(42)
        assertThat(maxTableProd.maxVerticalProd()).isEqualTo(42)
        assertThat(maxTableProd.maxDiagonalLeftProd()).isEqualTo(42)
        assertThat(maxTableProd.maxDiagonalRightProd()).isEqualTo(42)
    }

    @Test
    fun `2x2, 1`() {
        val maxTableProd = MaxTableProd(1, """
                97 91
                28 42
        """)

        assertThat(maxTableProd.maxHorizontalProd()).isEqualTo(97)
        assertThat(maxTableProd.maxVerticalProd()).isEqualTo(97)
        assertThat(maxTableProd.maxDiagonalLeftProd()).isEqualTo(97)
        assertThat(maxTableProd.maxDiagonalRightProd()).isEqualTo(97)
    }

    @Test
    fun `2x2, 2`() {
        val maxTableProd = MaxTableProd(2, """
                97 91
                28 42
        """)

        assertThat(maxTableProd.maxHorizontalProd()).isEqualTo(97*91)
        assertThat(maxTableProd.maxVerticalProd()).isEqualTo(91*42)
        assertThat(maxTableProd.maxDiagonalLeftProd()).isEqualTo(97*42)
        assertThat(maxTableProd.maxDiagonalRightProd()).isEqualTo(91*28)
    }

    @Test
    fun `2x3, 2`() {
        val maxTableProd = MaxTableProd(2, """
                97 91
                28 42
                77 12
        """)

        assertThat(maxTableProd.maxHorizontalProd()).isEqualTo(97*91)
        assertThat(maxTableProd.maxVerticalProd()).isEqualTo(91*42)
        assertThat(maxTableProd.maxDiagonalLeftProd()).isEqualTo(97*42)
        assertThat(maxTableProd.maxDiagonalRightProd()).isEqualTo(42*77)
    }

    @Test
    fun `19x20, 4`() {
        val maxTableProd = MaxTableProd(4, """
                97 91 11 86 27 04 99 29 99 64 92 94 96 67 41 01 49 66 80
                28 28 88 29 06 70 07 46 59 76 06 29 87 22 58 27 92 45 51
                70 28 20 62 44 68 02 18 82 60 29 56 42 77 29 92 28 02 25
                41 69 84 12 92 59 00 21 58 12 57 45 90 21 45 60 26 91 25
                11 20 05 60 40 56 52 78 20 81 25 42 11 29 29 17 55 22 02
                12 26 21 59 88 92 24 91 22 64 22 42 67 25 72 19 24 06 01
                21 87 70 17 52 12 56 09 15 27 29 56 48 42 69 55 07 27 52
                56 15 19 57 91 51 01 19 84 52 82 28 52 97 29 80 55 28 82
                12 44 47 94 55 62 88 15 86 06 67 67 85 72 02 77 22 78 52
                10 25 12 98 64 99 65 22 19 24 24 02 99 50 22 86 22 20 22
                67 06 42 17 11 64 20 56 04 82 92 79 92 51 05 02 98 42 45
                05 28 94 21 85 24 20 26 44 47 77 12 99 06 42 12 25 18 74
                75 45 99 27 24 60 78 96 94 22 22 26 22 59 10 47 40 42 06
                08 79 70 57 94 82 26 58 17 62 81 02 75 41 06 66 92 78 44
                92 41 97 72 86 24 88 05 96 86 46 21 05 15 15 68 22 16 87
                77 25 57 76 46 51 19 61 92 25 22 56 25 44 01 21 52 82 42
                92 21 05 62 27 14 28 00 12 82 61 07 97 25 18 21 29 51 65
                19 58 25 20 61 29 12 77 22 51 88 58 71 56 48 74 62 92 25
                19 62 24 18 67 20 89 90 62 20 28 60 27 75 70 05 12 46 94
                90 69 42 60 72 40 42 58 05 81 22 27 50 22 41 90 78 08 56
        """)

        assertThat(maxTableProd.maxHorizontalProd()).isEqualTo(55623936)
        assertThat(maxTableProd.maxVerticalProd()).isEqualTo(76643820)
        assertThat(maxTableProd.maxDiagonalLeftProd()).isEqualTo(45677632)
        assertThat(maxTableProd.maxDiagonalRightProd()).isEqualTo(43359624)
    }
}
