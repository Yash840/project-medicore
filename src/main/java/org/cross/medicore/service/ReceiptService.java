package org.cross.medicore.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.cross.medicore.dto.ReceiptRequestDto;
import org.cross.medicore.mapper.ReceiptMapper;
import org.cross.medicore.model.Receipt;
import org.cross.medicore.repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Data
@Service
@AllArgsConstructor
public class ReceiptService {
    private ReceiptRepository receiptRepository;

    public List<Receipt> getAllReceipts(){
        return receiptRepository.findAll();
    }

    public Receipt createNewReceipt(ReceiptRequestDto dto){
        Receipt receipt = ReceiptMapper.toModel(dto);

        receiptRepository.save(receipt);

        return receipt;
    }

    public List<Receipt> getReceiptsForPatient(UUID Id){
        List<Receipt> receipts = receiptRepository.findAllByPatientId(Id);

        return receipts;
    }
}
