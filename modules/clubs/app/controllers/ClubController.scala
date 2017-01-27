package controllers.clubs

import services.clubs.ClubService
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext.Implicits.global


class ClubController extends Controller {

  def findClub(id: Long) = Action.async {
    implicit request => {
      ClubService.getClub(id) map {
        club => {
          if(club == None){
            NotFound(Json.obj("error404" -> "Object not found!"))
          } else {
            Ok(Json.obj("id" -> club.get.id, "name" -> club.get.name, "location" -> club.get.location))
          }
        }
      }
    }
  }
}