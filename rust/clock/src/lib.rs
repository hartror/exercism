use std::fmt;

const HOURS_PER_DAY: i32 = 24;
const MINUTES_PER_HOUR: i32 = 60;
const MINUTES_PER_DAY: i32 = HOURS_PER_DAY * MINUTES_PER_HOUR;

#[derive(Debug, PartialEq)]
pub struct Clock {
    hours: i32,
    minutes: i32,
}

impl Clock {
    pub fn new(hours: i32, minutes: i32) -> Self {
        let mut _minutes = ((hours % HOURS_PER_DAY) * MINUTES_PER_HOUR
            + (minutes % MINUTES_PER_DAY))
            % MINUTES_PER_DAY;
        _minutes = if _minutes < 0 {
            MINUTES_PER_DAY + _minutes
        } else {
            _minutes
        };
        Clock {
            hours: _minutes / MINUTES_PER_HOUR,
            minutes: _minutes % MINUTES_PER_HOUR,
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Clock::new(self.hours, self.minutes + (minutes % MINUTES_PER_DAY))
    }
}

impl fmt::Display for Clock {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        write!(f, "{:02}:{:02}", self.hours, self.minutes)
    }
}
