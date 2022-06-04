package escortbook.escortbookstatistics.models;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "customer_statistics")
public class CustomerStatistics {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "services")
    private int services;

}
