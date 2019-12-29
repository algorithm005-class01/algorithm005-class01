package main

func isAnagram(s string, t string) bool {
	var length  = len(s)
	var i int
	if length != len(t){
		return false
	}

	var h = make(map[string]int, length)

	for i=0;i<length;i++{
		h[string(s[i])]++
	}

	for i=0;i<length;i++{
		h[string(t[i])]--
	}

	for _,length = range h{
		if length != 0 {
			return false
		}
	}

	return true
}