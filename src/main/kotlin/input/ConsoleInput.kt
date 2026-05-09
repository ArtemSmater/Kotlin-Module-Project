package input

import utils.StringPatterns
import java.util.Scanner

class ConsoleInput {
    companion object {
        fun getNumberAnswer(range: Int): Int {
            val scanner = Scanner(System.`in`)
            if (!scanner.hasNextInt()) {
                showError(StringPatterns.TYPE_ERROR)
                return -1
            }
            val input = scanner.nextLine().toInt()
            return if (!checkValue(range, input)) -1
            else input

        }

        fun getStringAnswer(): String {
            val scanner = Scanner(System.`in`)
            val input = scanner.nextLine().trim()
            if (input.isEmpty()) {
                showError(StringPatterns.EMPTY_ERROR)
                return ""
            } else {
                return input
            }
        }

        private fun checkValue(range: Int, input: Int): Boolean {
            return if (input >= range) {
                showError(StringPatterns.RANGE_ERROR)
                false
            } else true
        }

        private fun showError(message: String) {
            println(message)
        }
    }
}