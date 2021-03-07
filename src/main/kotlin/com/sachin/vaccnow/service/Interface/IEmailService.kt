package com.sachin.vaccnow.service.Interface

import com.sachin.vaccnow.entity.Schedule

interface IEmailService {

    fun sendEmail(schedule: Schedule)

}