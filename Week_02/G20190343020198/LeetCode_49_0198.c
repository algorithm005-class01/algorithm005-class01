//
//  LeetCode_49_0198.c
//  LeetCode-week-02
//
//  Created by lcf on 2019/12/21.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_49_0198.h"
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

int cmpFunc(const void *a, const void *b) { return *(char *)a - *(char *)b; }

//char *** groupAnagrams(char ** strs, int strsSize, int* returnSize, int** returnColumnSizes){
// 
//}

//if (strs.length == 0) return new ArrayList();
//        Map<String, List> ans = new HashMap<String, List>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String key = String.valueOf(ca);
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());


/*
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
   ["ate","eat","tea"],
   ["nat","tan"],
   ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。
 */
