package com.example.controller;

import com.example.model.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by AjmalCholassery on 5/10/17.
 */

@RestController
public class WebhookController {

    Logger logger = LoggerFactory.getLogger("WebHook");
    @PostMapping(path="/webhook")
    public String webhookCallBack(@RequestBody Field field){
        logger.info("Received " + field.getField());
        return field.getField();
    }

    @GetMapping(path="/webhook")
    public String webhookGetCallBack(
            @RequestParam("hub.mode") String hubMode,
            @RequestParam("hub.challenge") String hubChallenge,
            @RequestParam("hub.verify_token") String hubVerifyToken){

        if(hubVerifyToken.equals("ajmal_fb_webhook"))
            return hubChallenge;
        else
            return null;
    }

}
