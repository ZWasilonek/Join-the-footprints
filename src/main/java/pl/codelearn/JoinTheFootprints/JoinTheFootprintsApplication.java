package pl.codelearn.JoinTheFootprints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.codelearn.JoinTheFootprints.controller.ExcursionController;

import java.io.File;

@SpringBootApplication
public class JoinTheFootprintsApplication extends SpringBootServletInitializer {

	private static Logger logger = LoggerFactory.getLogger(JoinTheFootprintsApplication.class);

	public static void main(String[] args) {
		new File(ExcursionController.uploadDirectory).mkdir();
		SpringApplication.run(JoinTheFootprintsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JoinTheFootprintsApplication.class);
	}

	//	@PostConstruct
//	public void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//	}

}
