package com.sachin.vaccnow.service

import com.sachin.vaccnow.DATE_TIME_FORMAT
import com.sachin.vaccnow.entity.Schedule
import com.sachin.vaccnow.service.Interface.IEmailService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class EmailService : IEmailService {

    private val log = LoggerFactory.getLogger(javaClass.name)

    override fun sendEmail(schedule: Schedule) {
        log.info("###########  Sending mail to " + schedule.email + "##############")
        val dateFormat = SimpleDateFormat(DATE_TIME_FORMAT)
        val msg = """

        Hello ${schedule.email},
        You have scheduled appointment for COVID vaccine ${schedule.vaccine.name} at ${schedule.branch.name} - ${dateFormat.format(schedule.slot)}.
        
        """
        log.info(msg)
    }
}