typedef struct LRUItem {
    int key;
    int value;
    struct LRUItem *next;
    struct LRUItem *prev;

    struct LRUItem *hn;
    struct LRUItem *hp;
} LRUItem;

typedef struct {
    LRUItem *lru;
    LRUItem *data;
    LRUItem **hash;
    int capacity;
    int size;
} LRUCache;

static inline int hash_key(int k, int capacity) {
    return k % capacity;
}

LRUCache* lRUCacheCreate(int capacity) {
    if (capacity == 0)
        return NULL;

    LRUCache *obj = calloc(1, sizeof(LRUCache));
    obj->capacity = capacity;
    obj->data = calloc(capacity, sizeof(LRUItem));
    obj->hash = calloc(capacity, sizeof(void*));

    return obj;
}

static LRUItem *get(LRUCache *obj, int key) {
    int k = hash_key(key, obj->capacity);
    LRUItem *item = obj->hash[k];
    while (item) {
        if (item->key == key) {
            return item;
        }
        item = item->hn;
    }
    return item;
}

int lRUCacheGet(LRUCache* obj, int key) {
    if (obj == NULL)
        return -1;
    LRUItem *item = get(obj, key);

    if (item == NULL)
        return -1;

    if (obj->lru != item) {
        item->prev->next = item->next;
        item->next->prev = item->prev;
        item->next = obj->lru;
        item->prev = obj->lru->prev;
        item->prev->next = item;
        item->next->prev = item;
        obj->lru = item;
    }

    return item->value;
}

void lRUCachePut(LRUCache* obj, int key, int value) {
    if (obj == NULL)
        return ;
    int k = hash_key(key, obj->capacity);
    LRUItem *item = get(obj, key);

    if (item) {
        item->value = value;
        if (obj->lru != item) {
            item->prev->next = item->next;
            item->next->prev = item->prev;
            item->next = obj->lru;
            item->prev = obj->lru->prev;
            item->prev->next = item;
            item->next->prev = item;
            obj->lru = item;
        }
        return ;
    }

    if (obj->size < obj->capacity) {
        item = &obj->data[obj->size ++];
        item->key = key;
        item->value = value;
        if (obj->size == 1) {
            item->prev = item;
            item->next = item;
        } else {
            item->next = obj->lru;
            item->prev = obj->lru->prev;
            item->next->prev = item;
            item->prev->next = item;
        }

        obj->lru = item;
    } else {
        item = obj->lru->prev;
        int ok = hash_key(item->key, obj->capacity);
        if (item == obj->hash[ok]) {
            obj->hash[ok] = item->hn;
            if (obj->hash[ok])
                obj->hash[ok]->hp = NULL;
        } else {
            item->hp->hn = item->hn;
            if (item->hn)
                item->hn->hp = item->hp;
        }
        obj->lru = item;
        item->key = key;
        item->value = value;
    }
    item->hp = NULL;
    item->hn = obj->hash[k];
    if (obj->hash[k])
        obj->hash[k]->hp = item;
    obj->hash[k] = item;
}

void lRUCacheFree(LRUCache* obj) {
    if (obj == NULL)
        return ;
    free(obj->data);
    free(obj->hash);
    free(obj);
}