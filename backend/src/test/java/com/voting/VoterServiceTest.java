package com.voting;

import com.voting.model.Voter;
import com.voting.repository.VoterRepository;
import com.voting.service.VoterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VoterServiceTest {

    @Mock
    private VoterRepository voterRepository;

    @InjectMocks
    private VoterService voterService;

    @Test
    void shouldMarkVoterAsVoted() {
        // Arrange
        Voter voter = new Voter();
        voter.setId(1L);
        voter.setFirstName("John");
        voter.setLastName("Doe");
        voter.setBirthDate(LocalDate.now());
        voter.setHasVoted(false);

        when(voterRepository.findById(1L)).thenReturn(Optional.of(voter));
        when(voterRepository.save(voter)).thenReturn(voter);

        // Act
        Voter result = voterService.markVoterAsVoted(1L);

        // Assert
        assertTrue(result.isHasVoted());
        verify(voterRepository).save(voter);
    }

    @Test
    void shouldThrowExceptionWhenVoterNotFound() {
        // Arrange
        when(voterRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            voterService.markVoterAsVoted(1L);
        });
    }
}