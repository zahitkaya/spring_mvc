package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.FormatExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

@RestController
public class FormatController {
    @GetMapping("format")
    public FormatExample getDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.get2DigitYearStart();
        FormatExample formatExample=new FormatExample(date);
        return formatExample;
    }
}
