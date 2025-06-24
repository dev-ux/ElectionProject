package com.voting.controller;

import com.voting.model.Voter;
import com.voting.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class VoterController {
    @Autowired
    private VoterService voterService;

    @GetMapping
    public ResponseEntity<List<Voter>> getAllVoters() {
        return ResponseEntity.ok(voterService.getAllVoters());
    }

    @PostMapping("/{id}/vote")
    public ResponseEntity<Voter> markVoterAsVoted(@PathVariable Long id) {
        return ResponseEntity.ok(voterService.markVoterAsVoted(id));
    }
}
