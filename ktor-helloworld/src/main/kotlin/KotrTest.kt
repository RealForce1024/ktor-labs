import io.ktor.application.call
import io.ktor.application.log
import io.ktor.features.CallLogging
import io.ktor.http.ContentType
import io.ktor.request.ApplicationRequest
import io.ktor.request.uri
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.application.log.info("访问来了: " + call.request.uri)
                call.respondText("hello ktor", ContentType.Text.Plain)
            }

            get("/demo") {
                call.application.log.info("访问来了: " + call.request.uri)
                call.respondText("HELLO WORLD")
            }
        }
    }
    server.start(wait = true)
}


