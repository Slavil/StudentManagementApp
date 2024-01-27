package net.javaguides.sms.entity;

import javax.persistence.*;

@Entity
@Table(name = "studentsClasses")
public class StudentsClass {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Column(name = "className", nullable = false)
    private String className;
}
