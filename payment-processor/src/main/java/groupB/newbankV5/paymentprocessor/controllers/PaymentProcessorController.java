package groupB.newbankV5.paymentprocessor.controllers;

import groupB.newbankV5.paymentprocessor.controllers.dto.*;
import groupB.newbankV5.paymentprocessor.entities.Transaction;
import groupB.newbankV5.paymentprocessor.entities.TransactionStatus;
import groupB.newbankV5.paymentprocessor.interfaces.ITransactionProcessor;
import groupB.newbankV5.paymentprocessor.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(path = PaymentProcessorController.BASE_URI, produces = APPLICATION_JSON_VALUE)
public class PaymentProcessorController {
    private static final Logger log = Logger.getLogger(PaymentProcessorController.class.getName());
    public static final String BASE_URI = "/api/payment";

    private final ITransactionProcessor transactionProcessor;

    private final TransactionRepository transactionRepository;

    @Autowired
    public PaymentProcessorController(ITransactionProcessor transactionProcessor, TransactionRepository transactionRepository) {

        this.transactionProcessor = transactionProcessor;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentDetailsDTO paymentDetails) {
        log.info("Processing payment");
        return ResponseEntity.status(HttpStatus.OK).body(transactionProcessor.authorizePayment(paymentDetails));

    }

    @PostMapping("/checkCreditCard")
    public ResponseEntity<CreditCardResponseDto> checkCreditCard(@RequestBody CreditCardInformationDto creditCardInformationDto) {
        log.info("\u001B[32mReceived request to check credit card\u001B[0m");
        return ResponseEntity.status(HttpStatus.OK).body(transactionProcessor.validateCreditCard(creditCardInformationDto));

    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransactions() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.findAll());

    }


    @GetMapping("/transactions/failed")
    public ResponseEntity<List<Transaction>> getTransactionsFailed() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionRepository.findAll().stream().filter(t -> t.getStatus().equals(TransactionStatus.FAILED)).collect(Collectors.toList()));

    }

    @PostMapping("/batchSaveTransactions")
    public ResponseEntity<List<Transaction>> batchSaveTransactions(@RequestBody List<Transaction> transactions) {
        transactionRepository.saveAll(transactions);
        return ResponseEntity.status(HttpStatus.OK).body(transactions);

    }

    @PostMapping("/reserveFunds")
    public ResponseEntity<String> reserveFunds(@RequestBody TransactionDto transaction, @RequestParam double amount) {
        log.info("\u001B[34mReceived request to reserve funds\u001B[0m");
        log.info("\u001B[34mAmount: " + amount + "\u001B[0m");
        transaction.setAmount(amount);
        log.info("\u001B[34m" + transaction+ "\u001B[0m");
        Transaction transaction1 = TransactionDto.fromTransactionDto(transaction);
        transactionRepository.save(transaction1);
        String response = transactionProcessor.reserveFunds(transaction1);
        log.info("\u001B[34mFunds reserved\u001B[0m");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



}
