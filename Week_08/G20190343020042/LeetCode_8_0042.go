func myAtoi(str string) int {
    MIN := -1<<31
    MAX := 1<<31-1
    i := 0
    flag := 1
    if(len(str) == 0){
        return 0
    }
    for str[i] == ' '{
        i++
        if(i >= len(str)){
            return 0
        }
    }
    switch str[i] {
        case '-':
            flag = -1
            i++
        case '+':
            i++
    }
    res := 0
    for i < len(str) && str[i] >= '0' && str[i] <= '9' {
        res = res*10 + int(str[i] - '0') * flag
        i++
        if(res < MIN){
            return MIN
        }
        if(res > MAX){
            return MAX
        }
    }
    return res
}