package com.voting.service;

import com.voting.model.Voter;
import com.voting.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoterService {
    @Autowired
    private VoterRepository voterRepository;

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Transactional
    public Voter markVoterAsVoted(Long id) {
        Voter voter = voterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voter not found"));
        
        if (voter.isHasVoted()) {
            throw new RuntimeException("Voter has already voted");
        }

        voter.setHasVoted(true);
        return voterRepository.save(voter);
    }
}
