#include <iostream>
#include <vector>
using namespace std;

void merge(vector<int>& nums1, int m, vector<int>& nums2, int n)
{

    int pointer1 = m - 1;
    int pointer2 = n - 1;
    int pointer3 = m + n - 1;
    while (pointer3 >= 0) {
	if (pointer1 == -1) {
	    nums1[pointer3] = nums2[pointer2];
	    --pointer2;
	} else if (pointer2 == -1) {
	    nums1[pointer3] = nums1[pointer1];
	    --pointer1;
	} else if (nums1[pointer1] < nums2[pointer2]) {
	    nums1[pointer3] = nums2[pointer2];
	    --pointer2;
	} else {
	    nums1[pointer3] = nums1[pointer1];
	    --pointer1;
	}
	--pointer3;
    }
}


/*
 *通过重新组织语句，别人的代码更快些
 * */
void merge2(vector<int>& nums1, int m, vector<int>& nums2, int n)
{
    int len = m + n;
    int i = m - 1, j = n - 1;
    while (j >= 0) {
	if (i < 0) {
	    nums1[--len] = nums2[j--];
	    continue;
	}
	if (nums1[i] > nums2[j])
	    nums1[--len] = nums1[i--];
	else if (nums1[i] < nums2[j])
	    nums1[--len] = nums2[j--];
	else if (nums1[i] == nums2[j]) {
	    nums1[--len] = nums1[i--];
	    nums1[--len] = nums2[j--];
	}
    }
}

int main(int argc, char* argv[])
{
    vector<int> a = { 1, 2, 0, 0 };
    vector<int> b = { 1, 2 };
    merge(a, 2, b, 2);
    for (int i = 0; i != 4; ++i) {
	cout << a[i] << " ";
    }
    cout << endl;
    return 0;
}
