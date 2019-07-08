package zeab.httpseed

trait HttpContentTypes {
  val applicationJson: String = "application/json"
  val applicationXml: String = "application/xml"
  val textPlain: String = "text/plain"
  val textHtml: String = "text/html"
}

object HttpContentTypes extends HttpContentTypes
