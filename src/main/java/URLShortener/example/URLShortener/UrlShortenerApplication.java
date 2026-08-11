package URLShortener.example.URLShortener;

import URLShortener.example.URLShortener.entity.UrlMapping;
import URLShortener.example.URLShortener.service.UrlMappingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}
}
