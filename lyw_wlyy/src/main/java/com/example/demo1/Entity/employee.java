package com.example.demo1.Entity;
        import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest;

        import javax.persistence.*;
        import java.io.Serializable;
@Entity
@Table(name="employee")
public class employee implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "idemployee")
    private String idemployee;

    @Column(name="nameEm")
    private String nameEm;

    @Column(name="jobEm")
    private String jobEm;

    @Column(name="salary")
    private String salary;

    @Column(name="workYear")
    private String workYear;
    String getIdemployee(){return idemployee;}
    String getNameEm(){return nameEm;}
    String getJobEm(){return jobEm;}
    String getSalary(){return salary;}
    String getWorkYear(){return workYear;}
}
