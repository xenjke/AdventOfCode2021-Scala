import DailyTasks.Day2
import org.scalatest.funsuite.AsyncFunSuite

class Day2Test extends AsyncFunSuite {
  val cookieSession: String = "53616c7465645f5f102d8c3ffa52456929acd5fb2d6cd25d89cff1a6bc399e247dcce7d09e89f6f0ec869e485948e5f3"
  val day2: Day2 = Day2(cookieSession)

  test("part one") {
    assert(day2.partOne() === 1561344)
  }
}
