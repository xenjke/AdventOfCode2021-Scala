package DailyTasks

import Helpers.GetInput

case object Day1 {
  def task(session: String = ""): Int = {
    val day1Input = GetInput(session).forDayArray(1)

    var increases: Int = 0
    var base = day1Input.head.toInt

    day1Input.foreach(value => {
      if (value.toInt > base) increases = increases + 1
      base = value.toInt
    })

    increases
  }
}
