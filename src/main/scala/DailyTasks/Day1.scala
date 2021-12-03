package DailyTasks

import Helpers.GetInput

case class Day1(session: String) {
  val dayNumber = 1
  val input: Array[String] = GetInput(session).forDayArray(dayNumber)

  def partOne(): Int = {
    var increases: Int = 0
    var base = input.head.toInt

    input.foreach(value => {
      if (value.toInt > base) increases += 1
      base = value.toInt
    })

    increases
  }

  def partTwo(): Int = {
    var base = 0
    var timesBigger: Int = 0

    input.zipWithIndex.foreach { case (elem, idx) =>
      if (idx + 2 > input.length - 1) {
        // no 3rd element to fetch, nothing
      } else {
        val sum: Int = elem.toInt + input(idx + 1).toInt + input(idx + 2).toInt
        if (base != 0 && sum > base) {
          timesBigger += 1
        }
        base = sum
      }
    }

    timesBigger
  }
}
