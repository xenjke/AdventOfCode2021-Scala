package DailyTasks

import Helpers.GetInput

case class Day3(session: String) {
  val dayNumber = 3
  val input: Array[String] = GetInput(session).forDayArray(dayNumber)

  def inputMatrix(input: Array[String]): Array[Array[String]] = {
    input.map(e => e.split(""))
  }

  /**
   * @param array Array of same-length rows
   * @return
   * Takes the array of rows and returns array of columns instead
   * Hoping all rows are equal length
   */
  def invertArrayMap(array: Array[Array[String]]): Array[Array[String]] = {
    val out: Array[Array[String]] = Array.ofDim(array.head.length, 0)

    array.zipWithIndex.foreach { case (row, _) =>
      for (colNum <- 0 until row.length - 1) {
        out(colNum) = out(colNum) :+ row(colNum)
      }
    }
    out
  }

  def findMostCommonInBinary(binaryString: String): Int = {
    val (zeroes, ones) = binaryString.partition(_ == '0')
    if (zeroes.length > ones.length) 0 else 1
  }

  def findLeastCommonInBinary(binaryString: String): Int = {
    val (zeroes, ones) = binaryString.partition(_ == '0')
    if (zeroes.length > ones.length) 1 else 0
  }

  def partOne(): Int = {
    var gammaRate, epsilonRate: Int = 0

    val invertedInput = invertArrayMap(inputMatrix(input)).map(e => e.mkString(""))

    val gammaRateBits = invertedInput.map(e => findMostCommonInBinary(e)).mkString("")
    val epsilonRateBits = invertedInput.map(e => findLeastCommonInBinary(e)).mkString("")
    gammaRate = Integer.parseInt(gammaRateBits, 2)
    epsilonRate = Integer.parseInt(epsilonRateBits, 2)

    gammaRate * epsilonRate
  }

  def partTwo(): Int = {
    val gammaRate, epsilonRate: Int = 0


    gammaRate * epsilonRate
  }

}
