import _root_.io.github.nafg.scalacoptions._

import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}

ThisBuild / organization       := "io.github.nafg.simple-router"
ThisBuild / crossScalaVersions := Seq("2.13.10", "3.2.1")
ThisBuild / scalaVersion       := (ThisBuild / crossScalaVersions).value.last
ThisBuild / scalacOptions ++=
  ScalacOptions.all(scalaVersion.value)(
    (opts: options.Common) => opts.deprecation ++ opts.unchecked ++ opts.feature,
    (opts: options.V2_13) => opts.Xsource("3"),
    (opts: options.V3) => opts.YkindProjector
  )

lazy val core =
  crossProject(JVMPlatform, JSPlatform).crossType(CrossType.Full)
    .in(file("."))
    .settings(
      name := "core",
      libraryDependencies ++=
        Seq(
          "org.scalatest"     %% "scalatest"       % "3.2.14"   % Test,
          "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test
        ) ++
          PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
            case Some((2, _)) => compilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
          }
    )
