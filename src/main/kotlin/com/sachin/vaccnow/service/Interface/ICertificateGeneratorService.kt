package com.sachin.vaccnow.service.Interface

import com.sachin.vaccnow.entity.Schedule

interface ICertificateGeneratorService {

    fun generateCertificate(schedule: Schedule)

}