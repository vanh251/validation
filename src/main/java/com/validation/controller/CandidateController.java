package com.validation.controller;

import com.validation.dto.ApiResponse;
import com.validation.dto.CandidateCreateDTO;
import com.validation.model.Candidate;
import com.validation.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Candidate>> registerCandidate(@Valid @RequestBody CandidateCreateDTO candidateDTO) {
        Candidate savedCandidate = candidateService.createCandidate(candidateDTO);

        ApiResponse<Candidate> response = new ApiResponse<>(
                "success",
                "Đăng ký ứng viên thành công",
                savedCandidate
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}