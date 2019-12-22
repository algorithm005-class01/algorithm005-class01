#define MAXSIZE 1600
typedef struct {
    int *data;
    int top;
} MinStack;

/** initialize your data structure here. */

MinStack* minStackCreate() {
    MinStack *obj = (MinStack *)malloc(sizeof(MinStack));
    obj->data=(int *)malloc(MAXSIZE*sizeof(int));
    obj->top = -1;
    return obj;
}

void minStackPush(MinStack* obj, int x) {
    if(obj->top == MAXSIZE -1)
    {

    }
    else if(obj->top == -1)
    {
        obj->top ++;
        obj->data[obj->top] = x;
        obj->top ++;
        obj->data[obj->top] = x;
    }
    else
    {
        int tmp = obj->data[obj->top];
        obj->top++;
        obj->data[obj->top]=x;
        if(tmp < x)
        {
            obj->top++;
            obj->data[obj->top] = tmp;
        }
        else
        {
            obj->top++;
            obj->data[obj->top]=x;
        }
    }
}

void minStackPop(MinStack* obj) {
    if(obj->top==-1)
    {

    }
    else{
        obj->top--;
        obj->top--;
    }
}

int minStackTop(MinStack* obj) {
    if(obj->top == -1)
        return;
    return obj->data[obj->top - 1];
}

int minStackGetMin(MinStack* obj) {
  return obj->data[obj->top];
}

void minStackFree(MinStack* obj) {
    free(obj->data);
    obj->data = NULL;
    free(obj);
    obj = NULL;
}

/**
 * Your MinStack struct will be instantiated and called as such:
 * MinStack* obj = minStackCreate();
 * minStackPush(obj, x);
 
 * minStackPop(obj);
 
 * int param_3 = minStackTop(obj);
 
 * int param_4 = minStackGetMin(obj);
 
 * minStackFree(obj);
*/