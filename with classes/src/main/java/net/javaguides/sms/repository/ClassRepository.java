package net.javaguides.sms.repository;

import net.javaguides.sms.entity.StudentsClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<StudentsClass, Long> {
    // Additional custom queries if needed
}
