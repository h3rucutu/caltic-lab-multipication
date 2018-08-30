package id.co.caltic.lab.service.impl;

import id.co.caltic.lab.domain.Multiplication;
import id.co.caltic.lab.domain.MultiplicationResultAttempt;
import id.co.caltic.lab.service.MultiplicationService;
import id.co.caltic.lab.service.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;

    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
        return resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA() *
                resultAttempt.getMultiplication().getFactorB();
    }
}
