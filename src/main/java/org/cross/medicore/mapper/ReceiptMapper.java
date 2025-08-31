package org.cross.medicore.mapper;

import org.cross.medicore.dto.ReceiptRequestDto;
import org.cross.medicore.dto.ReceiptResponseDto;
import org.cross.medicore.model.DocumentType;
import org.cross.medicore.model.Receipt;

import java.time.LocalDateTime;

public class ReceiptMapper {
    public static Receipt toModel(ReceiptRequestDto dto){
        Receipt receipt = new Receipt();

        receipt.setDiscount(dto.getDiscount());
        receipt.setServices(dto.getServices());
        receipt.setPatientId(dto.getPatientId());
        receipt.setStaffId(dto.getDoctorId());

        receipt.setIssueDateAndTime(LocalDateTime.now());
        receipt.setType(DocumentType.RECEIPT);

        return receipt;
    }

    public static ReceiptResponseDto toDto(Receipt receipt){
        ReceiptResponseDto dto = new ReceiptResponseDto();

        dto.setId(receipt.getId());
        dto.setPatientId(receipt.getPatientId());
        dto.setStaffId(receipt.getStaffId());
        dto.setServices(receipt.getServices());
        dto.setNetBill(receipt.getNetBillingAmount());
        dto.setIssueDateAndTime(receipt.getIssueDateAndTime());

        return dto;
    }
}
