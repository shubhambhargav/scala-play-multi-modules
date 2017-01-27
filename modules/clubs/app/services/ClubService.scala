package services.clubs


import models.clubs.Clubs
import scala.concurrent.Future


object ClubService {
  def getClub(id: Long): Future[Option[Clubs.Club]] = {
    Clubs.get(id)
  }
}

