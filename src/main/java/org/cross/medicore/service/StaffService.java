package org.cross.medicore.service;

import org.cross.medicore.model.Patient;
import org.cross.medicore.model.Staff;
import org.cross.medicore.repository.StaffRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StaffService {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    public List<Staff> getStaff(){
        return staffRepository.findAll();
    }

    public Staff getStaffByUserName(String userName){
        return staffRepository.findByStaffUserName(userName).orElse(null);
    }

    public String getStaffName(UUID staffId){
        try {
            Staff staff = staffRepository.findById(staffId).orElse(null);

            return staff.getName();
        } catch (NullPointerException e) {
            throw new RuntimeException("Invalid Staff UserName");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Staff addStaff(Staff staff){
        try{
            boolean isUserNameTaken = staffRepository.existsByStaffUserName(staff.getStaffUserName());

            if(isUserNameTaken) throw new RuntimeException("UserNameAlreadyTaken");

            return staffRepository.save(staff);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Staff updateStaffDetails(String userName, Map<String, Object> updates){
        try{
            Staff staff = staffRepository.findByStaffUserName(userName)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());

            updates.forEach((fieldName, value) -> {
                Field field = null;
                try{
                    field = Staff.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(staff, value);
                } catch (IllegalAccessException | NoSuchFieldException e){
                    throw new RuntimeException(e.getMessage());
                }
            });

            return staffRepository.save(staff);
        }catch (ChangeSetPersister.NotFoundException e){
            throw new RuntimeException("Invalid User Name");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Staff deleteStaff(String userName){
        try {
            Staff staff = staffRepository.findByStaffUserName(userName)
                    .orElseThrow(() ->new ChangeSetPersister.NotFoundException());

            staffRepository.delete(staff);
            return staff;
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException("Invalid User Name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
