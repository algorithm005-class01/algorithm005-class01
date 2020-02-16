bool isPowerOfTwo(int n){
    if(n <= 0)
        return false;

    if((n&(~n+1)) == n)
        return true;
    return false;
}