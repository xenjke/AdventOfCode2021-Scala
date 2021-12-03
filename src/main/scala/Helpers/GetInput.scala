

package Helpers {

  import scalaj.http.Http

  case class GetInput(session: String = "53616c7465645f5f102d8c3ffa52456929acd5fb2d6cd25d89cff1a6bc399e247dcce7d09e89f6f0ec869e485948e5f3") {

    def forDayString(dayNumber: Int): String = {
      val baseUrl = "https://adventofcode.com/2021/day/" + dayNumber + "/input"
      val sessionCookieValue = "session=" + session
      val response = Http(baseUrl).headers(Seq("Cookie" -> sessionCookieValue)).asString
      if (response.code > 200) {
        throw new Error("%d code fetching input for day %d".format(response.code, dayNumber))
      } else {
        response.body
      }
    }

    def forDayArray(dayNumber: Int): Array[String] = {
      forDayString(dayNumber).split("\n")
    }

  }

}

