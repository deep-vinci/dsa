#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

struct Node *top = NULL;

void push(int value)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    if (!newNode)
    {
        printf("Memory overflow! Cannot push %d.\n", value);
        return;
    }
    newNode->data = value;
    newNode->next = top;
    top = newNode;
    printf("%d pushed to stack\n", value);
}

void pop()
{
    if (top == NULL)
    {
        printf("Stack underflow! Cannot pop element.\n");
        return;
    }
    struct Node *temp = top;
    printf("%d popped from stack\n", top->data);
    top = top->next;
    free(temp);
}

void peek()
{
    if (top == NULL)
    {
        printf("Stack is empty. Nothing to peek.\n");
        return;
    }
    printf("Top element is %d\n", top->data);
}

void isEmpty()
{
    if (top == NULL)
        printf("Stack is empty.\n");
    else
        printf("Stack is not empty.\n");
}

void isFull()
{
    struct Node *test = (struct Node *)malloc(sizeof(struct Node));
    if (test == NULL)
        printf("Stack is full (memory limit reached).\n");
    else
    {
        printf("Stack is not full.\n");
        free(test);
    }
}

void display()
{
    if (top == NULL)
    {
        printf("Stack is empty.\n");
        return;
    }

    // to implement link list traverse
    printf("\n");
}

int main()
{
    int choice, value;

    while (1)
    {
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            scanf("%d", &value);
            push(value);
            break;
        case 2:
            pop();
            break;
        case 3:
            peek();
            break;
        case 4:
            isEmpty();
            break;
        case 5:
            display();
            break;
        case 6:
            printf("Exiting...\n");
            exit(0);
        default:
            printf("Invalid operation.\n");
        }
    }

    return 0;
}
