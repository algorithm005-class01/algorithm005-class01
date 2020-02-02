/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define SIZE 26
#define LEN 1024
typedef struct TrieNode {
    int count;
    char *words;
    struct TrieNode *children[SIZE];
} Trie;
#define VOS_TRUE  1
#define VOS_FALSE 0
int g_m;
int g_n;
Trie *TrieCreate()
{
    Trie *obj = (Trie *)calloc(1, sizeof(Trie));
    return obj;
}
void TrieInsert(Trie *obj, char *words)
{
    Trie *node = obj;
    if (obj == NULL)
        return;
    char *p = words;
    while (*p) {
        if (node->children[*p - 'a'] == NULL) {
            node->children[*p - 'a'] = TrieCreate();
        }
        node = node->children[*p - 'a'];
        ++p;
    }
    // 最后标记代表单词个数
    node->count += 1;
    //直接保存下来以便回溯使用
    node->words = words;
}
int TrieSearch(Trie *obj, char *word)
{
    if (obj == NULL)
        return VOS_FALSE;
    Trie *node = obj;
    char *p = word;
    while (*p && node != NULL) {
        node = node->children[*p - 'a'];
        p++;
    }
    if (node == NULL) {
        return VOS_FALSE;
    } else if (node->count != 0) {
        return VOS_TRUE;
    }
    return VOS_FALSE;
}
int TrieStartsWith(Trie *obj, char *prefix)
{
    if (obj == NULL || prefix == NULL)
        return VOS_FALSE;
    int len = strlen(prefix);
    if (len <= 0) {
        return VOS_TRUE;
    }
    Trie *node = obj;
    for (int i = 0; i < len; i++) {
        char c = prefix[i];
        if (node == NULL || node->children[c - 'a'] == NULL) {
            return VOS_FALSE;
        }
        node = node->children[c - 'a'];
    }
    return VOS_TRUE;
}
void TrieFree(Trie *obj)
{
    for (int i = 0; i < SIZE; i++) {
        if (obj->children[i] != NULL) {
            TrieFree(obj->children[i]);
            obj->children[i] = NULL;
        }
    }
    free(obj);
    obj = NULL;
}
#define DIR 4
#define VISITED '#'
typedef struct {
    int row;
    int col;
} RoomInfo;
RoomInfo g_dir[DIR] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
void Dfs(char** board, int i, int j, Trie *node, char** rst, int *returnSize) {
    if (i < 0 || j < 0 || i >= g_m || j >= g_n || board[i][j] == VISITED) {
        return;
    }
    char retore = board[i][j];
    node = node->children[retore - 'a'];
    if (node == NULL) return;
    //printf("retore:%c node:%p\n",retore, node);
    if (node->words != NULL) {
        int find = 0;
        for (int i = 0; i < *returnSize; i++) {
            if (strcmp(rst[i], node->words) == 0) {
                find = 1;
            }
        }
        //没找到，添加完之后继续找，不能返回
        if (find == 0) {
            rst[*returnSize] = (char*)calloc(LEN, sizeof(char));
            strcpy(rst[*returnSize], node->words);
            (*returnSize)++;
        }
    }
    //printf("%c str:%s node->count:%d\n", board[i][j],str,node->count);
    board[i][j] = VISITED;
    for (int k = 0; k < DIR; k++) {
        int r = i + g_dir[k].row;
        int c = j + g_dir[k].col;
        Dfs(board, r, c, node, rst, returnSize);
    }
    board[i][j] = retore;
    return;
}
char ** findWords(char** board, int boardSize, int* boardColSize, char ** words, int wordsSize, int* returnSize){
    *returnSize = 0;
    char **rst = (char**)calloc(1024, sizeof(char*));
    Trie * obj = TrieCreate();
    for (int i = 0; i < wordsSize; i++) {
        TrieInsert(obj, words[i]);
    }
    g_m = boardSize;
    g_n = boardColSize[0];
    char str[LEN] = {0};
    for (int i = 0; i < g_m; i++) {
        for (int j = 0; j < g_n; j++) {
            Dfs(board, i, j, obj, rst, returnSize);
        }
    }
    TrieFree(obj);
    return rst;
}

