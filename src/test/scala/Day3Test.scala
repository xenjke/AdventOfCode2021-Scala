import DailyTasks.Day3
import org.scalatest.funsuite.AsyncFunSuite

class Day3Test extends AsyncFunSuite {
  val cookieSession: String = "53616c7465645f5f102d8c3ffa52456929acd5fb2d6cd25d89cff1a6bc399e247dcce7d09e89f6f0ec869e485948e5f3"
  val day3: Day3 = Day3(cookieSession)

  test("part one") {
    assert(day3.partOne() === 2261546)
  }

  test("part two") {
    assert(day3.partTwo() === 0)
  }
}
