import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime


private object GigasecondConst {
    const val GS_SECONDS: Long = 1000000000 // 10^9 seconds
}

class Gigasecond(inDateTime: LocalDateTime) {
    val date: LocalDateTime = inDateTime.plusSeconds(GigasecondConst.GS_SECONDS)

    constructor(inDate: LocalDate) : this(inDate.atStartOfDay())
}
