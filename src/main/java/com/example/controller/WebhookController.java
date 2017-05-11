package com.example.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by AjmalCholassery on 5/10/17.
 */

@RestController
public class WebhookController {


    @PostMapping(path="/webhook")
    public String webhookCallBack(@RequestBody String input){
        return null;
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
