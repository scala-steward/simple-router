addSbtPlugin("org.scala-js"           % "sbt-scalajs"                % "1.17.0")
addSbtPlugin("org.portable-scala"     % "sbt-scalajs-crossproject"   % "1.3.2")
addSbtPlugin("com.github.sbt"         % "sbt-ci-release"             % "1.9.1")
addSbtPlugin("io.github.nafg.mergify" % "sbt-mergify-github-actions" % "0.9.0")
libraryDependencies += "io.github.nafg.scalac-options" %% "scalac-options" % "0.3.0"
