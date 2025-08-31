package org.cross.medicore.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.cross.medicore.dto.ReportRequestDto;
import org.cross.medicore.dto.ReportResponseDto;
import org.cross.medicore.mapper.ReportMapper;
import org.cross.medicore.model.Report;
import org.cross.medicore.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reports")
@Data
public class ReportController {
    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ReportResponseDto>>> getAllReports(){
        ApiResponse<List<ReportResponseDto>> apiResponse = new ApiResponse<>();

        apiResponse.setMessage("Reports Fetched");
        apiResponse.setSuccess(true);

        List<ReportResponseDto> dtos = reportService.getAllReports().stream()
                .map(ReportMapper::toDto)
                .toList();


        apiResponse.setData(dtos);

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<ReportResponseDto>> createReport(@RequestBody ReportRequestDto dto){
        ApiResponse<ReportResponseDto> apiResponse = new ApiResponse<>();

        Report createdReport = reportService.createNewReport(dto);

        apiResponse.setData(ReportMapper.toDto(createdReport));
        apiResponse.setMessage("Report Created");
        apiResponse.setSuccess(true);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<ApiResponse<List<ReportResponseDto>>> createReport(@PathVariable UUID patientId){
        ApiResponse<List<ReportResponseDto>> apiResponse = new ApiResponse<>();

        List<Report> receipts = reportService.getAllReportsForPatient(patientId);

        List<ReportResponseDto> dtos = receipts.stream()
                .map(ReportMapper::toDto)
                .toList();

        apiResponse.setData(dtos);
        apiResponse.setMessage("Reports Fetched");
        apiResponse.setSuccess(true);

        return ResponseEntity.ok(apiResponse);
    }
}
