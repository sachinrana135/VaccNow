package com.sachin.vaccnow.service

import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import com.sachin.vaccnow.DATE_FORMAT
import com.sachin.vaccnow.entity.Schedule
import com.sachin.vaccnow.service.Interface.ICertificateGeneratorService
import org.springframework.stereotype.Service
import java.io.FileOutputStream
import java.time.format.DateTimeFormatter


@Service
class CertificateGeneratorService : ICertificateGeneratorService {
    override fun generateCertificate(schedule: Schedule) {

        val document = Document()
        PdfWriter.getInstance(document, FileOutputStream(schedule.email + ".pdf"))

        val dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT)
        document.open()
        val font: Font = FontFactory.getFont(FontFactory.COURIER, 16f, BaseColor.BLACK)
        val chunk = Chunk("Vaccine Certificate\n\n", font)
        document.add(chunk)

        val content = StringBuilder().append("This is certified that user ")
                .append(schedule.email)
                .append(" is vaccinated on ")
                .append(schedule.dateModified.toLocalDateTime().format(dateTimeFormatter))
                .append("\n")
                .append("by VaccNow.\n\n")
                .append("Thanks")
                .toString()
        val para = Paragraph(content)
        document.add(para)
        document.close()
    }
}