package models.sports

import java.sql.Date

import slick.driver.MySQLDriver.api._
import slick.profile.SqlProfile.ColumnOption.SqlType


object Sports {
  case class Sport(id: Long, name: String)

  class SportTableDef(tag: Tag) extends Table[Sport](tag, "sports_sport") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def createdAt = column[Date]("created_at", SqlType("timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP"))

    override def * = (id, name) <> (Sport.tupled, Sport.unapply)
  }

  val sports = TableQuery[SportTableDef]

  case class SportSkill(id: Long, name: String, sportId: Long)

  class SportSkillTableDef(tag: Tag) extends Table[SportSkill](tag, "sports_sportskill") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def sportId = column[Long]("sport_id")
    def createdAt = column[Date]("created_at", SqlType("timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP"))

    def sport = foreignKey("SP_FK", sportId, Sports.sports)(_.id)

    override def * = (id, name, sportId) <> (SportSkill.tupled, SportSkill.unapply)
  }


  case class SportWeightCategory(id: Long, name: String, sportId: Long)

  class SportWeightCategoryTableDef(tag: Tag) extends Table[SportWeightCategory](tag, "sports_sportweightcategory") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def sportId = column[Long]("sport_id")
    def minWeight = column[Long]("weight_min")
    def maxWeight = column[Long]("weight_max")
    def createdAt = column[Date]("created_at", SqlType("timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP"))

    def sport = foreignKey("SP_FK", sportId, Sports.sports)(_.id)

    override def * = (id, name, sportId) <> (SportWeightCategory.tupled, SportWeightCategory.unapply)
  }
}

