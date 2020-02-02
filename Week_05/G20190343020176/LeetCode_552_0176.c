int checkRecord(int n){
    ulong m = 1000000007;
    if(n == 1)  return 3;
    if(n == 2)  return 8;

    long a0, a1, a2, a3;
    long p0, p1, p2;
    long l0, l1, l2;

    a1 = 2;
    a2 = 1;
    a3 = 1;
    p2 = 1;
    p1 = 3;
    l1 = 3;

    for(int i = 3;i<=n;i++)
    {
        p0 = (a1+p1+l1)%m;
        a0 = (a1+a2+a3)%m;
        l0 = (p1+a1+p2+a2)%m;

        p2 = p1%m;
        p1 = p0%m;

        a3=a2%m;
        a2=a1%m;
        a1=a0%m;

        l1=l0%m;
    }
    return (a0+p0+l0)%m;
}