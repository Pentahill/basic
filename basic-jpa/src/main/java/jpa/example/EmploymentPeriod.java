package jpa.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class EmploymentPeriod {

    @Column
    Date startDate;

    Date endDate;
}
