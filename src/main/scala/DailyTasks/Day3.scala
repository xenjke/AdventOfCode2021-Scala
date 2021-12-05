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

  def findRating(input: Array[String], rating: String): Int = {
    var break = false
    var foundRating = ""
    var inputClone = input.clone()

    // for each byte in a row
    var currentBytePosition = 0
    // keep picking next byte until rating found or EOF
    while (!break || (currentBytePosition < input.head.length - 1)) {
      // aggregate in to a column
      var currentByteRow = ""
      inputClone.foreach(i => {
        // each row's respective byte
        currentByteRow = currentByteRow + i.charAt(currentBytePosition)
      })
      // determine what is the most common byte of the column, 0 or 1
      val (zeroes, ones) = currentByteRow.partition(_ == '0')
      val mostCommon = if (zeroes.length > ones.length) '0' else '1'

      // based on the most common, leave respective rows in
      // or filter them out
      inputClone = inputClone.filter(e => {
        rating match {
          case "oxygen" =>
            // If 0 and 1 are equally common, keep values with a 1 in the position being considered
            if (zeroes.length == ones.length) {
              e.charAt(currentBytePosition) == '1'
            } else {
              e.charAt(currentBytePosition) == mostCommon
            }
          case "co2" =>
            // If 0 and 1 are equally common, keep values with a 0 in the position being considered.
            if (zeroes.length == ones.length) {
              e.charAt(currentBytePosition) == '0'
            } else {
              e.charAt(currentBytePosition) != mostCommon
            }
        }
      })

      // check if there is anything left
      if (inputClone.length == 1) {
        foundRating = inputClone.head
        break = true
      }

      // check the next one
      currentBytePosition += 1
    }

    Integer.parseInt(foundRating, 2)
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
    var oxygenGeneratorRating, co2ScrubberRating: Int = 0

    oxygenGeneratorRating = findRating(input, "oxygen")
    co2ScrubberRating = findRating(input, "co2")

    oxygenGeneratorRating * co2ScrubberRating
  }

}
