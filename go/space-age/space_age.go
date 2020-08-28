package space

// Planet a name of a planet in the solar system.
type Planet string

const earthSeconds = 31557600

var planetPeriod = map[Planet]float64{
	"Mercury": 0.2408467,
	"Venus": 0.61519726,
	"Earth": 1.0,
	"Mars": 1.8808158,
	"Jupiter": 11.862615,
	"Saturn": 29.447498,
	"Uranus": 84.016846,
	"Neptune": 164.79132,
}

// Age returns the age of someone on a planet in the solar system.
func Age(ageSeconds float64, planet Planet) float64 {
	if period, ok := planetPeriod[planet]; ok {
		return ageSeconds/(earthSeconds * period)
	}
	// TODO: how do you handle this error?
	return 0.0
}
