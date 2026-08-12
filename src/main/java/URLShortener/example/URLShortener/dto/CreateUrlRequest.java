package URLShortener.example.URLShortener.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CreateUrlRequest {

    @NotBlank
    @Pattern(
            regexp = "^https?://.+$",
            message = "longUrl must be a valid HTTP / HTTPS format"
    )
    private String longUrl ;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
