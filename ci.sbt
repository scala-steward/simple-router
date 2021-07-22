val repoPath = "nafg/simple-router"
inThisBuild(List(
  homepage                := Some(url(s"https://github.com/$repoPath")),
  licenses                := List("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0")),
  developers              :=
    List(
      Developer("nafg", "Naftoli Gugenheim", "98384+nafg@users.noreply.github.com", url("https://github.com/nafg"))
    ),
  scmInfo                 :=
    Some(
      ScmInfo(
        browseUrl = url(s"https://github.com/$repoPath"),
        connection = s"scm:git:git://github.com/$repoPath.git",
        devConnection = Some(s"scm:git:git@github.com:$repoPath.git")
      )
    ),
  dynverGitDescribeOutput := dynverGitDescribeOutput.value.map(_.copy(dirtySuffix = sbtdynver.GitDirtySuffix(""))),
  dynverSonatypeSnapshots := true,
  githubWorkflowPublishTargetBranches := Seq(RefPredicate.StartsWith(Ref.Tag("v"))),
  githubWorkflowTargetTags            := Seq("v*"),
  githubWorkflowPublish               :=
    Seq(
      WorkflowStep.Sbt(
        List("ci-release"),
        env =
          Map(
            "PGP_PASSPHRASE"    -> "${{ secrets.PGP_PASSPHRASE }}",
            "PGP_SECRET"        -> "${{ secrets.PGP_SECRET }}",
            "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
            "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}"
          )
      )
    )
))

sonatypeProfileName := "io.github.nafg"
