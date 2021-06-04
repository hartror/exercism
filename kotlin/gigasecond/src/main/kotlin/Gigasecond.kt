import java.time.LocalDate
import java.time.LocalDateTime


const val GS_SECONDS: Long = 1000000000 // 10^9 seconds

class Gigasecond(inDateTime: LocalDateTime) {
    val date: LocalDateTime = inDateTime.plusSeconds(GS_SECONDS)

    constructor(inDate: LocalDate) : this(inDate.atStartOfDay())
}
