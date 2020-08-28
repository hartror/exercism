// Package twofer you and one for me.
package twofer

import ( "fmt" )

// ShareWith returns sentence about sharing with someone.
func ShareWith(name string) string {
	var outName = name
	if outName == "" {
		outName = "you"
	}
	return fmt.Sprintf("One for %s, one for me.", outName)
}
