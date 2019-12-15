{\rtf1\ansi\ansicpg936\cocoartf1404\cocoasubrtf110
{\fonttbl\f0\fnil\fcharset0 Menlo-Regular;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;\red255\green255\blue254;\red0\green0\blue255;
\red19\green120\blue72;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\sl400\partightenfactor0

\f0\fs26 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 \
class Solution \{\
    public int[] twoSum(int[] nums, int target) \{\
        Map<Integer,Integer> map = new HashMap<>();\
        int minisNum;\
        for(int i=0;i<nums.length;i++)\
        \{\
            minisNum = target - nums[i];\
            if (map.containsKey(minisNum))\
            \{\
                return new int[]\{map.get(minisNum),i\};\
            \}\
            map.put(nums[i],i);\
        \}\
        throw new IllegalArgumentException("No two sum solution");\
    \}\
\}\
\pard\pardeftab720\sl400\partightenfactor0
\cf2 \cb1 \
\
\pard\pardeftab720\sl400\partightenfactor0
\cf4 \cb3 \strokec4 class\cf2 \strokec2 \'a0Solution\'a0\{\cb1 \
\pard\pardeftab720\sl400\partightenfactor0
\cf2 \cb3 \'a0\'a0\'a0\'a0\cf4 \strokec4 public\cf2 \strokec2 \'a0\cf4 \strokec4 int\cf2 \strokec2 []\'a0plusOne(\cf4 \strokec4 int\cf2 \strokec2 []\'a0digits)\'a0\{\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\cf4 \strokec4 for\cf2 \strokec2 \'a0(\cf4 \strokec4 int\cf2 \strokec2 \'a0i\'a0=\'a0digits.length\'a0-\'a0\cf5 \strokec5 1\cf2 \strokec2 ;\'a0i\'a0>=\'a0\cf5 \strokec5 0\cf2 \strokec2 ;\'a0i--)\'a0\{\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0digits[i]++;\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0digits[i]\'a0%=\'a0\cf5 \strokec5 10\cf2 \strokec2 ;\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\cf4 \strokec4 if\cf2 \strokec2 \'a0(digits[i]\'a0!=\'a0\cf5 \strokec5 0\cf2 \strokec2 )\'a0\cf4 \strokec4 return\cf2 \strokec2 \'a0digits;\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\}\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0digits\'a0=\'a0\cf4 \strokec4 new\cf2 \strokec2 \'a0\cf4 \strokec4 int\cf2 \strokec2 [digits.length\'a0+\'a0\cf5 \strokec5 1\cf2 \strokec2 ];\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0digits[\cf5 \strokec5 0\cf2 \strokec2 ]\'a0=\'a0\cf5 \strokec5 1\cf2 \strokec2 ;\cb1 \
\cb3 \'a0\'a0\'a0\'a0\'a0\'a0\'a0\'a0\cf4 \strokec4 return\cf2 \strokec2 \'a0digits;\cb1 \
\cb3 \'a0\'a0\'a0\'a0\}\cb1 \
\cb3 \}\cb1 \
}