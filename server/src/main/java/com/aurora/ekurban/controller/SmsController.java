package com.aurora.ekurban.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class SmsController {

    @GetMapping("/sendSMS")
    public ResponseEntity<String> sendSMS() {
        Twilio.init("AC05550591f3678dc5026502a3f57baac5",
                "56ddfa49aaf5ee42a26566ea15fd05c5");

        Message.creator(new PhoneNumber("+905510106464"),
                new PhoneNumber("+19787363461"), "Hello from Twilio 📞").create();

        return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
    }

}
