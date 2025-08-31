package org.cross.medicore.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.dto.ReceiptRequestDto;
import org.cross.medicore.dto.ReceiptResponseDto;
import org.cross.medicore.mapper.ReceiptMapper;
import org.cross.medicore.model.Receipt;
import org.cross.medicore.repository.ReceiptRepository;
import org.cross.medicore.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Data
@RestController
@RequestMapping("/api/receipts")
public class ReceiptController {
    private ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService){
        this.receiptService = receiptService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ReceiptResponseDto>>> getAllReceipts(){
        ApiResponse<List<ReceiptResponseDto>> apiResponse = new ApiResponse<>();

        apiResponse.setMessage("Receipts Fetched");
        apiResponse.setSuccess(true);

        List<ReceiptResponseDto> dtos = receiptService.getAllReceipts().stream()
                        .map(ReceiptMapper::toDto)
                                .toList();


        apiResponse.setData(dtos);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<ReceiptResponseDto>> createReceipt(@RequestBody ReceiptRequestDto dto){
        ApiResponse<ReceiptResponseDto> apiResponse = new ApiResponse<>();

        Receipt createdReceipt = receiptService.createNewReceipt(dto);

        apiResponse.setData(ReceiptMapper.toDto(createdReceipt));
        apiResponse.setMessage("Receipt Created");
        apiResponse.setSuccess(true);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<ApiResponse<List<ReceiptResponseDto>>> createReceipt(@PathVariable UUID patientId){
        ApiResponse<List<ReceiptResponseDto>> apiResponse = new ApiResponse<>();

        List<Receipt> receipts = receiptService.getReceiptsForPatient(patientId);

        List<ReceiptResponseDto> dtos = receipts.stream()
                        .map(ReceiptMapper::toDto)
                                .toList();

        apiResponse.setData(dtos);
        apiResponse.setMessage("Receipts Fetched");
        apiResponse.setSuccess(true);

        return ResponseEntity.ok(apiResponse);
    }
}
