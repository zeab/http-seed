package zeab.httpseed

//Imports
import zeab.httpseed.HttpMethods.get

case class HttpSeed(
                     url: String,
                     method: String = get,
                     body: String = "",
                     headers: Map[String, String] = Map.empty,
                     metaData: Map[String, String] = Map.empty
                   )
