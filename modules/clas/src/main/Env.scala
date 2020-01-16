package lila.clas

import com.softwaremill.macwire._

import lila.common.config._

@Module
final class Env(
    db: lila.db.Db,
    userRepo: lila.user.UserRepo,
    lightUserAsync: lila.common.LightUser.Getter,
    securityForms: lila.security.DataForm
)(implicit ec: scala.concurrent.ExecutionContext) {

  lazy val forms = wire[ClasForm]

  private val colls = wire[ClasColls]

  lazy val api = wire[ClasApi]
}

private class ClasColls(db: lila.db.Db) {
  val teacher = db(CollName("clas_teacher"))
  val clas    = db(CollName("clas_clas"))
  val student = db(CollName("clas_student"))
}
