package org.cross.medicore.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cross.medicore.dto.ReportRequestDto;
import org.cross.medicore.mapper.ReportMapper;
import org.cross.medicore.model.Report;
import org.cross.medicore.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
public class ReportService {
    private ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> getAllReports(){
        return reportRepository.findAll();
    }

    public Report createNewReport(ReportRequestDto dto){
        Report createdReport = ReportMapper.toModel(dto);

        reportRepository.save(createdReport);

        return createdReport;
    }

    public List<Report> getAllReportsForPatient(UUID Id){
        return reportRepository.findAllByPatientId(Id);
    }
}
