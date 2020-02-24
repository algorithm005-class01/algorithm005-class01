class Solution:
    def myAtoi(self, str: str) -> int:
        s = str.strip()
        if not s: return 0
        top = s[0]
        d = ''
        c = ''
        if top.isdigit():
            d = top
        elif top in ('-', '+'):
            c = top
        else:
            return 0

        for i in s[1:]:
            if i.isdigit():
                d += i
            else:
                break

        if not d: return 0

        if int(d) > pow(2, 31):
            return -pow(2, 31) if c == '-' else pow(2, 31) - 1
        elif int(d) == pow(2, 31):
            return -pow(2, 31) if c == '-' else pow(2, 31) - 1
        else:
            return -int(d) if c == '-' else int(d)
