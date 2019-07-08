package zeab.httpseed

case class HttpError(
                      timestamp: String,
                      requestUrl: String,
                      requestMethod: String,
                      requestBody: String,
                      requestHeaders: Map[String, String],
                      requestMetaData: Map[String, String],
                      error: String,
                      durationInMs: Long
                    )
