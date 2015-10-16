scalaVersion := "2.11.7"

name := "Async Debugger Demo"

libraryDependencies ++= Seq(
          "com.typesafe.akka" %% "akka-actor" % "2.4.0",
          "com.typesafe.akka" %% "akka-slf4j" % "2.4.0",
          "ch.qos.logback" % "logback-classic" % "1.1.2"
)

