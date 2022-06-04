package escortbook.escortbookstatistics.services;

import escortbook.escortbookstatistics.models.CustomerStatistics;
import escortbook.escortbookstatistics.repositories.ICustomerStatisticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerStatisticsService implements ICustomerStatisticsService {

    @Autowired
    private ICustomerStatisticsRepository customerStatisticsRepository;

    public List<CustomerStatistics> findAll() {
        return customerStatisticsRepository.findAll();
    }
}
