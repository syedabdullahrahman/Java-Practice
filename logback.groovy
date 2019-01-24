import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.classic.Level.DEBUG
import ch.qos.logback.classic.Level.INFO

appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
  }
}

logger("com.lordofthejars.foo", INFO)
root(DEBUG, ["STDOUT"])