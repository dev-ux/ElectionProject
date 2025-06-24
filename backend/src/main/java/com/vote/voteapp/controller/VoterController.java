package com.vote.voteapp.controller;

import com.vote.voteapp.model.Voter;
import com.vote.voteapp.service.VoterService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @GetMapping("/voters")
    public ResponseEntity<List<Voter>> getAllVoters() {
        List<Voter> voters = voterService.getAllVoters();
        return ResponseEntity.ok(voters);
    }

    @PostMapping("/voters/{id}/vote")
    @Transactional
    public ResponseEntity<Voter> registerVote(@PathVariable Long id) {
        Optional<Voter> voter = voterService.registerVote(id);
        return voter.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/voters")
    @Transactional
    public ResponseEntity<Voter> createVoter(@RequestBody Voter voter) {
        Voter savedVoter = voterService.saveVoter(voter);
        return ResponseEntity.ok(savedVoter);
    }
}
