package com.example.http2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http2ClientExample {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String body = HttpClient.create()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .request(new URI("url/get"))
                .body(HttpRequest.fromString("body"))
                .GET()
                .response()
                .body(HttpResponse.asString());

        System.out.println(body);

        String post = HttpClient.create()
                .version(HttpClient.Version.HTTP_2)
                .build()
                .request(new URI("url/post"))
                .body(HttpRequest.fromString("firstname=max,lastname=max"))
                .POST()
                .response()
                .body(HttpResponse.asString());

        System.out.println(post);
        System.out.println("Code Execution Completed");
    }
}
