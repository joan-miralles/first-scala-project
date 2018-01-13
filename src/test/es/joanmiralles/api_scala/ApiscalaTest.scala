package es.joanmiralles.api_scala

import org.scalatest._
import org.scalatest.Matchers._

final class ApiscalaTest extends WordSpec with GivenWhenThen {
  "Apiscala" should {
    "greet" in {
      Given("a Apiscala")

      val apiscala = new Apiscala

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting = apiscala.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
