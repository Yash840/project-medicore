package org.cross.medicore.repository;

import org.cross.medicore.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<Staff, UUID> {
    Optional<Staff> findByStaffUserName(String userName);
    boolean existsByStaffUserName(String userName);
}
