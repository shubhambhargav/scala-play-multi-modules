package models.clubs

import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._
import scala.concurrent.Future
import play.api.db.slick.DatabaseConfigProvider
import play.api.Play


object Clubs{
  case class Club(id: Long, name: String, location: String)

  class ClubTableDef(tag: Tag) extends Table[Club](tag, "clubs_club") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def location = column[String]("location")

    override def * = (id, name, location) <> (Club.tupled, Club.unapply)
  }

  val clubs = TableQuery[ClubTableDef]
  val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def get(id: Long): Future[Option[Club]] = {
    dbConfig.db.run(clubs.filter(_.id === id).result.headOption)
  }
}


