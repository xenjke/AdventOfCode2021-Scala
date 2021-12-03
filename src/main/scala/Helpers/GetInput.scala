

package Helpers {

  import scalaj.http.Http

  case class GetInput(session: String) {

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

