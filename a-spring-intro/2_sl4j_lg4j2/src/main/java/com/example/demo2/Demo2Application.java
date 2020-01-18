package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*  MAVEN
By default, IntelliJ IDEA uses the
  native IntelliJ IDEA builder
to build a Maven project. It might be helpful if you
have a pure Java or a Kotlin project since IntelliJ IDEA supports the incremental build which significantly
speeds up the building process. However, if you have a configuration that changes the compilation on the fly,
or your build generates an artifact with a custom layout, then Maven would be preferable for the building process.
* */

@SpringBootApplication
public class Demo2Application {
	private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Demo2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);

		logger.trace(">>>>>>>> in main():Trace log message");
		logger.debug(">>>>>>>> in main():Debug log message");
		logger.info(">>>>>>>>  in main():Info log message");
		logger.warn(">>>>>>>>  in main():Warn log message");
		logger.error(">>>>>>>> in main():Error log message");

		System.out.println(logger.getClass()); // class org.apache.logging.slf4j.Log4jLogger

		System.out.printf("Demo2 uses:" +
				"%n logging (sl4j with log4j2 - really?!" +
				"%n log4j2-spring.xml file for setting logging options" +
				"%n logs/app.log file for logging");
	}
}
