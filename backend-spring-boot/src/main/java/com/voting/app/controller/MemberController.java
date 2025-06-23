package com.voting.app.controller;

import com.voting.app.model.Member;
import com.voting.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membres")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @PostMapping("/{id}/vote")
    public ResponseEntity<Member> vote(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.vote(id));
    }
}
