package URLShortener.example.URLShortener.service;

import URLShortener.example.URLShortener.entity.UrlMapping;
import URLShortener.example.URLShortener.repository.UrlMappingRepository;
import URLShortener.example.URLShortener.util.ShortCodeGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlMappingService {

    private final UrlMappingRepository repository ;
    private final ShortCodeGenerator generator ;

    public UrlMappingService(UrlMappingRepository repository, ShortCodeGenerator generator){
        this.repository = repository ;
        this.generator = generator ;
    }

    public String shortenUrl(String longUrl){
        String shortCode =  generator.generate();

        while(repository.existsByShortCode(shortCode)){
            shortCode =  generator.generate();
        }

        UrlMapping mapping = new UrlMapping() ;
        mapping.setLongURL(longUrl);
        mapping.setShortCode(shortCode);
        repository.save(mapping) ;

        return "http://localhost:8080/" + shortCode;
    }

    public String getLongUrl(String shortCode){
        Optional<UrlMapping> mapping = repository.findByShortCode(shortCode) ;

        return mapping.orElseThrow().getLongUrl() ;
    }

}
