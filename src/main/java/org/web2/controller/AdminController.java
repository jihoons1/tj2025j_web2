package org.web2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard( ) {
        return "관리자 api 성공";
    }
}
