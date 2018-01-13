/** ********* PROJECT INFO ******************/
name := "Scala HTTP API"
version := "1.0"

/** ********* PROJECT SETTINGS ******************/
Configuration.settings

/** ********* DEPENDENCIES *****************/
libraryDependencies ++= Dependencies.production
libraryDependencies ++= Dependencies.test

/** ********* COMMANDS ALIASES ******************/
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("f", "scalafmt") // Format all files according to ScalaFmt
addCommandAlias("ft", "scalafmtCheck") // Test if all files are formatted according to ScalaFmt

addCommandAlias("prep", ";c;tc;ft") // All the needed tasks before running the test
