val sjsVer = sys.env.getOrElse("SCALAJS_VERSION", "1.1.1")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % sjsVer)

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.1.1")
