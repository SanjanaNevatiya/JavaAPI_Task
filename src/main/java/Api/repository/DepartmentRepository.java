package Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
