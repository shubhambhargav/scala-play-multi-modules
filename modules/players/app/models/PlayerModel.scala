package models.players

import java.sql.Date

import slick.driver.MySQLDriver.api.Table
import slick.profile.SqlProfile.ColumnOption.SqlType
import slick.lifted.TableQuery

import models.clubs.Clubs
import models.sports.Sports


object Players {
  case class Player(id: Long, name: String, clubId: Long)

  class PlayerTableDef(tag: Tag) extends Table[Player](tag, "players_player") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def clubId = column[Long]("club_id")
    def height = column[Float]("height") // in cms
    def weight = column[Float]("weight") // in kgs
    def createdAt = column[Date]("created_at", SqlType("timestamp default current_timestamp"))
    def updatedAt = column[Date]("updated_at", SqlType("timestamp default current_timestamp on update current_timestamp"))

    def club = foreignKey("CL_FK", clubId, Clubs.Club)(_.id)

    override def * = (id, name, clubId) <> (Player.tupled, Player.unapply)

    def club = foreignKey("clubs_club", clubId, Clubs)(_.id)
  }

  val players = TableQuery[PlayerTableDef]

  case class PlayerSport(id: Long, playerId: Long, sportId: Long)

  class PlayerSportTableDef(tag: Tag) extends Table[PlayerSport](tag, "players_playersport"){

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def playerId = column[Long]("player_id")
    def sportId = column[Long]("sport_id")
    def weightClassId = column[Long]("weight_class_id")
    def sportSkillId = column[Long]("sport_skill_id")

    def createdAt = column[Date]("created_at", SqlType("timestamp default current_timestamp"))
    def updatedAt = column[Date]("updated_at", SqlType("timestamp default current_timestamp on update current_timestamp"))

    def player = foreignKey("PL_FK", playerId, Players.players)(_.id)
    def sport = foreignKey("SP_FK", sportId, Sports.sports)(_.id)

    override def * = (id, playerId, sportId) <> (PlayerSport.tupled, PlayerSport.unapply)
  }

}



