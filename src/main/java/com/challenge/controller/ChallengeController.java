package com.challenge.controller;

import com.challenge.model.PolishExpressions;
import com.challenge.service.ExpressionService;
import com.challenge.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class ChallengeController {

    private final ExpressionService expressionService = new ExpressionService();

    @PostMapping(value = "/calculatePolishExpression")
    public ResponseEntity<List<String>> calculatePolishExpression(@RequestBody PolishExpressions polishExpressions) {
        log.debug("received calculatePolishExpression request");
        ValidatorUtil.validateIncomingParameters(polishExpressions);
        List<String> results = polishExpressions.getExpressions().stream()
                .map(expressionService::processExpression)
                .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}