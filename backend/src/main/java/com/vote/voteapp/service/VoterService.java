package com.vote.voteapp.service;

import com.vote.voteapp.model.Voter;
import com.vote.voteapp.repository.VoterRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Transactional
    public Voter saveVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    @Transactional
    public Optional<Voter> registerVote(Long voterId) {
        Optional<Voter> optionalVoter = voterRepository.findById(voterId);
        if (optionalVoter.isPresent()) {
            Voter voter = optionalVoter.get();
            if (!voter.isHasVoted()) {
                voter.setHasVoted(true);
                return Optional.of(voterRepository.save(voter));
            }
        }
        return Optional.empty();
    }
}
