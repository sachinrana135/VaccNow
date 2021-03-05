package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.Entity.Schedule

interface IEmailService {

    fun sendEmail(schedule: Schedule)

}