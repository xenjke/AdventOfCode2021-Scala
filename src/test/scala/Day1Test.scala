import org.scalatest.funsuite.AsyncFunSuite
import DailyTasks.Day1

class Day1Test extends AsyncFunSuite {
  val cookieSession: String = "53616c7465645f5f102d8c3ffa52456929acd5fb2d6cd25d89cff1a6bc399e247dcce7d09e89f6f0ec869e485948e5f3"

  test("Day 1") {
    assert(Day1.task(cookieSession) === 1502)
  }
}
