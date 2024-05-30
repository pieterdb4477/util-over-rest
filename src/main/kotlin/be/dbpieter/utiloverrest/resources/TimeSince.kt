package be.dbpieter.utiloverrest.resources

import be.dbpieter.utiloverrest.api.TimeSinceApi
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.OffsetDateTime

@RestController
class TimeSince : TimeSinceApi {

    override fun timeSince(date: OffsetDateTime): ResponseEntity<String> {
        val diff = Duration.between(OffsetDateTime.now(), date)
        return ResponseEntity.ok(diff.toString())
    }

}