package DailyTasks

import Helpers.GetInput

case class Day2(session: String) {
  val dayNumber = 2
  val input: Array[String] = GetInput(session).forDayArray(dayNumber)

  def partOne(): Int = {
    var horizontal, depth: Int = 0

    input.foreach(command => {
      val commandTuple = command.split(" ")
      val direction = commandTuple.head
      val distance = commandTuple.last.toInt

      direction match {
        case "forward" => horizontal += distance
        case "down" => depth += distance
        case "up" => depth -= distance
      }
    })

    horizontal * depth
  }

  def partTwo(): Int = {
    var horizontal, depth, aim: Int = 0

    input.foreach(command => {
      val commandTuple = command.split(" ")
      val direction = commandTuple.head
      val units = commandTuple.last.toInt

      direction match {
        case "forward" =>
          horizontal += units
          depth += aim * units
        case "down" => aim += units
        case "up" => aim -= units
      }
    })

    horizontal * depth
  }

}
