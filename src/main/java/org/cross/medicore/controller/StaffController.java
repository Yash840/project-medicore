package org.cross.medicore.controller;

import org.cross.medicore.model.Staff;
import org.cross.medicore.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Staff>>> getAllStaff(){
        ApiResponse<List<Staff>> apiResponse = new ApiResponse<>("staff fetched", true, null);

        List<Staff> staffList = staffService.getStaff();
        apiResponse.setData(staffList);

        return new ResponseEntity<ApiResponse<List<Staff>>>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<ApiResponse<Staff>> getStaffByUserName(@PathVariable String userName){
        Staff staff = staffService.getStaffByUserName(userName);

        return new ResponseEntity<>(new ApiResponse<Staff>("Staff Fetched Successfully", true, staff), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Staff>> addStaff(@RequestBody Staff staff){
        ApiResponse<Staff> responseBody = new ApiResponse<>();

        Staff addedStaff = staffService.addStaff(staff);
        responseBody.setData(addedStaff);

        if(addedStaff == null){
            responseBody.setMessage("Error Occurred In Adding Staff");
            responseBody.setSuccess(false);
            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        responseBody.setMessage("Staff Created Successfully");
        responseBody.setSuccess(true);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @PatchMapping("/{userName}")
    public ResponseEntity<ApiResponse<Staff>> updateStaffDetails(@PathVariable String userName,@RequestBody Map<String, Object> updates){
        ApiResponse<Staff> apiResponse = new ApiResponse<>();

        try {
            Staff updatedStaff = staffService.updateStaffDetails(userName, updates);
            apiResponse.setMessage("Staff Details Updated");
            apiResponse.setSuccess(true);
            apiResponse.setData(updatedStaff);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
            apiResponse.setData(null);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<ApiResponse<Staff>> deleteStaff(@PathVariable String userName){
        ApiResponse<Staff> apiResponse = new ApiResponse<>();

        try {
            Staff deletedStaff = staffService.deleteStaff(userName);
            apiResponse.setMessage("Staff Deleted");
            apiResponse.setSuccess(true);
            apiResponse.setData(deletedStaff);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse.setMessage(e.getMessage());
            apiResponse.setSuccess(false);
            apiResponse.setData(null);
            return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
