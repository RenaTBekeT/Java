package com.example.INIZIO_TEST_3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "finder";
    }
    @PostMapping("/search")
    public String search(@RequestParam("searchQuery") String searchQuery,
                         @RequestParam("filePath") String filePath) throws IOException {
        if(isNullOrEmpty(searchQuery) || isNullOrEmpty(filePath)) {
            return "error";
        }
        doScraping(searchQuery, filePath);
        return "success";
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private void doScraping(String searchQuery, String filePath) throws IOException {
        List<String> results = new ArrayList<>();
        final Document document = Jsoup.connect("http://www.google.com/search?q=" + searchQuery).get();

        System.out.println(document.toString());

        for (Element row : document.select("h3")) {
            final String title = row.text();
            results.add(title);
        }
        writeToFile(results, filePath);
    }

    private void writeToFile(List<String> results, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for(String str: results) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}