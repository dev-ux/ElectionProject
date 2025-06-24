package com.vote.voteapp.service;

import com.vote.voteapp.model.Voter;
import com.vote.voteapp.repository.VoterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VoterServiceTest {

    @Mock
    private VoterRepository voterRepository;

    @InjectMocks
    private VoterService voterService;

    private Voter testVoter;

    @BeforeEach
    void setUp() {
        testVoter = new Voter();
        testVoter.setId(1L);
        testVoter.setLastName("Test");
        testVoter.setFirstName("User");
        testVoter.setBirthDate(java.time.LocalDate.of(1990, 1, 1));
        testVoter.setHasVoted(false);
    }

    @Test
    void shouldGetAllVoters() {
        List<Voter> voters = new ArrayList<>();
        voters.add(testVoter);
        when(voterRepository.findAll()).thenReturn(voters);

        List<Voter> result = voterService.getAllVoters();
        assertEquals(1, result.size());
        assertEquals(testVoter, result.get(0));
    }

    @Test
    void shouldRegisterVote() {
        when(voterRepository.findById(1L)).thenReturn(Optional.of(testVoter));
        when(voterRepository.save(testVoter)).thenReturn(testVoter);

        Optional<Voter> result = voterService.registerVote(1L);
        assertTrue(result.isPresent());
        assertTrue(result.get().isHasVoted());
    }

    @Test
    void shouldNotRegisterVoteForNonExistingVoter() {
        when(voterRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<Voter> result = voterService.registerVote(999L);
        assertFalse(result.isPresent());
    }

    @Test
    void shouldNotRegisterVoteForAlreadyVotedVoter() {
        Voter alreadyVoted = new Voter();
        alreadyVoted.setId(1L);
        alreadyVoted.setHasVoted(true);
        when(voterRepository.findById(1L)).thenReturn(Optional.of(alreadyVoted));

        Optional<Voter> result = voterService.registerVote(1L);
        assertFalse(result.isPresent());
    }
}
