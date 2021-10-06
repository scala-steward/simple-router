addSbtPlugin("org.scala-js"                             % "sbt-scalajs"              % "1.7.1")
addSbtPlugin("org.portable-scala"                       % "sbt-scalajs-crossproject" % "1.1.0")
addSbtPlugin("com.github.sbt"                           % "sbt-ci-release"           % "1.5.9")
addSbtPlugin("com.codecommit"                           % "sbt-github-actions"       % "0.13.0")
libraryDependencies += "io.github.nafg.mergify"        %% "mergify-writer"           % "0.2.1"
libraryDependencies += "io.github.nafg.scalac-options" %% "scalac-options"           % "0.1.7"
