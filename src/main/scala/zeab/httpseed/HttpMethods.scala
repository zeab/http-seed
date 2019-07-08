package zeab.httpseed

trait HttpMethods {
  val get: String = "GET"
  val put: String = "PUT"
  val post: String = "POST"
  val delete: String = "DELETE"
  val trace: String = "TRACE"
}

object HttpMethods extends HttpMethods