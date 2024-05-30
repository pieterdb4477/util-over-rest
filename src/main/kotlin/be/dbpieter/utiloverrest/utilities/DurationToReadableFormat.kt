package be.dbpieter.utiloverrest.utilities

import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit
import java.util.*

@Component
class DurationToReadableFormat {

    fun toReadableDuration(leftDate: OffsetDateTime, rightDate: OffsetDateTime): String {
        val joiner = StringJoiner(", ");
        val yearsBetween = ChronoUnit.YEARS.between(leftDate, rightDate);
        val monthsBetween = ChronoUnit.MONTHS.between(leftDate, rightDate.minusYears(yearsBetween));
        val daysBetween =
            ChronoUnit.DAYS.between(leftDate, rightDate.minusYears(yearsBetween).minusMonths(monthsBetween))
        if (yearsBetween != 0L) {
            joiner.add("$yearsBetween years")
        }
        if (monthsBetween != 0L) {
            joiner.add("$monthsBetween months")
        }
        joiner.add("$daysBetween days")
        return joiner.toString();
    }


}