package escortbook.escortbookstatistics.controllers;

import escortbook.escortbookstatistics.models.CustomerStatistics;
import escortbook.escortbookstatistics.services.ICustomerStatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer-statistics")
public class CustomerStatisticsController {

    @Autowired
    private ICustomerStatisticsService customerStatisticsService;
    
    @GetMapping
    public List<CustomerStatistics> findAll() {
        return customerStatisticsService.findAll();
    }

}
