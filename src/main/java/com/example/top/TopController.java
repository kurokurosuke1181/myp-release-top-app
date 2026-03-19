package com.example.top;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String top() {
        return """
                <!doctype html>
                <html lang=\"ja\">
                  <head>
                    <meta charset=\"utf-8\" />
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />
                    <title>Top</title>
                  </head>
                  <body>
                    <h1>Top</h1>
                    <p><a href=\"/a\">導線Aへ</a></p>
                  </body>
                </html>
                """;
    }
}
