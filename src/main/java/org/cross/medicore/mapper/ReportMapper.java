package org.cross.medicore.mapper;

import org.cross.medicore.dto.ReportRequestDto;
import org.cross.medicore.dto.ReportResponseDto;
import org.cross.medicore.model.Report;

import java.time.LocalDateTime;

public class ReportMapper {
    public static Report toModel(ReportRequestDto dto){
        Report report = new Report();

        report.setRemarks(dto.getRemarks());
        report.setVerdict(dto.getVerdict());
        report.setMedicationList(dto.getMedicationList());
        report.setSymptomList(dto.getSymptomList());
        report.setPatientId(dto.getPatientId());
        report.setStaffId(dto.getPatientId());
        report.setIssueDateAndTime(LocalDateTime.now());

        return report;
    }

    public static ReportResponseDto toDto(Report report){
        ReportResponseDto dto = new ReportResponseDto();

        dto.setRemarks(report.getRemarks());
        dto.setVerdict(report.getVerdict());
        dto.setSymptomList(report.getSymptomList());
        dto.setMedicationList(report.getMedicationList());
        dto.setPatientId(report.getPatientId());
        dto.setStaffId(report.getStaffId());
        dto.setIssueDateAndTime(report.getIssueDateAndTime());

        return dto;
    }
}
