package g20190343020320

// 190.颠倒二进制位
// https://leetcode-cn.com/problems/reverse-bits/

func ReverseBits(num uint32) uint32 {
	var reNum uint32 = 0

	for i := 0; i < 31; i++ {
		reNum |= num & 1
		num >>= 1
		reNum <<= 1
	}

	return reNum | num&1
}

func ReverseBits_2(num uint32) uint32 {
	var reNum uint32 = 0

	for i := 0; i < 31; i++ {
		reNum = (reNum | num&1) << 1
		num >>= 1
	}

	return reNum | num&1
}
