package escortbook.escortbookstatistics.repositories;

import escortbook.escortbookstatistics.models.CustomerStatistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerStatisticsRepository extends JpaRepository<CustomerStatistics, String> {}
