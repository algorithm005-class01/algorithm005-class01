int cmp(const void *p1, const void *p2)
{
	return ((int **)p1)[0][0] - ((int **)p2)[0][0];
}
void testprint(int** intervals, int intervalsSize)
{
	for(int i = 0; i < intervalsSize; i++) {
		//printf("%d %d \n", intervals[i][0], intervals[i][1]);
	}
}
int** merge(int** intervals, int intervalsSize, int* intervalsColSize, int* returnSize, int** returnColumnSizes)
{
	int i;
	int **listOut = (int **)malloc(sizeof(int *) * intervalsSize);
	for (i = 0; i < intervalsSize; i++) {
		listOut[i] = (int *)malloc(sizeof(int) * 2);
	}
	
	int count = 0;
	// sort
	qsort(intervals, intervalsSize, sizeof(intervals[0]), cmp);
	testprint(intervals, intervalsSize);
	
	for (i = 0; i < intervalsSize; i++) {
		
		if (i == 0) {
			count++;
			listOut[count - 1][0] = intervals[i][0];
			listOut[count - 1][1] = intervals[i][1];
			//printf("test1 %d %d %d\n", count, listOut[count - 1][0], listOut[count - 1][1]);
		} else if (intervals[i][0] > listOut[count - 1][1]) {
			count++;
			listOut[count - 1][0] = intervals[i][0];
			listOut[count - 1][1] = intervals[i][1];
			//printf("test2 %d %d %d\n", count, listOut[count - 1][0], listOut[count - 1][1]);
		} else if (intervals[i][1] > listOut[count - 1][1]) {
			listOut[count - 1][1] = intervals[i][1];
			//printf("test3 %d %d %d\n", count, listOut[count - 1][0], listOut[count - 1][1]);
		}
	}
	testprint(listOut, count);
	
	*returnSize = count;
	*returnColumnSizes = (int *)malloc(sizeof(int) * count);
	for (i = 0; i < count; i++) {
		(*returnColumnSizes)[i] = 2;
	}
	
	for (i = count; i < intervalsSize; i++) {
		free(listOut[i]);
		listOut[i] = NULL;
	}
    return listOut;
}

