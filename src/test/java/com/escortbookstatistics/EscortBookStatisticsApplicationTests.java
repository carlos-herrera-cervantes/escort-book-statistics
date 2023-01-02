package com.escortbookstatistics;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.escortbookstatistics.controllers.CityStatisticController;
import com.escortbookstatistics.controllers.CityUserActivityController;
import com.escortbookstatistics.controllers.CustomerStatisticController;
import com.escortbookstatistics.controllers.EscortStatisticController;
import com.escortbookstatistics.controllers.GeneralStatisticController;
import com.escortbookstatistics.controllers.GeneralUserActivityController;
import com.escortbookstatistics.controllers.PaymentCityStatisticController;
import com.escortbookstatistics.controllers.PaymentStateStatisticController;
import com.escortbookstatistics.controllers.PaymentStatisticController;
import com.escortbookstatistics.controllers.StateStatisticController;
import com.escortbookstatistics.controllers.StateUserActivityController;
import com.escortbookstatistics.controllers.TopCityController;
import com.escortbookstatistics.controllers.TopCityEscortController;
import com.escortbookstatistics.controllers.TopEscortController;
import com.escortbookstatistics.controllers.TopStateController;
import com.escortbookstatistics.controllers.TopStateEscortController;

@SpringBootTest
class EscortBookStatisticsApplicationTests {

	@Autowired
	private CityStatisticController cityStatisticController;

	@Autowired
	private CityUserActivityController cityUserActivityController;

	@Autowired
	private CustomerStatisticController customerStatisticController;

	@Autowired
	private EscortStatisticController escortStatisticController;

	@Autowired
	private GeneralStatisticController generalStatisticController;

	@Autowired
	private GeneralUserActivityController generalUserActivityController;

	@Autowired
	private PaymentCityStatisticController paymentCityStatisticController;

	@Autowired
	private PaymentStateStatisticController paymentStateStatisticController;

	@Autowired
	private PaymentStatisticController paymentStatisticController;

	@Autowired
	private StateStatisticController stateStatisticController;

	@Autowired
	private StateUserActivityController stateUserActivityController;

	@Autowired
	private TopCityController topCityController;

	@Autowired
	private TopCityEscortController topCityEscortController;

	@Autowired
	private TopEscortController topEscortController;

	@Autowired
	private TopStateController topStateController;

	@Autowired
	private TopStateEscortController topStateEscortController;

	@Test
	void contextLoads() {
		assertNotNull(cityStatisticController);
		assertNotNull(cityUserActivityController);
		assertNotNull(customerStatisticController);
		assertNotNull(escortStatisticController);
		assertNotNull(generalStatisticController);
		assertNotNull(generalUserActivityController);
		assertNotNull(paymentCityStatisticController);
		assertNotNull(paymentStateStatisticController);
		assertNotNull(paymentStatisticController);
		assertNotNull(stateStatisticController);
		assertNotNull(stateUserActivityController);
		assertNotNull(topCityController);
		assertNotNull(topCityEscortController);
		assertNotNull(topEscortController);
		assertNotNull(topStateController);
		assertNotNull(topStateEscortController);
	}

}
