package com.sachin.VaccNow.Service.Interface

import com.sachin.VaccNow.Entity.Schedule

interface ICertificateGeneratorService {

    fun generateCertificate(schedule: Schedule)

}