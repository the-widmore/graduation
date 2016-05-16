package com.ccniit.graduation;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@SuppressWarnings("deprecation")
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BaseTest {

	protected Logger testLog = LoggerFactory.getLogger(BaseTest.class);

}
