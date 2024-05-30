package be.dbpieter.utiloverrest.resources

import be.dbpieter.utiloverrest.api.TimeSinceApi
import be.dbpieter.utiloverrest.utilities.DurationToReadableFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController
class TimeSince(private val durationToReadableFormat: DurationToReadableFormat) : TimeSinceApi {


    override fun timeSince(date: OffsetDateTime): ResponseEntity<String> {
        val response = durationToReadableFormat.toReadableDuration(date, OffsetDateTime.now())
        return ResponseEntity.ok(response)
    }

}