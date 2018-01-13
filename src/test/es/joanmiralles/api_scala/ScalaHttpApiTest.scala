package es.joanmiralles.api_scala

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.server.Directives._

final class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
  private val routesWithPredefinedResponse =
    get {
      path("status") {
        complete(HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}"""))
      }
    }
  private val projectsRoute =
    get {
      path("projects") {
        complete(HttpEntity(ContentTypes.`application/json`, """[{"id":1,"name":"Project A"},{"id":2,"name":"Project B"}]"""))
      }
    }

  "ScalaHttpApi" should {
    "respond ok when status is requested" in {
      Get("/status") ~> routesWithPredefinedResponse ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }

    "respond with a list of two projects when projects is requested" in {
      Get("/projects") ~> projectsRoute ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """[{"id":1,"name":"Project A"},{"id":2,"name":"Project B"}]"""
      }
    }
  }
}
