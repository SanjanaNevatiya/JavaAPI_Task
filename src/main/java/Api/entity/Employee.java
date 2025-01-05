package Api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employeeapi_tbl")
@Access(AccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, unique = true)
    public String email;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading with NO_PROXY
    @JoinColumn(name = "department_id", nullable = false)
    public Department department;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading with NO_PROXY
    @JoinColumn(name = "role_id", nullable = false)
    public Role role;

    public Employee() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
