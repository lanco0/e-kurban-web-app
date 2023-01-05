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

    /**
     * Sms servisi için kullanılan twillio.com sitesinin verdiği yetkielendirme anahtarları
     */
    public static final String ACCOUNT_SID = "AC05550591f3678dc5026502a3f57baac5";
    public static final String AUTH_TOKEN = "bbd8caa37d57656f69c7966a995afb0b";

    @GetMapping("/sendSMS")
    public ResponseEntity<String> sendSMS() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message.creator(new PhoneNumber("+905358594652"),
                new PhoneNumber("+19787363461"), "Kurban kesildi 📞").create();

        return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
    }

}
