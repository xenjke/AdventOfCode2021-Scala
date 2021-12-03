import org.scalatest.funsuite.AsyncFunSuite
import DailyTasks.Day1

class Day1Test extends AsyncFunSuite {
  val cookieSession: String = "53616c7465645f5f102d8c3ffa52456929acd5fb2d6cd25d89cff1a6bc399e247dcce7d09e89f6f0ec869e485948e5f3"
  val day1: Day1 = Day1(cookieSession)

  test("part one") {
    assert(day1.partOne() === 1502)
  }

  test("part two") {
    assert(day1.partTwo() === 1538)
  }
}
