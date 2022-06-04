package escortbook.escortbookstatistics.services;

import escortbook.escortbookstatistics.models.CustomerStatistics;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerStatisticsService {
    List<CustomerStatistics> findAll();
}
