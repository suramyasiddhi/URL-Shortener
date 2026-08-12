package URLShortener.example.URLShortener.controller;

import URLShortener.example.URLShortener.dto.CreateUrlRequest;
import URLShortener.example.URLShortener.service.UrlMappingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
public class UrlMappingController {

    private final UrlMappingService service ;

    public UrlMappingController(UrlMappingService service){
        this.service = service ;
    }

    @PostMapping
    public String shortenUrl(@Valid @RequestBody CreateUrlRequest request){
        return service.shortenUrl(request.getLongUrl()) ;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String longUrl = service.getLongUrl(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }

}
