package groupB.newbankV5.paymentprocessor.controllers;

import groupB.newbankV5.paymentprocessor.connectors.TransactionProxy;
import groupB.newbankV5.paymentprocessor.controllers.dto.TransferDto;
import groupB.newbankV5.paymentprocessor.controllers.dto.TransferResponseDto;
import groupB.newbankV5.paymentprocessor.entities.Transaction;
import groupB.newbankV5.paymentprocessor.interfaces.ITransactionProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = TransferController.BASE_URI, produces = APPLICATION_JSON_VALUE)

public class TransferController {
    private static final Logger log = Logger.getLogger(TransferController.class.getName());
    private final ITransactionProcessor transactionProcessor;


    public static final String BASE_URI = "/api/transfer";

    public TransferController(ITransactionProcessor transactionProcessor,
                              TransactionProxy transactionProxy) {
        this.transactionProcessor = transactionProcessor;
    }


    @PostMapping("/process")
    public ResponseEntity<TransferResponseDto> processPayment(@RequestBody TransferDto transferDto) {
        log.info("\u001B[32mProcessing transfer\u001B[0m");
        return ResponseEntity.status(HttpStatus.OK).body(transactionProcessor.authorizeTransfer(transferDto));

    }


}