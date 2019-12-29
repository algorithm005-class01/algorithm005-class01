//
//  LeetCode_01_0198.c
//  LeetCode-week-02
//
//  Created by cf on 2019/12/22.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_01_0198.h"
#include <malloc/_malloc.h>
#include <string.h>
#include <stdlib.h>

struct HashNode;
typedef struct HashNode *Position;
typedef Position List;

struct HashTbl;
typedef struct HashTbl *HashTable;


struct HashNode {
    int key;
    int data;
    struct HashNode * Next;
};

struct HashTbl {
    int TableSize;    // 容量
    struct HashNode **TheLists;   // 链表数组
};

static int
NextPrime( int N ) {
    int i;

    if( N % 2 == 0 )
        N++;
    for( ; ; N += 2 )
    {
        for( i = 3; i * i <= N; i += 2 )
            if( N % i == 0 )
                goto ContOuter;  /* Sorry about this! */
        return N;
      ContOuter: ;
    }
}

// 整数的哈希函数(散列函数)
int
Hash( int Key, int TableSize ) {
    
  return abs(Key) % TableSize;
};

// 初始化
int
InitializeTable(struct HashTbl * Table, int TableSize) {
    if (TableSize <= 0) {
        return -1;
    }
    List *tmp = malloc(sizeof(struct HashNode *) * TableSize);
    if (tmp == NULL) {
        return -1;
    }
    Table->TheLists = tmp;
    
    memset(Table->TheLists, 0, TableSize * sizeof(struct HashNode *));
    Table->TableSize = TableSize;
    return 0;
}

// 销毁哈希表
void
DestroyTable(HashTable H) {
    int i;
    for (i = 0; i < H->TableSize; ++i) {
        Position P = H->TheLists[i];
        List Tmp;
        while (P != NULL) {
            Tmp = P->Next;
            free(P);
            P = Tmp;
        }
    }
    free(H->TheLists);
    free(H);
}

// 插入一个元素
int Insert(HashTable Table, int key, int data) {
    Position tmp = malloc(sizeof(struct HashNode));
    if (tmp == NULL) {
        return -1;
    }
    tmp->key = key;
    tmp->data = data;
    int k = Hash(key, Table->TableSize);
    tmp->Next = Table->TheLists[k];
    Table->TheLists[k] = tmp;
    return 0;
}

Position
Find(HashTable Table,int key) {
    int k = Hash(key, Table->TableSize);
    Position P = Table->TheLists[k];
    while (P != NULL && P->key != key) {
        P = P->Next;
    }
    return P;
}

/// 两遍Hash
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    
    int *rets = malloc(sizeof(int) * 2);
    *returnSize = 0;
    HashTable Table = malloc(sizeof(struct HashTbl));
    InitializeTable(Table, 100);
    for (int i = 0; i < numsSize; ++i) {
        Insert(Table, nums[i], i);
    }
    for (int i = 0; i < numsSize; ++i) {
        int value = target - nums[i];
        struct HashNode * P = Find(Table, value);
        if (P != NULL && P->data != i) {
            rets[0] = P->data;
            rets[1] = i;
            *returnSize = 2;
        }
    }
    DestroyTable(Table);
    return rets;
}

// 一遍 hash
int* ohtertwoSum(int* nums, int numsSize, int target, int* returnSize) {
 
    int *rets = malloc(sizeof(int) * 2);
    *returnSize = 0;
    HashTable Table = malloc(sizeof(struct HashTbl));
    InitializeTable(Table, 100);
    for (int i = 0; i < numsSize; ++i) {
        int value = target - nums[i];
        Position P = Find(Table, value);
        if (P != NULL && P->data != i) {
            rets[0] = P->data;
            rets[1] = i;
            *returnSize = 2;
            break;
        }
        Insert(Table, nums[i], i);
    }
    return rets;
}

/*
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
